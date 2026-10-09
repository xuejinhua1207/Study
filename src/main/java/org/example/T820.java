package org.example;

import java.util.*;

public class T820 {

    /**
     * 单词数组 words 的 有效编码 由任意助记字符串 s 和下标数组 indices 组成，且满足：
     * <p>
     * words.length == indices.length
     * 助记字符串 s 以 '#' 字符结尾
     * 对于每个下标 indices[i] ，s 的一个从 indices[i] 开始、到下一个 '#' 字符结束（但不包括 '#'）的 子字符串 恰好与 words[i] 相等
     * 给你一个单词数组 words ，返回成功对 words 进行编码的最小助记字符串 s 的长度 。
     */
    public static int minimumLengthEncoding(String[] words) {
        Comparator<String> comparator = Comparator.comparingInt(String::length).reversed().thenComparing(s -> s);
        Arrays.sort(words, comparator);
        String res = "";
        // 2. 放入队列
        Queue<String> queue = new LinkedList<>();
        for (String s : words) {
            queue.offer(s);
        }
        for (String str : queue) {
            System.out.println(str);
        }
        while (!queue.isEmpty()) {
            String temp = queue.poll();
            res += temp;
            Iterator<String> iterator = queue.iterator();
            while (iterator.hasNext()){
                String next = iterator.next();
                if (res.endsWith(next)){
                    iterator.remove();
                }
            }
            res += "#";
        }
        return res.length();
    }

    public static void main(String[] args) {
        String[] words = {"time", "bell", "mee", "me"};
        int len = minimumLengthEncoding(words);
        System.out.println(len);
    }
}
