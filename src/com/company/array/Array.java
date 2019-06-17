package com.company.array;

/**
 * 向数组中添加元素
 *
 * @author ：赖增智
 * @date ：Created in 2019-6-16 14:46
 */
public class Array {
    private int[] data;
    private int size;//元素个数，相当于数组的下标

    /**
     * 构造函数，传入数组的容量capacity构造Array
     *
     * @param capacity
     */
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    /**
     * 无参构造函数，默认数组容量capacity=10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组的元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 向所有元素后添加一个新的元素
     *
     * @param e
     */
    public void addLast(int e) {
       /*
        //当元素的个数等于容量时，抛参数错误异常
            if (size == data.length) {
                throw new IllegalArgumentException("AddLast failed,Array is full");
            }
            data[size] = e;
            size++;
        */
        add(size, e);
    }

    /**
     * 向所有元素前添加一个新的元素
     *
     * @param e
     */
    public void addFirst(int e) {
        add(0, e);
    }

    /**
     * 在第index位置插入一个新的元素e
     *
     * @param index
     * @param e
     */
    public void add(int index, int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("Add failed,Array is full");
        }
        //判断位置是否符合
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed,Require index>=0 and index<=size");
        }
        //从后往前循环，将元素赋值给下一个位置
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 获取index索引位置的元素
     *
     * @param index
     * @return
     */
    int get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Get failed,index is illegal.");
        return data[index];
    }

    /**
     * 修改index索引位置的元素为e
     *
     * @param index
     * @param e
     */
    void set(int index, int e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Set failed,index is illegal.");
        data[index] = e;
    }

    //重写方法 加Override注释可检查重写的方法是否正确
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size=%d,capacity=%d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }
}
