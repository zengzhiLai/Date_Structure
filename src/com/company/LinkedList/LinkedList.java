package com.company.LinkedList;

/**
 * @author ：赖增智
 * @date ：Created in 2019-8-15 23:54
 */
public class LinkedList<E> {

    /**
     * 链表的结点
     */
    public class Node {
        public E e; // 元素
        public Node next; // 下一个结点

        // 3个构造器
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

    // private Node head; //链表的第一个结点（头结点）
    private Node dummyHead; //虚拟头结点（在head结点前添加的一个假的结点，这样在链表的头结点前插入一个元素时 就不需要再判断了）
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    /**
     * 获取链表中的元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断链表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表的 index (0 ~ based) 位置添加新的元素e
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {

        if (index < 0 || index > size) { // index == size时，可在链表尾添加一个结点
            throw new IllegalArgumentException("Add failed. Illegal index. ");
        }

        /*
         *   if (index == 0) {
         *       addFirst(e);
         *   } else {
         *       Node prev = head;
         *       for (int i = 0; i < index - 1; i++) {
         *           prev = prev.next;
         *       }
         *       // Node node = new Node(e);
         *       // node.next = prev.next;
         *       // prev.next = node;
         *       prev.next = new Node(e, prev.next);
         *       size++;
         *   }
         * */

        // 添加虚拟结点后
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    /**
     * 在链表头插入新的元素e
     *
     * @param e
     */
    public void addFirst(E e) {
        //Node node = new Node(e);
        //node.next = head;
        //head = node;

        //head = new Node(e, head); // 相当于上面三行

        //size++;

        add(0, e);
    }

    /**
     * 在链表的末尾添加新的元素e
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获取链表的第 index（ 0~based ）个位置的元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed. Illegal index. ");
        }
        Node cur = dummyHead.next; // 当前结点
        for (int i = 0; i < index; i++) { // i=0时cur指向1，当i=index-1时cur指向index
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获取链表的第一个元素
     *
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取链表的最后一个元素
     *
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改链表的第 index（ 0~based ）个位置的元素为e
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Illegal index. ");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 查找链表中是否有元素e
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) { // cur不为空时，它就是一个有效结点，可以循环下去
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 从链表中删除第index（0~based）个位置的元素，并返回删除的元素
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Illegal index. ");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next; // 返回的结点retNode（ 要被删除的结点 ）
        prev.next = retNode.next;
        retNode.next = null; // 回收
        size--;

        return retNode.e;
    }

    /**
     * 从链表中删除第一个元素，并返回删除的元素
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 从链表中删除最后一个元素，并返回删除的元素
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur + "-->");
            cur = cur.next;
        }

        /*
         * // 相当于while循环
         * for(Node cur = dummyHead.next; cur != null; cur = cur.next){
         *    res.append(cur+"-->");
         * }
         *
         */

        res.append("NULL");
        return res.toString();
    }

}
