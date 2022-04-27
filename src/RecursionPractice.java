public class RecursionPractice {

    public static int fibo(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibo(n - 1) + fibo(n - 2);
        }
    }

    static long[] memo = new long[100];

    public static long F(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (memo[n] == 0) {
            memo[n] = F(n - 1) + F(n - 2);
        }
        return memo[n];
    }

    public static int Q2(int n) {
        if (n <= 0) return 1;
        return 1 + Q2(n - 2) + Q2(n - 3);
    }

    public static void Q3(int n) {
        if (n <= 0) return;
        StdOut.println(n);
        Q3(n - 2);
        Q3(n - 3);
        StdOut.println(n);
    }

    public static void Q4(int n) {
        if (n <= 0) return;
        StdOut.println(n);
        Q4(n - 2);
        Q4(n - 3);
        StdOut.println(n);
    }

    public static int Q5(int n) {
        int[] b = new int[n + 1];
        b[0] = 1;
        for (int i = 2; i <= n; i++) {
            b[i] = 0;
            for (int j = 0; j < i; j++)
                b[i] += b[j];
        }
        return b[n];
    }

    public static void main(String[] args) {
        System.out.println(Q5(9));
    }

}
