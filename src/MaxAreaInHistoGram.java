import java.util.Stack;

public class MaxAreaInHistoGram {

    public static void maxArea(int [] height) {

        Stack<Integer> s = new Stack<>();
        int maxarea = 0;
        int[] nsl = new int[height.length]; //these both are index array
        int[] nsr = new int[height.length];

         // Next Smaller left(j)

        for (int j = 0; j < height.length; j++) {
            int curr = height[j];
            while (!s.isEmpty() && curr <= height[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
            // this time we cannot store -1 we store index of n because we need to
            // calculate the index of max so that's why we are not storing -1
               nsl[j] = height.length;
            } else {
                nsl[j] = s.peek();
            }
            s.push(j);
        }

        // Next Smaller right(i)
        for (int i = height.length-1; i >= 0; i--) {
            int curr = height[i];
            while (!s.isEmpty() && curr <= height[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()){
                nsr[i] = height.length;
            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        // area = height * maxwidth
        for (int i = 0; i < height.length; i++) {
            int hgt = height[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = width * hgt;
            maxarea = Math.max(currArea, maxarea);
        }
        System.out.println("max area is: " + maxarea);
    }

    public static void main(String[] args) {

        int [] height = { 2, 1, 5, 6, 2, 3 };
        maxArea(height);
    }
}
