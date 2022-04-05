package com.vine.alg.dynamic;

/**
 * @author 阿季
 * @date 2022-04-05 4:13 PM
 */

public class 凑零钱 {

    public static void main(String[] args) {
        凑零钱 c = new 凑零钱();
        int[] coins = new int[]{1, 2, 3};
        int i = c.coinChange(coins, 11);
        System.out.println(i);
    }

    int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 子问题无解时跳过，执行下一个
            int subProblem = coinChange(coins, amount - coin);
            if (subProblem == -1) {
                continue;
            }
            min = Integer.min(min, subProblem + 1);
        }
        return min;

    }


}
