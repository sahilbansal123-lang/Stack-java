
//        StackClass: is a linear data structure that follows the Last In First Out (LIFO) principle. It is a collection
//               of elements that supports two main operations: push and pop.

//               Push: operation adds an element to the top of the stack
//               Pop:  operation removes the element from the top of the stack.
//               Peek: operation is also commonly used, which returns the top element of the stack without removing it.
//
//        Stacks are often implemented using arrays or linked lists, and they are used in various computer algorithms,
//        such as in the evaluation of expressions, parsing, backtracking, and recursion. They are also used
//        in programming languages for function calls and local variable storage during execution.

public class StackClass {
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            next = null;
        }
    }

    static class Stack {
        public static Node head;

        public static boolean isEmpty(){
            return head == null;
        }

        public static void push(int data){
            Node newNode = new Node(data);
            if (isEmpty()){
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        public static int pop(){
            if (isEmpty()){
                return 0;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        public static int peek(){
            if (isEmpty()){
                return 0;
            }
            return head.data;
        }
    }
    public static void main(String[] args) {

        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s.pop());
        System.out.println(s.peek());
        while (!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }

    }
}