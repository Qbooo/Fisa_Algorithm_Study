import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 코드를 작성해주세요
        /*
        계단 오르기

가중치가 있는 조합 -> 최대값 구하기

+1 or + 2 가능 연속해서 3계단은 못 올라간다



일차원 배열을 만들어서 최대값만 집어넣고 계속 더한다

즉
6 10 20 15 25 10 20

A[0] = 10
A[1] = 30

A[2]는 10 + 15나 30 + 15에서 선택?
근데 30 + 15는 안된다 즉 
A[2] = 25
근데 첫번째 계단도 밟을수도 안밟을 수도 있으니까 
A[0] = 10
A[1] = 20 or 30
그러면 이때 a[2] = 25
A[3] = 

이거 a[n] =max( × + a[n-1] , x + a[n-2])
이런식으로 풀고 싶은데 3계단을 연속해서 밟으면 안된다는 조건을 어떻게 코드로 풀어내야할지 모르겠음

가중치들을 stair이라는 배열에 담고
Dp[n]은 stair[n] + dp[n-2] 이거나 stair[n] + stair[n-1] + dp[n-3] 중에 큰 값을 고르면 된다.

근데 이거 무조건 dp적으로 최대값인가? 는 좀 궁금함 직접 예시를 해봐야할거 같음

계단번호:  1   2   3   4   5   6
점수:     10  20  15  25  10  20
```
```
dp[1] = 10
dp[2] = 10 + 20 = 30

dp[3] = max(경우A, 경우B)
      = max(dp[1] + stair[3],  dp[0] + stair[2] + stair[3])
      = max(  10  +    15   ,    0   +    20    +    15   )
      = max(25, 35) = 35

dp[4] = max(dp[2] + stair[4],  dp[1] + stair[3] + stair[4])
      = max(  30  +    25   ,    10  +    15    +    25   )
      = max(55, 50) = 55

dp[5] = max(dp[3] + stair[5],  dp[2] + stair[4] + stair[5])
      = max(  35  +    10   ,    30  +    25    +    10   )
      = max(45, 65) = 65

dp[6] = max(dp[4] + stair[6],  dp[3] + stair[5] + stair[6])
      = max(  55  +    20   ,    35  +    10    +    20   )
      = max(75, 65) = 75
        */
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine().trim());
        
        int[] stair = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stair[i] = Integer.parseInt(br.readLine().trim());
        }
        
        int[] dp = new int[n + 1];
        
        dp[1] = stair[1];
        if (n >= 2) dp[2] = stair[1] + stair[2];
        
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(
                dp[i-2] + stair[i],
                dp[i-3] + stair[i-1] + stair[i]
            );
        }
        
        System.out.println(dp[n]);
    }
}
