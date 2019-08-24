package com.company.queue;

import java.util.Random;

/**
 * 数组队列和循环队列的性能比较（不严谨）
 * 应该是测试100次再取平均值（相对严谨）
 * @author ：赖增智
 * @date ：Created in 2019-8-3 13:11
 */
public class Main {

    /**
     * 测试使用q运行opCount个enqueue和dequeue操作所需要的时间，单位：s
     * @param q
     * @param opCount
     * @return
     */
    private static double testQueue(Queue<Integer> q, int opCount) {

        long startTime = System.nanoTime(); //纳秒

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE)); //入队：0-int的最大值（2 的 31 次方 - 1） 的随机数
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0; // 1秒==10的9次方纳秒
    }

    public static void main(String[] args) {

        int opCount = 100000; //操作次数

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue, time: " + time1 + " s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue, time: " + time2 + " s");

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double time3 = testQueue(linkedListQueue, opCount);
        System.out.println("LinkedListQueue, time: " + time3 + " s");
    }
//运行结果：
//    ArrayQueue, time: 11.997418215 s
//    LoopQueue, time: 0.035735379 s
//    LinkedListQueue, time: 0.055727654 s

}
