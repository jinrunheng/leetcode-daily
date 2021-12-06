## 372. 超级次方
本题考查的知识点有 2 个：
- 快速幂
- 取模公式

题目中要求我们计算 `a^b` 并对 `1337` 取模，给定 `a` 的取值范围为 `1 <= a <= 2^31 - 1`；`b` 则是一个非常大的正整数，并且以数组的形式给出。

既然涉及到大数，我们就自然要想到越界问题。这里面就需要用到取模公式：
```text
(a * b) % k = ((a % k) * (b % k)) % k
```
而快速幂则是为了减少迭代的次数，优化复杂度，快速幂的代码：
```java
private int myPow(int x,int n){
    if(n == 0)
        return 1;

    if(n % 2 == 0)
        return myPow((x % MOD) * (x % MOD),n / 2);
    else
        return (myPow(x,n - 1) * (x % MOD)) % MOD;
}
```
本题代码：
```java
class Solution {
    static final int MOD = 1337;
    public int superPow(int a, int[] b) {
        // a = 2; b = [4,3,3,8,5,2]
        // res = 2^400000 * 2^30000 * 2^3000 * 2^800 * 2^50 * 2^2
        // res = (2^100000)^4 * (2^10000)^3 * (2^1000)^3 * (2^100)^8 * (2^10)^5 * (2^1)^2
        // 从后向前进行遍历
        int res = 1;
        for (int i = b.length - 1; i >= 0; --i) {
            res = (int) ((long) res * myPow(a, b[i]) % MOD);
            a = myPow(a, 10);
        }
        return res;
    }
    
    private int myPow(int x,int n){
        if(n == 0)
            return 1;
        
        if(n % 2 == 0)
            return myPow((x % MOD) * (x % MOD),n / 2);
        else
            return (myPow(x,n - 1) * (x % MOD)) % MOD;
    }
}
```







