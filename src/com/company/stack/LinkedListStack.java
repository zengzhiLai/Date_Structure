package com.company.stack;

/**
 * @author ：赖增智
 * @date ：Created in 2019-8-25 1:45
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedListStack() {
        list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(list);
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }
//    测试结果：
//    Stack: top 0-->NULL
//    Stack: top 1-->0-->NULL
//    Stack: top 2-->1-->0-->NULL
//    Stack: top 3-->2-->1-->0-->NULL
//    Stack: top 4-->3-->2-->1-->0-->NULL
//    Stack: top 3-->2-->1-->0-->NULL

}
