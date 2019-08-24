package com.company.queue;

import com.company.LinkedList.LinkedList;

/**
 * 基于链表的队列
 * （伪指针优化队列）
 * 链表头出队、链表尾入队
 *
 * @author ：赖增智
 * @date ：Created in 2019-8-25 2:37
 */
public class LinkedListQueue<E> implements Queue<E> {

    public class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(E e) {
        if (tail == null) { //链表为空
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if (head == null) { //假设链表只有一个，然后被移除了，此时条件成立
            tail = null;
        }
        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue iss empty.");
        }
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue:front ");

        Node cur = head;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
//    运行结果：
//        Queue:front 0->NULL tail
//        Queue:front 0->1->NULL tail
//        Queue:front 0->1->2->NULL tail
//        Queue:front 1->2->NULL tail
//        Queue:front 1->2->3->NULL tail
//        Queue:front 1->2->3->4->NULL tail
//        Queue:front 1->2->3->4->5->NULL tail
//        Queue:front 2->3->4->5->NULL tail
//        Queue:front 2->3->4->5->6->NULL tail
//        Queue:front 2->3->4->5->6->7->NULL tail
//        Queue:front 2->3->4->5->6->7->8->NULL tail
//        Queue:front 3->4->5->6->7->8->NULL tail
//        Queue:front 3->4->5->6->7->8->9->NULL tail
    }
}
