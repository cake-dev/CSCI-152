public class HelloGoodbye {
    //accepts 2 names on the command line and prints them
    public static void main(String[] args) {
        String name1 = args[0];
        String name2 = args[1];
        StdOut.println("Hello " + name1 + " and " + name2 +".");
        StdOut.println("Goodbye " + name2 + " and " + name1 +".");
    }
}
