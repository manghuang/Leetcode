package parse;

public class Test {

    public static void main(String[] args) {
        ParseCLassFile parseCLassFile = new ParseCLassFile();
//        System.out.println(ParseCLassFile.class.getResource("").getPath());
        parseCLassFile.parse(ParseCLassFile.class.getResource("").getPath(), "test.class", "res.txt");
    }
}
