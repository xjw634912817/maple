package leetcode.sort;

/**
 * @author maple
 * @date 2020/8/1
 */
public class SelectSort {

    /**
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性分析：不稳定 例如2,2,1
     */
    public static void main(String[] args) {
        int[] data = SortUtil.data();
        int length = data.length;
        SortUtil.print(data);
        for (int i = 0; i < length; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (data[j] < data[min]) {
                    min = j;
                }
            }
            SortUtil.swap(data, i, min);
            SortUtil.print(data, i + 1);
        }
    }

}
