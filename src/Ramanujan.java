public class Ramanujan {

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        int count = 0;
        double b_n = 0;
        long end = 0;
        for (long i = 1; i < Math.cbrt(n); i++) {
            double b_val = Math.cbrt((n - Math.pow(i, 3)));
            if (b_val % 1 == 0) {
                count++;
                b_n = b_val;
                end = i + 1;
                break;
            }
        }
        for (long i = end; i < Math.cbrt(n); i++) {
            double d_val = Math.cbrt((n - Math.pow(i, 3)));
            if (d_val % 1 == 0 && i != b_n) {
                count++;
                break;
            }
        }

        return count >= 2;
    }

    public static String method3(int n) {
        if (n == 0) return "";
        if (n == 1) return "x";
        return method3(n / 2) + method3(n - n / 2);
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        System.out.println(isRamanujan(n));
        System.out.println(method3(5));
    }
}
