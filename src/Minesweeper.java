public class Minesweeper {

    public static void main(String[] args) {

        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        boolean[][] mines = new boolean[m][n];
        int[][] count = new int[m+1][n+1];

        //populate mines
        for (int i = 0; i < k; i++) {
            int cell1 = StdRandom.uniform(m);
            int cell2 = StdRandom.uniform(n);
            // if same numbers are generated, repeat last step
            if (!mines[cell1][cell2]) {
                mines[cell1][cell2] = true;
            }
            else {
                i--;
            }

        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mines[i][j]){
                    count[i][j] = -1;
                }
                else {
                    count[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mines[i][j]) {
                    System.out.print(" * ");
                }
                else {
                    int counter = 0;
                    for (int ii = i - 1; ii <= i + 1; ii++) {
                        for (int jj = j - 1; jj <= j + 1; jj++) {
                            if (ii >= 0 && ii < m && jj>= 0 && jj < n) {
                                if (count[ii][jj] == -1) {
                                    counter += 1;
                                }
                            }
                        }
                    }
                    System.out.print(" " + counter + " ");
                }

            }
            System.out.println();
        }

    }

}
