package com.gslonim.coding.algo;

public class ZeroMatrix {
    public static Matrix zeroMatrix(Matrix matrix) {
        boolean[] zeroFlags = new boolean[matrix.length()];
        processRows(matrix, zeroFlags);
        processColumns(matrix, zeroFlags);
        return matrix;
    }

    private static void processColumns(Matrix matrix, boolean[] zeroFlags) {
        for (int i = 0; i < matrix.height(); i++) {
            for (int j = 0; j < zeroFlags.length; j++) {
                if(zeroFlags[j]) {
                    matrix.setElementAt(i, j, 0);
                }
            }
        }
    }

    private static void processRows(Matrix matrix, boolean[] zeroFlags) {
        for(int i = 0; i < matrix.height(); i++) {
            for (int j = 0; j < matrix.length(); j++) {
                if (matrix.elementAt(i, j) == 0) {
                    nullyfyRow(matrix.rowAt(i));
                    zeroFlags[j] = true;
                    break;
                }
            }
        }
    }

    private static void nullyfyRow(int[] row) {
        for (int i = 0; i < row.length; i++) {
            row[i] = 0;
        }
    }

    public static void main (String[] arguments) {
        int[][] matrix = new int[][] {
                {1, 2, 4, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 0, 5},
                {1, 2, 3, 4, 5},
        };

        System.out.println(zeroMatrix(new Matrix(matrix)));
    }
    static class Matrix {
        private final int[][] matrix;

        Matrix(int[][] matrix) {
            this.matrix = matrix;
        }
        public int height() {
            return matrix.length;
        }

        public int length() {
            return matrix[0].length;
        }

        public int elementAt(int y, int x) {
            return matrix[y][x];
        }
        public int[] rowAt(int y) {
            return matrix[y];
        }
        public void setElementAt(int y, int x, int value) {
            matrix[y][x] = value;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < matrix.length; i++) {
                sb.append("[ ");
                for (int j = 0; j < matrix[0].length; j++) {
                    sb.append(matrix[i][j]);
                    if ((j + 1) != matrix[0].length) {
                        sb.append(",");
                    }
                }
                sb.append("]").append(System.lineSeparator());
            }
            return sb.toString();
        }
    }
}
