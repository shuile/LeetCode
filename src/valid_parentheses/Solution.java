package valid_parentheses;

public class Solution {
    public static void main(String[] args) {
        String s = "(]";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        boolean result = false;

        if ( s.length() % 2 == 1 ) {
            return result;
        }

        if ( s.length() == 0 ) {
            return !result;
        }

        char[] sToChar = s.toCharArray();
        char[] temp = new char[ sToChar.length ];
        int count = 0;

        for ( int i = 0 ; i < sToChar.length ; i ++ ) {
            if ( '(' == sToChar[i] || '[' == sToChar[i] || '{' == sToChar[i] ) {
                temp[count++]  = sToChar[i];
                continue;
            }

            if ( count > 0) {
                if (temp[count - 1] == '(' && sToChar[i] == ')') {
                    count--;
                    result = true;
                } else if (temp[count - 1] == '[' && sToChar[i] == ']') {
                    count--;
                    result = true;
                } else if (temp[count - 1] == '{' && sToChar[i] == '}') {
                    count--;
                    result = true;
                } else {
                    result = false;
                    break;
                }
            } else {
                result = false;
                break;
            }
        }

        if ( count <= 0 ) {
            return result;
        } else if ( count > 0 && result ) {
            return !result;
        } else {
            return result;
        }
    }
}
