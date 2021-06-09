//Done with Yousef Swailem
public class StringManipulatorTest {
    public static void main(String[] args){
        StringManipulator test = new StringManipulator();
        System.out.println(test.trimAndConcat("   Hello   ", "   World     "));
        System.out.println(test.getIndexOrNull("Coding", 'o'));
        System.out.println(test.getIndexOrNull("Hello World", 'o'));
        System.out.println(test.getIndexOrNull("Hi", 'o'));
        System.out.println(test.getIndexOrNull("Hello", "llo"));
        System.out.println(test.getIndexOrNull("Hello", "world"));
        System.out.println(test.concatSubstring("Hello", 1, 2, "world"));
    }
}
