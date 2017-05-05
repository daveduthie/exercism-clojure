public class HelloWorld {
    public static String hello(String name) {
        String whom = isBlank(name)? "World":name;
        return "Hello, " + whom + "!";
    }

    private static boolean isBlank(String s) {
        return s == null || "".equals(s);
    }
}
