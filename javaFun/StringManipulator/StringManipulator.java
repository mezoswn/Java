//Done with Yousef Swailem
public class StringManipulator {
    public String trimAndConcat(String string1, String string2) {
        String trim1 = string1.trim();
        String trim2 = string2.trim();
        String newString = trim1.concat(trim2);
        return newString;
    }

    public Integer getIndexOrNull(String string, char letter) {
        int result = string.indexOf(letter);
        if(result == -1){
            return null;
        } else {
            return result;
        }
    }
    
    public Integer getIndexOrNull(String string, String string2) {
        int result = string.indexOf(string2);
        if(result == -1){
            return null;
        } else {
            return result;
        }
    }

    public String concatSubstring(String string1, int idx1, int idx2, String string2) {
        String subString = string1.substring(idx1, idx2);
        String conString = subString.concat(string2);
        return conString;
    }
}