import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Clean {

    public void cleanup(Object object, Set<String> fieldsToCleanup, Set<String> fieldsToOutput) {
        Class<?> clazz = object.getClass();
        if (itsMap(clazz)) {
            cleanOutputForMap(object, fieldsToCleanup, fieldsToOutput);
        } else forFields(object, fieldsToCleanup, fieldsToOutput, clazz);
    }

    public boolean itsMap(Class<?> clazz) {
        Class<?>[] allInterface = clazz.getInterfaces();
        for (Class<?> inter : allInterface) {
            if (Objects.equals(inter.getName(), "Map")) {
                return true;
            }
        }
        return false;
    }

    public void cleanOutputForMap(Object object, Set<String> fieldsToCleanup, Set<String> fieldsToOutput) {
        Map<?, ?> bufferMap = (Map<?, ?>) object;
        Iterator<String> iteratorForCleanup = fieldsToCleanup.iterator();
        Iterator<String> iteratorForOutput = fieldsToOutput.iterator();

        while (iteratorForCleanup.hasNext()) {
            String k = iteratorForCleanup.next();
            if (bufferMap.containsKey(k)) {
                bufferMap.remove(k);
            } else throw new IllegalArgumentException("Поля отсутствуют");
        }

        while (iteratorForOutput.hasNext()) {
            String k = iteratorForOutput.next();
            if (bufferMap.containsKey(k)) {
                System.out.println(bufferMap.get(k).toString());
            } else throw new IllegalArgumentException("Поля отсутствуют");
        }
    }

    public void forFields(Object object, Set<String> fieldsToCleanup, Set<String> fieldsToOutput, Class<?> clazz) {
        Iterator<String> iteratorForCleanup = fieldsToCleanup.iterator();
        Iterator<String> iteratorForOutput = fieldsToOutput.iterator();

        while (iteratorForCleanup.hasNext()) {
            try {
                Field field = clazz.getDeclaredField(iteratorForCleanup.next());
                field.setAccessible(true);
                set(object, field);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new IllegalArgumentException("Поля отсутствуют");
            }
        }

        while ((iteratorForOutput.hasNext())) {
            try {
                Field field = clazz.getDeclaredField(iteratorForOutput.next());
                if (field.getType().isPrimitive()) {
                    System.out.println(String.valueOf(field));
                } else System.out.println(field.toString());

            } catch (NoSuchFieldException e) {
                throw new IllegalArgumentException("Поля отсутствуют");
            }
        }
    }

    public void set(Object o, Field field) throws IllegalAccessException {
        if (field.getType().isPrimitive()) {
            if (field.getType().getName().equals("boolean")) {
                field.setBoolean(o, false);
            } else if (field.getType().getName().equals("char")) {
                field.setChar(o, '\u0000');
            } else field.set(o, 0);
        } else field.set(o, null);
    }
}
