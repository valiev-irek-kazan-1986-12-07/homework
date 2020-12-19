public class Generator {

    private Field field;

    public Generator() {
        field = new Field(50);
        field.initRandom();
    }

    public void generateWithThreads(int steps) throws InterruptedException {
        System.out.println("Many threads");
        for (int i = 0; i < steps; i++) {
            field.print();
            setMatrix();
        }
    }

    private void setMatrix() throws InterruptedException {
        Character[][] newMatrix = new Field(field.getSize()).getMatrix();
        Thread[] threads = new Thread[field.getSize()];
        for (int row = 0; row < field.getSize(); row++) {
            int finalRow = row;
            threads[row] = new Thread(new Runnable() {
                @Override
                public void run() {
                    newMatrix[finalRow] = getRow(finalRow);
                }
            });
            threads[row].start();
        }
        for (int row = 0; row < field.getSize(); row++) {
            threads[row].join();
        }
        field.setMatrix(newMatrix);
    }

    private Character[] getRow(int row) {
        Character[] array = new Character[field.getSize()];
        for (int col = 0; col < field.getSize(); col++) {
            if (isAlive(field.getMatrix(), row, col)) {
                array[col] = Field.ELEM;
            } else {
                array[col] = Field.EMPTY;
            }
        }
        return array;
    }

    public void generate(int steps) {
        System.out.println("One thread");
        for (int i = 0; i < steps; i++) {
            getField().print();
            generate();
        }
    }

    private void generate() {
        Character[][] newMatrix = new Field(field.getSize()).getMatrix();
        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                if (isAlive(field.getMatrix(), i, j)) {
                    newMatrix[i][j] = Field.ELEM;
                }
            }
        }
        field.setMatrix(newMatrix);
    }

    private boolean isAlive(Character[][] matrix, int i, int j) {
        int count = 0;
        int size = matrix.length;

        if (matrix[i][j - 1 < 0 ? size - 1 : j - 1] == Field.ELEM) {
            count++;
        }
        if (matrix[i - 1 < 0 ? size - 1 : i - 1][j - 1 < 0 ? size - 1 : j - 1] == Field.ELEM) {
            count++;
        }
        if (matrix[i - 1 < 0 ? size - 1 : i - 1][j] == Field.ELEM) {
            count++;
        }
        if (matrix[i][j + 1 == size ? 0 : j + 1] == Field.ELEM) {
            count++;
        }
        if (matrix[i + 1 == size ? 0 : i + 1][j + 1 == size ? 0 : j + 1] == Field.ELEM) {
            count++;
        }
        if (matrix[i + 1 == size ? 0 : i + 1][j] == Field.ELEM) {
            count++;
        }
        return matrix[i][j] == Field.ELEM && (count == 2 || count == 3) ||
                matrix[i][j] == Field.EMPTY && count == 3;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }
}