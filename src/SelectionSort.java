import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

public class SelectionSort {
    public static void main(String[] args) {
        final int length = 10;
        int[] arrs1 = RandomUtils.build(length);
        new IntegerArray(arrs1).print(System.err);

        selectionSort(arrs1);

//        new IntegerArray(selectionSort(arrs1)).print(System.out);
    }

    public static int[] selectionSort(int[] arr) {
        long time = System.nanoTime();
        int len = arr.length;
        int minIndex, temp;
        for (int i = 0; i < len - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[minIndex]) { //寻找最小的数
                    minIndex = j; //将最小数的索引保存
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        System.out.println("选择排序耗时:" + (double) (System.nanoTime() - time) / 1000000 + "ms");
        return arr;
    }
}
