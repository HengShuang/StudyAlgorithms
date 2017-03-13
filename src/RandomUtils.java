import java.util.*;

public class RandomUtils {
    public static int[] build(int sz) {
        Random random = new Random();
        int[] a = new int[sz];
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(sz);
            for (int j = 0; j < i; j++) {
                while (i != j && a[i] == a[j]) {//如果重复，退回去重新生成随机数
                    i--;
                }
            }
        }
        return a;
    }
}
