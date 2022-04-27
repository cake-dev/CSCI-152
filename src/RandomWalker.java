public class RandomWalker {

    public static void main(String[] args) {
        int x_pos = 0;
        int y_pos = 0;
        int r = Integer.parseInt(args[0]);
        int steps = -1;

        while ((Math.abs(x_pos) + Math.abs(y_pos)) != r){
            int rand = StdRandom.uniform(4);
            System.out.println("(" + x_pos + "," + " " + y_pos + ")");
            if (rand == 0) {
                x_pos++;
            }
            else if (rand == 1) {
                x_pos--;
            }
            else if (rand == 2) {
                y_pos--;
            }
            else if (rand == 3) {
                y_pos++;
            }
            steps += 1;

        }

        System.out.println("steps = " + steps);
    }

}
