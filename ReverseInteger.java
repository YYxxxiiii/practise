package leetcode;

/*
7.整数反转
给出一个 32 位的有符号整数，
你需要将这个整数中每位上的数字进行反转。
        示例 1:
        输入: 123
        输出: 321

        示例 2:
        输入: -123
        输出: -321

        示例 3:
        输入: 120
        输出: 21

        注意:
        假设我们的环境只能存储得下 32 位的有符号整数，
        则其数值范围为 [−231,  231 − 1]。请根据这个假设，
        如果反转后整数溢出那么就返回 0。
*/
public class ReverseInteger {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        int neg = x < 0 ? -1 : 1; //负号
        x *= neg;//变成正数
        int ret = 0;
        while (x > 0) {
            int n = ret;
            n *= 10;
            n += x % 10;
            x /= 10;
            if (n / 10 != ret) { //判断是否溢出
                return 0;
            }
            ret = n;
        }
        return ret *=neg;
    }
    
    public static void main(String[] args) {
        ReverseInteger so = new ReverseInteger();
        System.out.println(so.reverse(-123));
    }
}

