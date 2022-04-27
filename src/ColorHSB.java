public class ColorHSB {

    private final int hue;
    private final int saturation;
    private final int brightness;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h > 359) {
            throw new IllegalArgumentException("hue must be between 0 and 359");
        } else if (s < 0 || s > 100) {
            throw new IllegalArgumentException("saturation must be between 0 and 100");
        } else if (b < 0 || b > 100) {
            throw new IllegalArgumentException("brightness must be between 0 and 100");
        } else {
            this.hue = h;
            this.saturation = s;
            this.brightness = b;
        }
    }

    // Returns a string representation of this color, using the format (h, s, b).
    @Override
    public String toString() {
        return "(" + this.hue + ", " + this.saturation + ", " + this.brightness + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        return this.brightness == 0 || this.saturation == 0;
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null) {
            throw new IllegalArgumentException("ColorHSB obj ref (that) required in method call");
        }
        double delta_h = this.hue - that.hue;
        double delta_s = this.saturation - that.saturation;
        double delta_b = this.brightness - that.brightness;
        //min{(h1−h2)2,(360−|h1−h2|)2}+(s1−s2)2+(b1−b2)2
        return (int) ((Math.min(Math.pow((delta_h), 2), Math.pow(360 - Math.abs(delta_h), 2))) + Math.pow(delta_s, 2) + Math.pow(delta_b, 2));
    }

    // Sample client (see below).
    public static void main(String[] args) {
        ColorHSB c_hsb = new ColorHSB(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        int min_distance = Integer.MAX_VALUE;
        String closest_name = null;
        ColorHSB closest = null;
        while (!StdIn.isEmpty()) {
            String c_name = StdIn.readString();
            int h = StdIn.readInt();
            int s = StdIn.readInt();
            int b = StdIn.readInt();
            ColorHSB c = new ColorHSB(h, s, b);
            int distance = c_hsb.distanceSquaredTo(c);
            if (distance <= min_distance) {
                min_distance = distance;
                closest = c;
                closest_name = c_name;
            }
        }
        System.out.println(closest_name + " " + closest);
    }

}
