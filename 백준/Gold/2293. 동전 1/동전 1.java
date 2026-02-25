
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        /*
            나의 생각 1 뭔가 DP의 냄새가 난다.
            일단 n으로 k를 만들어야 하는데 이것도 조합인거 같다.
            근데 가중치가 있는 조합?
            
            예제에 있는거를 생각 해보자면
            
            1, 2, 5를 가지고 10을 만들 수 있는 다양한 경우의 수를 구해보자
            일단 가장 큰 수를 최대한 많이 가지고 (5) k(10)을 만들어 보고 만들 수    
            있으면 그 이후에 작은 숫자들로 해당 숫자를 대체할 수 있는지를 생각하
            면서 하면 될거 같다. 
            
            일단 이거는 절대 무지성 브루트포스는 안될거 같고, 
            
            내가 생각하고 있는거는 배열을 만들어 놓고 1에서 부터 K까지 숫자를 올    려가면서 해당 숫자의 인덱스를 가진 배열에 숫자를 더하는건데 주어질 숫자들이 있으니까 그 주어진 숫자들로 채울 수 있는 경우의 수 만큼 더해가면서 하면 될거 같거든?
            
            까지가 나의 생각이였는데
            
            이걸 좀 더 코드적 로직적으로 풀어내면 숫자를 만드는데 쓸 동전의 개수를 하나씩 늘려가면서 배열의 값을 업데이트 하는거였다. 처음에는 1만 쓸거면 한가지 경우의 수 밖에 없고 그 다음에 2를 쓰면 n의 값이 2이상이 되는 순간 부터 dp[2] + [dp2-2]를 해서 2원을 하나 깔고 1을 쓰는 경우의 수를 기존 1만 쓰던거에 더해준다. 그러면 4에서는 dp[4] + dp[4-2] 가 되면 (1로만 4를 만드는 경우의 수 하나)랑 (dp[2]<- 아까 업데이트 해서 2를 1로만 만드는 경우의 수) + (2동전 하나 깔고 하는 경우의 수) 포함 되어 있음, dp[3] 같은 경우는 dp[3] + dp[1]이면 1 + 1이고 dp[5]면 dp[5] + dp[3] = 1 + 2 다. 여기까지가 동전 1만 쓰다가 동전 2원을 추가한 경우고 이제 이게 업데이트가 된 상황에서 동전 5원을 추가하면
            
            dp[5] = dp[5] + d[5-5] <- 1원이랑 2원으로 5를 만들던 경우의 수 + 5원 하나 깐거
            이런식으로 업데이트를 해 나가야 하는거 같다.
        
        
        
        */
        
        // 1. 빠른 입력을 위한 BufferedReader와 StringTokenizer 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 동전 종류 수
        int k = Integer.parseInt(st.nextToken()); // 목표 금액

        // 2. 동전 가치를 담을 배열과 DP 배열 선언
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        // 3. DP 배열 선언 (금액 k까지 담아야 하므로 k+1 크기)
        // 메모리 4MB 제한을 위해 1차원 배열 사용
        int[] dp = new int[k + 1];

        // 4. 초기값 설정
        // 0원을 만드는 경우의 수는 "아무것도 선택하지 않는" 1가지입니다.
        dp[0] = 1;

        // 5. 핵심 로직: 동전을 하나씩 고정하고 금액을 늘려가며 경우의 수 누적
        for (int i = 0; i < n; i++) {
            int currentCoin = coins[i];
            
            // 현재 선택한 동전의 가치부터 목표 금액 k까지 업데이트
            for (int j = currentCoin; j <= k; j++) {
                // 점화식: 현재 금액(j)을 만드는 법 = 기존 방법 + (j - 현재동전)원을 만들었던 방법
                dp[j] = dp[j] + dp[j - currentCoin];
            }
        }

        // 6. 결과 출력
        System.out.println(dp[k]);
        
        br.close();
    }
}
