package com.company.queue;

public interface Queue<E> {
    /**
     * 入队
     */
    void enqueue(E e);

    /**
     * 出队
     *
     * @return 出队的元素
     */
    E dequeue();

    /**
     * 获取队首元素
     * @return
     */
    E getFront();

    int getSize();

    boolean isEmpty();
}
