import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        final int length = 90000;
        int[] arrs1 = new int[length], arrs2 = new int[length], arrs3 = new int[length], arrs4 = new int[length];
        for (int i = 0; i < length; i++) {
            arrs1[i] = new Random().nextInt(10);
        }
        new IntegerArray(arrs1).print(System.out);
        System.arraycopy(arrs1, 0, arrs2, 0, arrs1.length);
        System.arraycopy(arrs1, 0, arrs3, 0, arrs1.length);
        System.arraycopy(arrs1, 0, arrs4, 0, arrs1.length);
//        int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
//        IntegerArray array = new IntegerArray(arr);
//        array.sort();
//        array.print(System.out);
        new IntegerArray(bubbleSort(arrs1));
        new IntegerArray(bubbleSort2(arrs2));
        new IntegerArray(bubbleSort3(arrs3));
        new IntegerArray(bubbleSort4(arrs4));

//        new IntegerArray(bubbleSort(arrs1)).print(System.out);
//        new IntegerArray(bubbleSort2(arrs2)).print(System.out);
//        new IntegerArray(bubbleSort3(arrs3)).print(System.out);
//        new IntegerArray(bubbleSort4(arrs4)).print(System.out);
    }


    public static int[] bubbleSort(int[] arr) {
        long time = System.nanoTime();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {        //相邻元素两两对比
                    int temp = arr[j + 1];        //元素交换
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("改进前冒泡排序耗时:" + (double) (System.nanoTime() - time) / 1000000 + "ms");
        return arr;
    }

    public static int[] bubbleSort2(int[] arr) {
        long time = System.nanoTime();
        int i = arr.length - 1;  //初始时,最后位置保持不变
        while (i > 0) {
            int pos = 0; //每趟开始时,无记录交换
            for (int j = 0; j < i; j++)
                if (arr[j] > arr[j + 1]) {
                    pos = j; //记录交换的位置
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            i = pos; //为下一趟排序作准备
        }
        System.out.println("2.改进后冒泡排序耗时:" + (double) (System.nanoTime() - time) / 1000000 + "ms");
        return arr;
    }

    public static int[] bubbleSort3(int[] arr) {
        int low = 0;
        int high = arr.length - 1; //设置变量的初始值
        int tmp, j;
        long time = System.nanoTime();
        while (low < high) {
            for (j = low; j < high; ++j) //正向冒泡,找到最大者
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            --high;                 //修改high值, 前移一位
            for (j = high; j > low; --j) //反向冒泡,找到最小者
                if (arr[j] < arr[j - 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            ++low;                  //修改low值,后移一位
        }
        System.out.println("3.改进后冒泡排序耗时:" + (double) (System.nanoTime() - time) / 1000000 + "ms");
        return arr;
    }

    public static int[] bubbleSort4(int[] arr) {
        int low = 0;
        int high = arr.length - 1; //设置变量的初始值
        int j;
        long time = System.nanoTime();
        while (low < high) {
            int pos = 0, pso = 0; //每趟开始时,无记录交换
            for (j = low; j < high; ++j) //正向冒泡,找到最大者
                if (arr[j] > arr[j + 1]) {
                    pos = j; //记录交换的位置
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            high = pos; //为下一趟排序作准备
//            --high;                 //修改high值, 前移一位
            for (j = high; j > low; --j) //反向冒泡,找到最小者
                if (arr[j] < arr[j - 1]) {
                    pso = j; //记录交换的位置
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            low = pso;
//            ++low;                  //修改low值,后移一位
        }
        System.out.println("4.改进后冒泡排序耗时:" + (double) (System.nanoTime() - time) / 1000000 + "ms");
        return arr;
    }
}