public class Divisors {

    // Returns the greatest common divisor of a and b.
    public static int gcd(int a, int b) {
        if (a == 0 && b == 0) {
            return 0;
        }
        if (b == 0) {
            return Math.abs(a);
        } else {
            int a1 = Math.abs(a);
            int b1 = Math.abs(b);
            while (b1 > 0) {
                int temp = b1;
                b1 = a1 % b1;
                a1 = temp;
            }
            return a1;
        }
    }

    // Returns the least common multiple of a and b.
    public static int lcm(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        } else {
            return (Math.abs(a) * Math.abs(b)) / (gcd(a, b));
        }
    }

    // Returns true if a and b are relatively prime; false otherwise.
    public static boolean areRelativelyPrime(int a, int b) {
        return gcd(a, b) == 1;
    }

    // Returns the number of integers between 1 and n that are
    // relatively prime with n.
    public static int totient(int n) {
        if (n <= 0) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (areRelativelyPrime(i, n)) {
                count++;
            }
        }
        return count;
    }

    // Takes two integer command-line arguments a and b and prints
    // each function, evaluated in the format (and order) given below.
    public static void main(String[] args) {
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        System.out.println("gcd(" + num1 + ", " + num2 + ") = " + gcd(num1, num2));
        System.out.println("lcm(" + num1 + ", " + num2 + ") = " + lcm(num1, num2));
        System.out.println("areRelativelyPrime(" + num1 + ", " + num2 + ") = " + areRelativelyPrime(num1, num2));
        System.out.println("totient(" + num1 + ") = " + totient(num1));
        System.out.println("totient(" + num2 + ") = " + totient(num2));
    }
}
