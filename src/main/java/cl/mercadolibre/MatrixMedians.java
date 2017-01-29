package cl.mercadolibre;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MatrixMedians {

    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int i = 0;
        int[][] matrix = new int[n][n];
        while (i < n && scanner.hasNextLine()) {
            String[] split = scanner.nextLine().split(" ");
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = Integer.parseInt(split[j]);
            }
            ++i;
        }
        int m = Integer.parseInt(scanner.nextLine());
        int[][] queries = new int[m][4];
        i = 0;
        while (i < m && scanner.hasNextLine()) {
            String[] split = scanner.nextLine().split(" ");
            for (int j = 0; j < 4; ++j) {
                queries[i][j] = Integer.parseInt(split[j]);
            }
            ++i;
        }
        for (int j = 0; j < m; j++) {
            int median = calculateMedian(matrix, queries[j][0] - 1, queries[j][2] - 1, queries[j][1] - 1, queries[j][3] - 1);
            System.out.println(median);
        }
        scanner.close();
    }

    public static int calculateMedian(int[][] matrix, int xMin, int xMax, int yMin, int yMax) {
        List<Integer> elements = new ArrayList<>();
        for (int i = xMin; i <= xMax; ++i) {
            for (int j = yMin; j <= yMax; ++j) {
                elements.add(matrix[i][j]);
            }
        }
        Collections.sort(elements);
        int half = elements.size() / 2;
        if (elements.size() % 2 != 0) {
            return elements.get(half);
        } else {
            return (elements.get(half) + elements.get(half - 1)) / 2;
        }
    }

    public static void printMatrix(int[][] matrix) {
        System.out.println("Print matrix");
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}