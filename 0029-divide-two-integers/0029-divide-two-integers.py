class Solution(object):
    def divide(self, dividend, divisor):
        if dividend == -2**31 and divisor == -1:
            return 2**31 - 1 

        negative = (dividend < 0) ^ (divisor < 0)
        abs_dividend, abs_divisor = abs(dividend), abs(divisor)
        quotient = 0
        while abs_dividend >= abs_divisor:
            temp_divisor, multiple = abs_divisor, 1
            while abs_dividend >= (temp_divisor << 1):
                temp_divisor <<= 1
                multiple <<= 1
            abs_dividend -= temp_divisor
            quotient += multiple
        return -quotient if negative else quotient