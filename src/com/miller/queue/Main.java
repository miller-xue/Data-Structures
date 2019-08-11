package com.miller.queue;

import java.util.Random;

public class Main {
    // 测试使用queue 运行opCount个enqueue和dequeue操作所需要的时间，单位：秒
    private static double testQueue(Queue<Integer> queue, int opCount) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++)
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        for (int i = 0; i < opCount; i++)
            queue.dequeue();
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 10000000;
//        Queue<Integer> arrayQueue = new ArrayQueue<>();
//        System.out.println(testQueue(arrayQueue,opCount)); //4.4699757

        Queue<Integer> loopQueue = new LoopQueue<>();
        System.out.println(testQueue(loopQueue,opCount)); // 0.0389651

        Queue<Integer> linkedListQueue = new LinkedListQueue<>();
        System.out.println(testQueue(linkedListQueue,opCount)); // 0.0389651


    }
}
