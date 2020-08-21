package leetcode.sort;

/**
 * @author maple
 * @date 2020/8/1
 */
public class PopSort {

    /**
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性分析：稳定
     */
    public static void main(String[] args) {
        int[] data = SortUtil.data();
        int length = data.length;
        SortUtil.print(data);
        base(data, length);
        System.out.println("-------------美丽的分割线----------------");
        data = SortUtil.data();
        base2(data, length);
    }

    private static void base2(int[] data, int length) {
        int end = length - 1;
        for (int i = 0; i < length; i++) {
            int changeIndex = 0;
            for (int j = 0; j < end; j++) {
                if (data[j] > data[j + 1]) {
                    SortUtil.swap(data, j, j + 1);
                    changeIndex = j;
                }
            }
            SortUtil.print(data, i + 1);
            if (changeIndex == 0) {
                break;
            }
            end = changeIndex;
        }
    }

    private static void base(int[] data, int length) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    SortUtil.swap(data, j, j + 1);
                }
            }
            SortUtil.print(data, i + 1);
        }
    }

}
