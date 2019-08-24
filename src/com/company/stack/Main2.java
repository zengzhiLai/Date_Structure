package com.company.stack;

import java.util.Random;

/**
 *
 * 链表实现栈 与 数组栈 性能比较
 * 当操作数很大时，LinkedListStack会不断的寻找空间 即不断new() 耗时增加
 * 两者的比较不严谨
 * @author ：赖增智
 * @date ：Created in 2019-8-25 2:05
 */
public class Main2 {
    private static double testStack(Stack<Integer> stack, int opCount) {

        long startTime = System.nanoTime(); //纳秒

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0; // 1秒==10的9次方纳秒
    }

    public static void main(String[] args) {

        int opCount = 100000; //操作次数

        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack, opCount);
        System.out.println("ArrayStack, time: " + time1 + " s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testStack(linkedListStack, opCount);
        System.out.println("LinkedListStack, time: " + time2 + " s");

//    运行结果：
//        ArrayStack, time: 0.066877757 s
//        LinkedListStack, time: 0.039285685 s

    }
}
