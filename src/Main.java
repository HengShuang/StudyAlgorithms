import java.util.Arrays;

/**
 * Created by Administrator on 2017/3/1.
 */
public class Main {
    public static void main(String[] args) {
        final int length = 1000;
        int[] arrs1 = RandomUtils.build(length);
//        int[] arrs1 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] arrs2 = Arrays.copyOf(arrs1, arrs1.length);
        int[] arrs3 = Arrays.copyOf(arrs1, arrs1.length);
        int[] arrs4 = Arrays.copyOf(arrs1, arrs1.length);
        int[] arrs5 = Arrays.copyOf(arrs1, arrs1.length);
        System.out.println(Arrays.toString(arrs1));

        InsertionSort.insertionSort(arrs1);
        ShellSort.shellSort(arrs2);
        BubbleSort.bubbleSort4(arrs4);
        SelectionSort.selectionSort(arrs5);
    }
}
