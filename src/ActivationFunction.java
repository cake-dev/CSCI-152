public class ActivationFunction {


    // Returns the Heaviside function of x.
    public static double heaviside(double x) {
        if (Double.isNaN(x)) {
            return Double.NaN;
        }
        if (x < 0) {
            return 0;
        } else if (x == 0) {
            return 0.5;
        } else if (x > 0) {
            return 1;
        } else {
            return -1;
        }
    }

    // Returns the sigmoid function of x.
    public static double sigmoid(double x) {
        if (Double.isNaN(x)) {
            return Double.NaN;
        }
        return (1 / (1 + Math.exp(-x)));
    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x) {
        if (Double.isNaN(x)) {
            return Double.NaN;
        }
        return ((Math.exp(x) - Math.exp(-x)) / (Math.exp(x) + Math.exp(-x)));
    }

    // Returns the softsign function of x.
    public static double softsign(double x) {
        if (Double.isNaN(x)) {
            return Double.NaN;
        }
        return ((x) / (1 + Math.abs(x)));
    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x) {
        if (Double.isNaN(x)) {
            return Double.NaN;
        }
        if (x <= -2) {
            return -1;
        } else if (x > -2 && x < 0) {
            return (x + (Math.pow(x, 2) / 4));
        } else if (x >= 0 && x < 2) {
            return (x - (Math.pow(x, 2) / 4));
        } else if (x >= 2) {
            return 1;
        } else {
            return -1;
        }

    }

    // Takes a double command-line argument x and prints each activation
    // function, evaluated, in the format (and order) given below.
    public static void main(String[] args) {
        double n = Double.parseDouble(args[0]);
        String w = "%9s(%.1f) = %.16f%n";
        StdOut.printf(w, "heaviside", n, heaviside(n));
        StdOut.printf(w, "sigmoid", n, sigmoid(n));
        StdOut.printf(w, "tanh", n, tanh(n));
        StdOut.printf(w, "softsign", n, softsign(n));
        StdOut.printf(w, "sqnl", n, sqnl(n));
    }

}
