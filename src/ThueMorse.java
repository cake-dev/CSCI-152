public class ThueMorse {

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int[] bits = new int[n];

        /*
         Create TM sequence of length n.
         Formula taken from assignment FAQ.
         */
        for (int i = 0; i < n; i++) {
            if (i==0) {bits[i] = 0;}
            else if (i%2==0) {bits[i] = bits[i/2];}
            else {bits[i] = 1-bits[i-1];}
        }

        //display n-by-n pattern by printing a '+' in row i and column j if bits i and j in the sequence are equal, and a '-' if they are different.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (bits[i]==bits[j]) {
                    System.out.print("+");
                }
                else{
                    System.out.print("-");
                }
                System.out.print("  ");
            }
            System.out.println();
        }

    }

}
