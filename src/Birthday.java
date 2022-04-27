public class Birthday {

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        if (n<=0) {n=1;}
        int trials = Integer.parseInt(args[1]);
        Boolean[] hit = new Boolean[n];
        for (int i = 0; i < n; i++) {hit[i] = false;}
        int[] count = new int[n];
        double stop_frac = 0.0;

        // run birthday trials
        for (int i = 0; i < trials; i++) {
            for (int j = 0; j < n; j++) {
                int bday = StdRandom.uniform(n-1);
                if (hit[bday]) {
                    count[j] ++;

                    for (int k = 0; k < n; k++) {
                        hit[k] = false;
                    }
                    break;
                }
                hit[bday] = true;
            }
        }

        // calculate stop fraction and display data
        for (int i = 0; i < count.length; i++) {
            double sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += count[j];
                stop_frac = sum / trials;
            }

            System.out.println(i+1 + "\t" + count[i] + "\t" + stop_frac);
            if (stop_frac >= 0.50) {break;}
        }

    }

}
