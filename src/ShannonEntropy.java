public class ShannonEntropy {

    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] counts = new int[m+1];
        double[] ratios = new double[m+1];
        double[] logs = new double[m+1];
        double shannon_entropy = 0;
        double total = 0;

        while (!StdIn.isEmpty()) {
            int number = StdIn.readInt();
            counts[number] ++;
        }
        for (int i = 1;i < counts.length ;i++ ) {
            total += counts[i];
        }
        for (int i = 1; i < counts.length; i++) {
            ratios[i] = counts[i] / total;
        }
        for (int i = 1;i < ratios.length ;i++ ) {
            if (ratios[i] > 0) {
                logs[i] = -((ratios[i]) * Math.log(ratios[i])/Math.log(2));
            }
        }
        for (int i = 1; i < logs.length; i++) {
            shannon_entropy += logs[i];
        }

        StdOut.printf("%.4f\n", shannon_entropy);

    }

}
