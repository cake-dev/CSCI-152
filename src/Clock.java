public class Clock {

    private int hour;
    private int minute;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        if (h < 0 || h > 23) throw new IllegalArgumentException("Hour must be between 0 and 23");
        if (m < 0 || m > 59) throw new IllegalArgumentException("Minute must be between 0 and 59");
        this.hour = h;
        this.minute = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        if (s.length() != 5) throw new IllegalArgumentException("time string must be in the format 00:00");
        if (s.charAt(2) != ':') throw new IllegalArgumentException("time string must be in the format 00:00");
        if (Integer.parseInt(s.substring(0, 2)) > 23 || Integer.parseInt(s.substring(0, 2)) < 0)
            throw new IllegalArgumentException("hour must be between 0 and 23");
        if (Integer.parseInt(s.substring(3, 5)) > 59 || Integer.parseInt(s.substring(3, 5)) < 0)
            throw new IllegalArgumentException("minute must be between 0 and 59");
        int h = Integer.parseInt(s.substring(0, 2));
        int m = Integer.parseInt(s.substring(3, 5));
        this.hour = h;
        this.minute = m;
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        return String.format("%02d:%02d", this.hour, this.minute);
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (this.hour < that.hour) {
            return true;
        }
        return this.minute < that.minute && this.hour == that.hour;
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        this.minute++;
        if (this.minute >= 60) {
            this.hour++;
            if (this.hour >= 24) {
                this.hour = 0;
            }
            this.minute = 0;
        }
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0) throw new IllegalArgumentException("delta cannot be negative");
        int delta_h = delta / 60;
        int delta_m = delta % 60;
        this.hour += delta_h;
        this.hour %= 24;
        for (int i = 0; i < delta_m; i++) {
            tic();
        }
    }

    // Test client (see below).
    public static void main(String[] args) {
        Clock c = new Clock("15:00");
        Clock c1 = new Clock(15, 22);
        System.out.println(c);
        c.toc(30001);
        System.out.println(c);
    }
}
