public class TrinomialDP {

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        if (k < -n || k > n) {
            return 0;
        }
        // had an out of bounds error with n+ 1 so I doubled the sizes
        long[][] tris = new long[2 * n + 1][2 * n + 1];
        k = Math.abs(k);
        //because trinomial = 1 when n==0, k==0
        tris[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    tris[i][j] = tris[i - 1][j] + tris[i - 1][j + 1] * 2;
                } else {
                    tris[i][j] = tris[i - 1][j - 1] + tris[i - 1][j] + tris[i - 1][j + 1];
                }
            }
        }

        return tris[n][k];
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        StdOut.println(trinomial(n, k));
    }

}
