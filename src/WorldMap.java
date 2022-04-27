public class WorldMap {

    public static void main(String[] args) {

        int w = StdIn.readInt();
        int h = StdIn.readInt();
		
        StdDraw.setCanvasSize(w,h);
        StdDraw.setXscale(0,w);
        StdDraw.setYscale(0,h);

        while (!StdIn.isEmpty()) {
            // read next string to get past name line (i.e. HI, WA, CA, etc)
            StdIn.readString();
            int edges = StdIn.readInt();
            double[] x_coords = new double[edges];
            double[] y_coords = new double[edges];
			
            for (int i = 0; i < edges; i++) {
                x_coords[i] = StdIn.readDouble();
                y_coords[i] = StdIn.readDouble();
            }
			
            StdDraw.polygon(x_coords, y_coords);
        }

    }

}
