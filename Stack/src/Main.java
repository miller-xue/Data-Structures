import java.util.ArrayList;
import java.util.Stack;

public class Main {
   
    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            arrayStack.push(i);
        }
        System.out.println(arrayStack);
        arrayStack.pop();
        System.out.println(arrayStack);
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c.equals('[') || c.equals('{') || c.equals('('))
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;
                Character top = stack.peek();//TODO
            }
        }
        return stack.isEmpty();
    }
}
