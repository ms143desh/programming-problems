package org.example.contest.biweekly;

public class CountWaysToBuildGoodStrings2466 {
    public static void main(String[] args) {
        CountWaysToBuildGoodStrings2466 countWaysToBuildGoodStrings2466 = new CountWaysToBuildGoodStrings2466();
        System.out.println(countWaysToBuildGoodStrings2466.countGoodStrings(3,3,1,1));
        System.out.println(countWaysToBuildGoodStrings2466.countGoodStrings(2,3,1,2));
    }

    public int countGoodStrings(int low, int high, int zero, int one) {
        int goodStrCountArray[] = new int[high+1], mod = 1000000007, output = 0;
        goodStrCountArray[0] = 1;
        for(int i=1;i<=high;i++) {
            if(i >= zero) {
                goodStrCountArray[i] = (goodStrCountArray[i] + goodStrCountArray[i-zero])%mod;
            }
            if(i >= one) {
                goodStrCountArray[i] = (goodStrCountArray[i] + goodStrCountArray[i-one])%mod;
            }
            if(i >= low) {
                output = (output + goodStrCountArray[i])%mod;
            }
        }

        return output;
    }
}
