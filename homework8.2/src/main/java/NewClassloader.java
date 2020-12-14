import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NewClassloader extends ClassLoader {

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if ("SomeClass".equals(name)) {
            return findClass(name);
        }
        return super.loadClass(name);
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        if ("SomeClass".equals(name)) {
            try {
                byte[] bytes = Files.readAllBytes(Paths.get("homework8.2\\src\\main\\java\\SomeClass.class"));
                return defineClass(name, bytes, 0, bytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return super.findClass(name);
    }
}
