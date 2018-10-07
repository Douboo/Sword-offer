public class StringToInteger {
    /**
     * https://www.lintcode.com/problem/string-to-integer-atoi/description?_from=ladder&&fromId=6
     *
     * 实现atoi这个函数，将一个字符串转换为整数。如果没有合法的整数，返回0。如果整数超出了32位整数的范围，返回INT_MAX(2147483647)如果是正整数，或者INT_MIN(-2147483648)如果是负整数。
     *
     * 样例
     * "10" =>10
     *
     * "-1" => -1
     *
     * "123123123123123" => 2147483647
     *
     * "1.0" => 1
     * @param str: A string
     * @return: An integer
     */
    public int atoi(String str) {
        // write your code here
        if(str == null || str.length() == 0){
            return 0;
        }
        str = str.trim();
        int index = 0;
        int sign = 1;
        if(str.charAt(0) == '+'){
            index++;
        }
        if(str.charAt(0) == '-'){
            index++;
            sign = -1;
        }
        long num = 0;
        for(; index<str.length(); index++){
            if(str.charAt(index) < '0' || str.charAt(index) > '9'){
                break;
            }
            num = num * 10 + str.charAt(index) - '0';
            if(num > Integer.MAX_VALUE){
                break;
            }
        }
        if(sign * num >= Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(sign * num <= Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int)num * sign;

    }
}
