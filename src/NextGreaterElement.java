import java.util.Stack;

public class NextGreaterElement {

    public static void nextGreater(int elements[], int nextGreat[]) {
        Stack<Integer> s = new Stack<>();
        for (int i = elements.length-1; i >= 0 ; i--) {
            int curr = elements[i];
            while (!s.isEmpty() && curr >= elements[s.peek()]){
                s.pop();
            }
            if (s.isEmpty()){
                nextGreat[i] = -1;
            } else {
                nextGreat[i] = elements[s.peek()];
            }
            s.push(i);
        }
    }

    public static void main(String[] args) {
        int elements[] = {6, 8, 0, 1, 3};
        int nextGreat [] = new int[elements.length];

        nextGreater(elements, nextGreat);
        for (int i = 0; i < nextGreat.length; i++) {
            System.out.print(nextGreat[i] + " ");
        }

    }
}
