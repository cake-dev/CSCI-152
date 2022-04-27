public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        String target = "CAG";
        int max = 0;
        int count = 0;
        for (int i = 0; i < dna.length(); i++) {
            // FIXME fix this spaghetti (need to check final triple without going out of bounds, currently off by 1 if seq ends with CAG)
            if (dna.charAt(i) == 'C') {
                String sub = "";
                if (i <= dna.length() - 3) {
                    sub = dna.substring(i, i + 3);
                } else if (i > dna.length() - 3) {
                    sub = dna.substring(dna.length() - 2, dna.length());
                }
                if (sub.equals(target)) {
                    count++;
                    if (i < dna.length() - 3) {
                        i = i + 2;
                    }
                } else {
                    if (count > max) max = count;
                    count = 0;
                }
            } else {
                if (count > max) max = count;
                count = 0;
            }
        }

        return max;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        String seq = s.replace(" ", "");
        seq = seq.replace("\t", "");
        seq = seq.replace("\n", "");
        seq = seq.replace("\r", "");
        return seq;//s.replaceAll("\\s+", ""); // wanted to use this regex but the autograder said no
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats <= 9) {
            return "not human";
        } else if (maxRepeats <= 35) {
            return "normal";
        } else if (maxRepeats <= 39) {
            return "high risk";
        } else if (maxRepeats <= 180) {
            return "Huntington's";
        } else {
            return "not human";
        }

    }

    // Sample client (see below).
    public static void main(String[] args) {
        String seq = args[0];//StdIn.readAll();
        In dna_in = new In(seq);
        String dna = dna_in.readAll();
        seq = removeWhitespace(dna);
        System.out.println("max repeats = " + maxRepeats(seq));
        System.out.println(diagnose(maxRepeats(seq)));
    }

}
