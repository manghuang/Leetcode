package parse;

public class Test {

    public static void main(String[] args) {
        ParseClassFile parseCLassFile = new ParseClassFile();
//        System.out.println(ParseCLassFile.class.getResource("").getPath());
        parseCLassFile.parse(ParseClassFile.class.getResource("").getPath(), "test.class", "res.txt");
    }
}
