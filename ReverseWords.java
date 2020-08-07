package leetcode;


/*
557. 反转字符串中的单词 III

        给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

        示例 1:

        输入: "Let's take LeetCode contest"
        输出: "s'teL ekat edoCteeL tsetnoc"

        注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
*/


/**
 * 注意的是最后一个单词后面不能有空格
 * 也可以不要那个if语句
 * 在return的后面加上trim()(这个意思就是去掉字符串两bai端的多余的空格)
 */
public class ReverseWords {
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < str.length; i++) {
            sf.append(new StringBuffer(str[i]).reverse().toString());
            if (i != str.length - 1) {
                sf.append(" ");
            }
        }
        return sf.toString();
    }
}
