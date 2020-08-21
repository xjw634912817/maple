package leetcode.sort;

/**
 * @author maple
 * @date 2020/8/1
 */
public class SortUtil {

    static int[] data() {
        return new int[]{12, 6, 10, 8, 1, 2};
    }

    static void swap(int[] array, int i, int j) {
        if (i == j) {
            System.out.println("顺序一致，其实没交互");
            return;
        }
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    static void print(int[] data, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("第").append(i).append("次排序后：");
        for (int datum : data) {
            stringBuilder.append(datum).append(" ");
        }
        System.out.println(stringBuilder);
    }

    static void print(int[] data) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("原始数据：");
        for (int datum : data) {
            stringBuilder.append(datum).append(" ");
        }
        System.out.println(stringBuilder);
    }

}
