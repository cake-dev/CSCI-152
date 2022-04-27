public class RevesPuzzle {

    static void towerOfHanoi(int n, int k, char from_rod, char aux_rod, char to_rod) {
        if (n == 0) {
            return;
        }
        towerOfHanoi(n - 1, k, from_rod, to_rod, aux_rod);
        System.out.println("Move disk " + (n + k) + " from " + from_rod + " to " + to_rod);
        towerOfHanoi(n - 1, k, aux_rod, from_rod, to_rod);
    }

    static void reves(int n, char from_rod, char aux_rod_1, char aux_rod_2, char to_rod) {
        int k = (int) (n + 1 - Math.sqrt(2 * n + 1));
        if (n == 0) {
            //System.out.println("Move disk " + n + " from " + from_rod + " to " + to_rod);
            return;
        }
        reves(k, from_rod, to_rod, aux_rod_2, aux_rod_1);
        towerOfHanoi(n - k, k, from_rod, aux_rod_2, to_rod);
        reves(k, aux_rod_1, from_rod, aux_rod_2, to_rod);

    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        reves(n, 'A', 'B', 'C', 'D');
        System.out.println();
    }

}
