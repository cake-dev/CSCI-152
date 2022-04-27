public class GreatCircle {
    //returns the length of the arc on the great circle
    public static void main(String[] args) {
        double x1 = Math.toRadians(Double.parseDouble(args[0]));
        double y1 = Math.toRadians(Double.parseDouble(args[1]));
        double x2 = Math.toRadians(Double.parseDouble(args[2]));
        double y2 = Math.toRadians(Double.parseDouble(args[3]));
        double xsin = (Math.sin((x2-x1)/2)) * (Math.sin((x2-x1)/2));
        double ysin = (Math.sin((y2-y1)/2)) * (Math.sin((y2-y1)/2));
        double distance = (2*6371.0*Math.asin(Math.sqrt((xsin) + (Math.cos(x1) * Math.cos(x2)) * ysin)));
        StdOut.print(distance + " kilometers");
    }

}
