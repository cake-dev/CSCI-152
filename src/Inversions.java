public class Inversions {

    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        // runs in N^2 time
        long count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < a.length; j++) {
                if (i < j && a[i] > a[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        // currently this is N time

        // this is almost working (from lab)
        int[] perm = new int[n];
        int low = 0;
        int count = 1;
        for (int i = 0; i < n; i++) {
            if (k >= n - count) {
                perm[i] = n - count;
                k -= n - count;
            } else {
                perm[i] = low;
                low++;
            }
            count++;
        }

////        // https://stackoverflow.com/questions/54506366/algorithm-to-generate-an-array-with-n-length-and-k-number-of-inversions-in-on-l
//
//        int x = 0;
//        int k_val = (int) k;
//
//        for (int i = 0; i < k; i++) {
//            if ((i * (i - 1)) / 2 <= k_val) {
//                x = i;
//            }
//        }
//
//        for (int i = 0; i < x; i++) {
//            int temp = seq[i];
//            seq[i] = seq[x - i - 1];
//            seq[x - i - 1] = temp;
//        }
//
//        for (int i = x; i < seq.length; i++) {
//            int temp = seq[i];
//            if (i == seq.length - 1) {
//                seq[i] = seq[x];
//                seq[x] = temp;
//            } else {
//                seq[i] = seq[i + 1];
//                seq[i + 1] = temp;
//            }
//        }

        return perm;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int[] p = generate(5, 1);
        int[] a = {3, 1, 2};
        for (int j : p) {
            System.out.print(j);
        }
        System.out.println();
        System.out.println(count(a));
    }
}
