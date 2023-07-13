import java.util.Stack;

public class DuplicateParanthesis {

    public static boolean isduplicate(String str) {
        Stack <Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // CLOSING CONDITION
            if (ch == ')'){
                int count = 0;
                while (s.peek() != '(') {
                    s.pop();
                    count++;
                }

                if (count < 1) {
                    return true;
                } else {
                    s.pop();
                }
            } else {
                // OPENING CONDITION
                s.push(ch);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "((a + b))";
        String str1 = "(a - b)";
        System.out.println(isduplicate(str1));
    }
}
