import java.util.Arrays;

/**
 * Created by Administrator on 2017/3/1.
 */
public class ShellSort {
    public static void main(String[] args) {
        final int length = 10;
        int[] arrs1 = RandomUtils.build(length);
//        int[] arrs1 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] arrs2 = Arrays.copyOf(arrs1, arrs1.length);
        System.out.println(Arrays.toString(arrs1));

        shellSort(arrs1);

//        System.out.println(Arrays.toString(insertionSort(arrs1)));
//        System.out.println(Arrays.toString(binaryInsertionSort(arrs1)));
    }

    public static int[] shellSort(int[] arr) {
        long time = System.nanoTime();
        int len = arr.length,
                temp,
                gap = 1;
        while (gap < len / 5) {          //动态定义间隔序列
            gap = gap * 5 + 1;
        }
        for (; gap > 0; gap = (int) Math.floor(gap / 5)) {
            for (int i = gap; i < len; i++) {
                temp = arr[i];
                int j;
                for (j = i - gap; j >= 0 && arr[j] > temp; j -= gap) {
                    arr[j + gap] = arr[j];
                }
                arr[j + gap] = temp;
            }
        }
        System.out.println("希尔排序耗时:" + (double) (System.nanoTime() - time) / 1000000 + "ms");
        return arr;
    }
}
