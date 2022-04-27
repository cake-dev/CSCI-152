public class CMYKtoRGB {
    //converts from CMYK color code to RGB
    public static void main(String[] args) {
        double cyan = Double.parseDouble(args[0]);
        double magenta = Double.parseDouble(args[1]);
        double yellow = Double.parseDouble(args[2]);
        double black = Double.parseDouble(args[3]);
        double white = (1 - black);
        double red = 255 * white * (1-cyan);
        double green = 255 * white * (1-magenta);
        double blue = 255 * white * (1-yellow);
        StdOut.println("red = " + (int)Math.round(red));
        StdOut.println("green = " + (int)Math.round(green));
        StdOut.println("blue = " + (int)Math.round(blue));
    }

}