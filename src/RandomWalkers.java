public class RandomWalkers {

    public static void main(String[] args) {

        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int steps = 0;
        double avg_steps = 0.0;

        for (int i = 0; i <= trials; i++) {
            int x_pos = 0;
            int y_pos = 0;
            while ((Math.abs(x_pos) + Math.abs(y_pos)) != r){
                double rand = StdRandom.uniform(4);
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
        }
        avg_steps = steps / trials;


        System.out.println("average number of steps = " + avg_steps);
    }

}
