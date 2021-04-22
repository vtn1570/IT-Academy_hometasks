package by.it.voytsekhovskiy.jd01_07;

public class Matrix extends Var {
    private final double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix(String strMatrix) {
        String[] arrayRows = strMatrix.split("},"); // разбив матрицы на части
        int rowCount = arrayRows.length;
        int colCount = arrayRows[0].split(",").length;
        double[][] matrix = new double[rowCount][colCount];

        for (int i = 0; i < arrayRows.length; i++) {
            arrayRows[i] = arrayRows[i].replaceAll("[{}]", ""); // удаление лишних символов
        }

        for (int i = 0; i < matrix[0].length; i++) { // заполнение матрицы
            String[] arrayCols = arrayRows[i].split(",");
            for (int j = 0; j < arrayCols.length; j++) {
                matrix[i][j] = Double.parseDouble(arrayCols[j]);
            }
        }
        this.value = matrix;
    }

    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder();
        resultString.append("{");
        for (int i = 0; i < value[0].length; i++) {
            resultString.append("{");
            for (int j = 0; j < value[1].length; j++) {
                resultString.append(value[i][j]);
                if (j != value.length - 1) {
                    resultString.append(", ");
                }
            }
            resultString.append("}");
            if (i != value[0].length - 1) {
                resultString.append(", ");
            }
        }
        resultString.append("}");
        return resultString.toString();
    }
}
