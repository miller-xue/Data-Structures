package com.miller.stack;

import com.miller.queue.Queue;

import java.util.Random;

public class Main {
   
    public static void main(String[] args) {
//        Stack<Integer> arrayStack = new LinkedListStack();
//        for (int i = 0; i < 5; i++) {
//            arrayStack.push(i);
//        }
//        arrayStack.pop();
//        arrayStack.pop();
//        System.out.println(arrayStack);
//        arrayStack.pop();
//        System.out.println(arrayStack);
//        String str = "[[]{}()";
//        System.out.println(isValid(str));

        int opCount = 10000000;
        Stack<Integer> stack = new ArrayStack<>();
        double v = testStack(stack, opCount);
        System.out.println(v);
        stack = new LinkedListStack<>();
        v = testStack(stack, opCount);
        System.out.println(v);


        // LinkedListStack中包含更多的new操作  java的栈使用的是ArrayStack 底层是ArrayList
    }



    // 测试使用stack 运行opCount个enqueue和dequeue操作所需要的时间，单位：秒
    private static double testStack(Stack<Integer> stack, int opCount) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++)
            stack.push(random.nextInt(Integer.MAX_VALUE));
        for (int i = 0; i < opCount; i++)
            stack.pop();
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    /**
     * 判断括号匹配
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new LinkedListStack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[' || c == '{' || c == '(')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;
                char topChar = stack.pop();
                if (c == ')' && topChar != '(')
                    return false;
                if (c == ']' && topChar != '[')
                    return false;
                if (c == '}' && topChar != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
