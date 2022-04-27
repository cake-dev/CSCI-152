public class RightTriangle {
    //returns true if the given values form a right triangle
    public static void main(String[] args) {
        int s1 = Integer.parseInt(args[0]);
        int s2 = Integer.parseInt(args[1]);
        int s3 = Integer.parseInt(args[2]);
        Boolean allPos = s1 > 0 && s2 > 0 && s3> 0;
        Boolean combo1 = (s1*s1) + (s2*s2) == (s3*s3) && allPos;
        Boolean combo2 = (s2*s2) + (s3*s3) == (s1*s1) && allPos;
        Boolean combo3 = (s1*s1) + (s3*s3) == (s2*s2) && allPos;
        Boolean isRightTriangle = combo1 || combo2 || combo3;
        StdOut.println(isRightTriangle);
    }

}
