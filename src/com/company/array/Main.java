package com.company.array;


/**
 * @author ：赖增智
 * @date ：Created in 2019-6-16 13:34
 */

public class Main {

    public static void main(String[] args) {

       /*
           int[] arr = new int[10];
            for (int i = 0; i < arr.length; i++)
                arr[i] = i;
            //循环
            int[] scores = new int[]{100, 30, 60};
            for (int i = 0; i < scores.length; i++)
                System.out.println(scores[i]);
            //遍历
            for (int score : scores)
                System.out.println(score);
        */

        // Array arr = new Array(20);
        // 泛型的测试
        ArrayGenerics<Integer> arr= new ArrayGenerics<>(20);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.add(0, -1);
        System.out.println(arr);

        arr.set(2, 99);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);
    }
}

