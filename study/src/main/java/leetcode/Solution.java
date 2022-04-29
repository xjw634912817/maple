package leetcode;
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 
// 👍 1961 👎 0


import java.util.HashMap;
import java.util.LinkedList;

class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int len = adjacentPairs.length;
        if (len == 1) return adjacentPairs[0];
        HashMap<Integer, LinkedList<Integer>> tmp = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int[] cur = adjacentPairs[i];
            int left;
            int right;
            if (cur[0] < cur[1]) {
                left = cur[0];
                right = cur[1];
            } else {
                right = cur[0];
                left = cur[1];
            }
            boolean haveLeft = tmp.containsKey(left);
            boolean haveRight = tmp.containsKey(right);
            if (!haveLeft && !haveRight) {
                LinkedList<Integer> pair = new LinkedList<>();
                pair.add(left);
                pair.add(right);
                tmp.put(left, pair);
                continue;
            } else if (haveLeft && haveRight) {
                LinkedList<Integer> list1 = tmp.get(left);
                LinkedList<Integer> list2 = tmp.get(right);
                int newKey = list2.getLast();
                for (Integer num : list2) {
                    list1.addFirst(num);
                }
                tmp.remove(left);
                tmp.remove(right);
                tmp.put(newKey, list1);
            } else if (haveLeft && !haveRight) {
                LinkedList<Integer> list1 = tmp.get(left);
                list1.addFirst(right);
                tmp.remove(left);
                tmp.put(right, list1);
            } else {
                LinkedList<Integer> list1 = tmp.get(left);
                list1.addFirst(left);
                tmp.remove(right);
                tmp.put(left, list1);
            }
        }
        int[] resa = null;

        for (LinkedList<Integer> res : tmp.values()) {
            resa = new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                resa[i] = res.get(i);
            }
        }
        return resa;
    }
}