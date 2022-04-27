import java.util.Arrays;

public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] amp = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            amp[i] = a[i] * alpha;
        }
        return amp;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] rev = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            rev[a.length - 1 - i] = a[i];
        }
        return rev;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    // TODO FIX MERGED (OUT OF RANGE ERROR)
    public static double[] merge(double[] a, double[] b) {
        double[] merged = new double[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            merged[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            merged[a.length + i] = b[i];
        }
        return merged;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        int longest = Math.max(a.length, b.length);
        double[] larger;
        double[] smaller;
        if (longest == a.length) {
            larger = a;
            smaller = b;
        } else {
            larger = b;
            smaller = a;
        }
        smaller = Arrays.copyOf(smaller, larger.length);
        double[] mixed = new double[longest];
        for (int i = 0; i < larger.length; i++) {
            mixed[i] = larger[i] + smaller[i];
        }
        return mixed;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        double[] speedchanged = new double[(int) (a.length / alpha)];
        for (int i = 0; i < speedchanged.length; i++) {
            speedchanged[i] = a[(int) Math.floor(i * alpha)];
        }
        return speedchanged;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        double[] cow = StdAudio.read("cow.wav");
        double[] dialup = StdAudio.read("dialup.wav");
        double[] harp = StdAudio.read("harp.wav");
        double[] piano = StdAudio.read("piano.wav");
        double[] singer = StdAudio.read("singer.wav");

        StdAudio.play(changeSpeed(amplify(dialup, 0.5), 4));
        double[] piano_singer = mix(changeSpeed(piano, 0.4), singer);
        double[] coolharp = merge(reverse(harp), harp);
        StdAudio.play(coolharp);
        StdAudio.play(piano_singer);
        StdAudio.play(cow);

    }

}
