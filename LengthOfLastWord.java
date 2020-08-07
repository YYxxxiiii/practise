package leetcode;



/*
58. 最后一个单词的长度

        给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。

        如果不存在最后一个单词，请返回 0 。

        说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。

*/

public class LengthOfLastWord {
    public int lengthOfLastWord1(String s) {
        String[] str = s.split(" ");
        if (str.length == 0) {
            return 0;
        }
        return str[str.length - 1].length();
    }

    /**
     * 下面这个没有用API
     * @param s
     * @return
     */
    public int lengthOfLastWord2(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        for(int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i) == ' ') {
                if(count == 0) {
                    continue;
                }
                break;
            }
            count++;
        }
        return count;
    }
}
