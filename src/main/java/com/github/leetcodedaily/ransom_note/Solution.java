package com.github.leetcodedaily.ransom_note;

/**
 * 2021.12.4 每日一题
 * 思路为哈希桶
 * 因为题目给出 ransomNote 与 magazine 这两个字符串都是由小写字母组成
 * 所以创建两个容量为 26 的桶分别来记录 ransomNote 与 magazine 每个字符的个数
 * 遍历 ransomNote 与 magazine，用这两个桶来记录从 a ~ z 出现的个数
 * 最后，要求 magazine 每个字符对应的个数大于等于 ransomNote 每个字符的个数
 */
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // 全部都是小写的英文字母组成
        int[] ransomNoteBucket = new int[26];
        int[] magazineBucket = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            ransomNoteBucket[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            magazineBucket[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (magazineBucket[i] < ransomNoteBucket[i])
                return false;
        }
        return true;
    }
}
