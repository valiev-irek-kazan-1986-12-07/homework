import java.io.*;

public class MyUtil {

    public static Character[][] readFile(String name) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(name)));
        Character[][] matrix = new Character[10][10];
        for (int i = 0; i < matrix.length; i++) {
            String[] els = bufferedReader.readLine().trim().split(" ");
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = els[j].charAt(0);
            }
        }
        bufferedReader.close();
        return matrix;
    }

    public static void writeFile(String name, Character[][] matrix) throws IOException {
        FileWriter fileWriter = new FileWriter(new File(name));
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                fileWriter.write(matrix[i][j] + " ");
            }
            fileWriter.write("\n");
        }
        fileWriter.close();
    }
}