package leetcode.sort;

/**
 * @author maple
 * @date 2020/8/2
 */
public class HillSort {

    /**
     * 时间复杂度：O(n^2)  ??  O(n * log n)
     * 空间复杂度：O(1)
     * 稳定性分析：不稳定
     */
    public static void main(String[] args) {
        int[] data = SortUtil.data();
        int length = data.length;
        SortUtil.print(data);
        for (int d = length / 2, count = 1; d >= 1; d /= 2, count++) {
            for (int i = d; i < length; i++) {
                int insertIndex = i;
                int insertNum = data[i];
                while (insertIndex - d >= 0 && insertNum < data[insertIndex - d]) {
                    data[insertIndex] = data[insertIndex - d];
                    insertIndex = insertIndex - d;
                }
                if (insertIndex != i) {
                    data[insertIndex] = insertNum;
                }
            }
            SortUtil.print(data, count);
        }
    }

}
