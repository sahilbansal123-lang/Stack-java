import java.util.Stack;

public class StockSpanProblem {

    public static void stockSpan(int stocks [], int span []) {
        Stack<Integer> s = new Stack<>(); // stores previous high index
        span[0] = 1;
        s.push(0);
        for (int i = 1; i < stocks.length; i++) {
            int curr = stocks[i];
            while (!s.isEmpty() && curr > stocks[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()){
                span[i] = span[i+1];
            } else {
                span[i] = i - s.peek();
            }
            s.push(i);
        }
    }

    public static void main(String[] args) {
        int stocks [] = {100, 80, 60, 100, 60, 85, 70};
        int span[] = new int[stocks.length];
        stockSpan(stocks, span);

        for (int i = 0; i < span.length; i++) {
            System.out.println(span[i] + " " );
        }
    }
}
