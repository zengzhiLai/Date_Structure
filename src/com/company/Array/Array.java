package com.company.Array;

/**
 * 数组 泛型Generics
 *
 * @author ：赖增智
 * @date ：Created in 2019-6-22 16:00
 */
public class Array<E> {
    private E[] data;
    private int size;//元素个数，相当于数组的下标

    /**
     * 构造函数，传入数组的容量capacity构造Array
     *
     * @param capacity
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];//先建一个object类型的数组再强制类型转换为E[]
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
     * 返回数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size==0;
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
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 向所有元素前添加一个新的元素
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在第index位置插入一个新的元素e
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        //判断位置是否符合
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed,Require index>=0 and index<=size");
        }
        if (size == data.length) {
            resize(2 * data.length);
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
    public E get(int index) {
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
    public void set(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Set failed,index is illegal.");
        data[index] = e;
    }

    /**
     * 查找数组中是否有元素e
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) //两个类对像之间值的比较用equals, == 比较的是对象的地址 或 基本数据类型值的比较
                return true;
        }
        return false;
    }

    /**
     * 查找元数组中元素e所在的索引，如不存在则返回-1
     *
     * @param e
     * @return
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    /**
     * 从数组中删除index位置的元素，并返回删除的元素
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Remove is failed. Index is illegal.");
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
       /*
           remove方法执行完后 size还指向一个值，但用户无法访问
           将它置为空后，Java垃圾回收机制才会把它回收
           loitering objects != memory leak
       */
        data[size] = null;

        /*
         * 数组刚扩容后，防止下一个操作是删除元素时 resize()缩容,所以 当数组的容量为 当前容量的四分之一 时才缩容 （复杂度震荡）
         * */
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    /**
     * 从数组中删除第一个元素，并返回删除的元素
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素，并返回删除的元素
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 从数组中删除元素e (仅删除一个)
     *
     * @param e
     */
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
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

    /**
     * 数组扩容
     *
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

}
