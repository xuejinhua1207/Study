package org.example;

public class T3168 {

    /**
     * 给你一个字符串 s，模拟每秒钟的事件 i：
     * <p>
     * 如果 s[i] == 'E'，表示有一位顾客进入候诊室并占用一把椅子。
     * 如果 s[i] == 'L'，表示有一位顾客离开候诊室，从而释放一把椅子。
     * 返回保证每位进入候诊室的顾客都能有椅子坐的 最少 椅子数，假设候诊室最初是 空的 。
     */

    public int minimumChairs(String s) {
        int max = 0;
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == 'E') {
                temp++;
                max = Math.max(max, temp);
            } else {
                temp--;
            }

        }
        return max;
    }
}
