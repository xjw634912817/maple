package leetcode.sort;

/**
 * @author maple
 * @date 2020/8/2
 */
public class QuickSort {

    private static int count = 1;

    /**
     * 时间复杂度：O(n * log n)
     * 空间复杂度：O(1)
     * 稳定性分析：稳定
     */
    public static void main(String[] args) {
        int[] data = SortUtil.data();
        int length = data.length;
        SortUtil.print(data);
        quickSort(data, 0, length - 1);
    }

    private static void quickSort(int[] data, int start, int end) {
        if (start >= end) {
            return;
        }
        int key = data[start];
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && data[j] > key) {
                j--;
            }
            data[i] = data[j];
            while (i < j && data[i] < key) {
                i++;
            }
            data[j] = data[i];
        }
        data[i] = key;
        SortUtil.print(data, count++);
        quickSort(data, start, i - 1);
        quickSort(data, i + 1, end);
    }

}
