import java.io.IOException;

public class LifeBegin {

    public static void main(String[] args) throws IOException, InterruptedException {

        String in = args[0];
        String out = args[1];
        int steps = Integer.parseInt(args[2]);

        Generator generator = new Generator();
        Character[][] matrix = MyUtil.readFile("homework10\\src\\main\\resources\\" + in);
        generator.setField(new Field(matrix));

        long startOne = System.currentTimeMillis();
        generator.generate(steps);
        long timeOne = System.currentTimeMillis() - startOne;

        generator.setField(new Field(matrix));
        long startMany = System.currentTimeMillis();
        generator.generateWithThreads(steps);
        long timeMany = System.currentTimeMillis() - startMany;

        System.out.println("One thread: " + timeOne + "ms");
        System.out.println("Many threads: " + timeMany + "ms");

        MyUtil.writeFile("homework10\\src\\main\\resources\\" + out, generator.getField().getMatrix());
    }
}