package leetcode.sort;

/**
 * @author maple
 * @date 2020/8/1
 */
public class InsertSort {

    /**
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性分析：稳定
     */
    public static void main(String[] args) {
        int[] data = SortUtil.data();
        int length = data.length;
        SortUtil.print(data);
        for (int i = 1; i < length; i++) {
            int insertIndex = i;
            int insertNum = data[i];
            for (int j = i - 1; j >= 0; j--) {
                if (insertNum < data[j]) {
                    data[j + 1] = data[j];
                    insertIndex = j;
                } else {
                    break;
                }
            }
            if (insertIndex != i) {
                data[insertIndex] = insertNum;
            }
            SortUtil.print(data, i);
        }
    }

}
