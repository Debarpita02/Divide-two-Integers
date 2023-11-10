public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }

        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        
        return sign * (int) dividePositive(dvd, dvs);
    }

    private long dividePositive(long dividend, long divisor) {
        long result = 0;
        while (dividend >= divisor) {
            long temp = divisor, multiple = 1;
            while (dividend >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            dividend -= temp;
            result += multiple;
        }
        return result;
    }
}
