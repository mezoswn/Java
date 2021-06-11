public class PuzzleJavaTest {
    public static void main(String[] args){
        PuzzleJava puzzles = new PuzzleJava();
        int[] array = {3,5,1,2,7,9,8,13,25,32};
        System.out.println(puzzles.arraySum(array));

        String[] strArray = {"Nancy","Jinichi","Fujibayashi","Momochi","Ishikawa","Sam"};
        puzzles.arrayNames(strArray);
        puzzles.shuffleAlphabet();
        puzzles.randomIntArray();
        puzzles.sortedRandomIntArray();
        System.out.println(puzzles.randomString());
        System.out.println(puzzles.randomStringArray());
    }



}