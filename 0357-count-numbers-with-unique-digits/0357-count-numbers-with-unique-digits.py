class Solution:
    def countNumbersWithUniqueDigits(self, n: int) -> int:
        if n == 0:
            return 1
        if n == 1:
            return 10

        count = 10
        unique_digits = 9
        available_number = 9
        
        for i in range(1, n):
            unique_digits *= available_number
            count += unique_digits
            available_number -= 1
        return count