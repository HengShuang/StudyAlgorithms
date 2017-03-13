import java.util.Arrays;


public class InsertionSort {
    public static void main(String[] args) {
        final int length = 10;
        int[] arrs1 = RandomUtils.build(length);
//        int[] arrs1 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] arrs2 = Arrays.copyOf(arrs1, arrs1.length);
        System.out.println(Arrays.toString(arrs1));

        insertionSort(arrs1);
        binaryInsertionSort(arrs2);

//        System.out.println(Arrays.toString(insertionSort(arrs1)));
//        System.out.println(Arrays.toString(binaryInsertionSort(arrs1)));
    }

    public static int[] insertionSort(int[] array) {
        long time = System.nanoTime();
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
        System.out.println("插入排序耗时:" + (double) (System.nanoTime() - time) / 1000000 + "ms");
        return array;
    }

    public static int[] binaryInsertionSort(int[] array) {
        long time = System.nanoTime();
        for (int i = 1; i < array.length; i++) {
            int key = array[i], left = 0, right = i - 1;
            while (left <= right) {
                int middle = (left + right) / 2;
                if (key < array[middle]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
            for (int j = i - 1; j >= left; j--) {
                array[j + 1] = array[j];
            }
            array[left] = key;
        }
        System.out.println("二分插入排序耗时:" + (double) (System.nanoTime() - time) / 1000000 + "ms");
        return array;
    }
}