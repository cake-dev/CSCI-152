import java.util.Arrays;

public class MaximumSquareSubmatrix {

    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {
        // this alogrithm was inspired by my cs 151 solution (python)
        int[][] a1 = new int[a.length][a.length];

        //create count array a1 to count size of submatrices with bottom right corner at a1[i][j]
        //set values equal to first row and col of array a
        //then fill in the rest of the values with the algorithm
        for (int i = 0; i < a.length; i++) {
            a1[i][0] = a[i][0];
            a1[0][i] = a[0][i];
        }

        for (int row = 1; row < a.length; row++) {
            for (int col = 1; col < a.length; col++) {
                if (a[row][col] == 1) {
                    a1[row][col] = Math.min(a1[row][col - 1], Math.min(a1[row - 1][col], a1[row - 1][col - 1])) + 1;
                } else {
                    a1[row][col] = 0;
                }
            }
        }
        // https://www.techiedelight.com/find-minimum-maximum-element-array-java/
        int[] maxes = new int[a.length];
        for (int i = 0; i < a1.length; i++) {
            int val = Arrays.stream(a1[i]).max().getAsInt();
            maxes[i] = val;
        }

        return Arrays.stream(maxes).max().getAsInt();
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        int len = StdIn.readInt();
        int[][] matrix = new int[len][len];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = StdIn.readInt();
            }
        }
        System.out.println(size(matrix));
    }

}
