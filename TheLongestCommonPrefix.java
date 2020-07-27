package leetcode;

/*14.最长公共前缀
编写一个函数来查找字符串数组中的最长公共前缀。

        如果不存在公共前缀，返回空字符串 ""。

        示例 1:
        输入: ["flower","flow","flight"]
        输出: "fl"

        示例 2:
        输入: ["dog","racecar","car"]
        输出: ""
        解释: 输入不存在公共前缀。*/

public class TheLongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String n = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(n) != 0) {
                n = n.substring(0,n.length() - 1);
            }
        }
        return n;
    }
}
