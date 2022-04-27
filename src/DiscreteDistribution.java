public class DiscreteDistribution {

    public static void main(String[] args) {

        int m = Integer.parseInt(args[0]);
        int length = args.length-1;
        int[] a = new int[length];
        // length + 1 because element 0 must be 0
        int[] sums = new int[length+1];
        sums[0] = 0;

        for (int i = 0; i < length; i++) {
            a[i] = Integer.parseInt(args[i+1]);
            sums[i+1] = sums[i] + a[i];
        }
        int counter = 0;
        for (int i = 0; i < m; i++) {

            int r = StdRandom.uniform(0, sums[sums.length-1]);

            for (int j = 1; j <= sums.length; j++) {
                if (sums[j-1] <= r && r < sums[j]) {
                    if (counter >= 25) {
                        System.out.println();
                        counter = 0;
                    }
                    System.out.print(j + " ");
                    counter++;
                }
            }
        }

    }

}
