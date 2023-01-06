package org.example;

public class MinimumAdditionToMakeInteger2457 {
    public static void main(String[] args) {
        MinimumAdditionToMakeInteger2457 minimumAdditionToMakeInteger2457 = new MinimumAdditionToMakeInteger2457();
        System.out.println(minimumAdditionToMakeInteger2457.makeIntegerBeautiful(16, 6));//4
        System.out.println(minimumAdditionToMakeInteger2457.makeIntegerBeautiful(467, 6));//33
        System.out.println(minimumAdditionToMakeInteger2457.makeIntegerBeautiful(1, 1));//0
        System.out.println(minimumAdditionToMakeInteger2457.makeIntegerBeautiful(8, 2));//2
        System.out.println(minimumAdditionToMakeInteger2457.makeIntegerBeautiful(19, 1));//81
        System.out.println(minimumAdditionToMakeInteger2457.makeIntegerBeautiful(165, 10));//5
    }

    public long makeIntegerBeautiful(long n, int target) {
        int sum = calculateSumOfDigits(n);
        if(sum <= target) {
            return 0;
        }

        long tempNum = n;
        long tempTarget = 1;
        int i = 1;
        while(tempNum > 0) {
            tempNum /= 10;
            tempTarget *= 10;
            if(calculateSumOfDigits((tempNum + 1) * tempTarget) <= target) {
                return (tempNum + 1) * tempTarget - n;
            }
        }
        if(tempTarget > 10) {
            tempTarget = tempTarget/10;
        }


        while(i<=10) {
            if(i * tempTarget >= n && calculateSumOfDigits(i * tempTarget) <= target ) {
                break;
            }
            i++;
        }

        return (i * tempTarget) - n;
    }

    private int calculateSumOfDigits(long n) {
        int sum = 0;
        while(n > 0) {
            sum += n%10;
            n /= 10;
        }
        return sum;
    }
}
