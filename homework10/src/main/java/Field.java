import java.util.Random;

public class Field {

    public static final char EMPTY = 'O';
    public static final char ELEM = '1';

    private Character[][] matrix;

    public Field(int size) {
        matrix = new Character[size][size];
        initEmpty();
    }

    public Field(Character[][] matrix) {
        this.matrix = matrix;
    }

    public void initRandom() {
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = random.nextBoolean() ? ELEM : EMPTY;
            }
        }
    }

    public void initEmpty() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = EMPTY;
            }
        }
    }

    public void print() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int getSize() {
        return matrix.length;
    }

    public Character[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(Character[][] matrix) {
        this.matrix = matrix;
    }
}
