import java.io.File;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException,
            ClassNotFoundException {
        Worker worker = new SomeClass();
        System.out.println("Исходный файл:");
        worker.doWork();
        String newCode = NewUtil.getNewCode();
        File newFile = new File("homework8.2\\src\\main\\java\\SomeClass.java");
        NewUtil.createAndCompile(newFile, newCode);
        worker = NewUtil.loadClass("SomeClass");
        System.out.println("Файл после изменения.");
        worker.doWork();
    }
}
