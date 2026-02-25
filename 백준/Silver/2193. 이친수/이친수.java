import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        // 코드를 작성해주세요
        /*
        이진수 중 특별한 수가 이친수
        1. 이친수는 0으로 시작하지 않는다.
        2. 이친수는 1이 두 번 연속으로 나타나지 않는다
        11이 있으면 안됨
        
        N자리가 주어지면 N자리의 이친수는 몇개인지 구하라.
        
        나의 생각 
        1 일단 모든 경우의 수 에서 시작이 0인거랑 11부분 문자열인거를 뺸 거를 카운트 해보자
        <- 2의 90승을 전부 카운트 해야 하는데 2의 90승은 너무 크다 2초만에 불가능
        
        2. 그러면 뭔가 규칙성을 찾아야 하는가? 규칙성(DP) or 수학적 규칙
        
        DP는 큰 문제가 작은 문제의 답을 포함하는 경우다 일단 무지성으로 N을 다 해봤다.
        N=1 1 ^1
        N=2 10 ^1
        N=3 100 101 ^ 2
        N=4 1000 1001 1010 ^3
        N=5 10000 10001 10010 10100 10101 ^5
        
        피보나치 수열 같은데 이게 n번째 가지수를 고를때 n은 그전에 1로 끝나는 수는 뒤에 0만 붙여야하고 맨 뒤가 0으로 끝나면 뒤에 1혹은 0을 붙일 수 있다. 그래서 각 n마다 뒤에 1로 끝나는게 몇개인지 0으로 끝나는게 몇개인지 아는게 중요하다.
        근데 1로 끝나던 애는 다음 n+1에서 0이 되고 0으로 끝나는 애는 하나의 1과 하나의 0을 만들어 준다. 
        
        -> 여기서 전단계랑 전전단계를 이용하려면 전단계에는 다 뒤에 0을 붙이고 전전 단계에서는 다 뒤에 01을 붙이면 된다고 생각을 하면 n은 n-1 + n-2가 된다.
        */
        // 1. BufferedReader 선언 (Scanner보다 훨씬 빠름)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 2. 입력 받기 (문자열로 읽어오므로 정수로 변환 필요)
        int n = Integer.parseInt(br.readLine());

        // 3. DP 배열 선언 (N=90일 때 결과가 크므로 반드시 long 사용)
        // 인덱스를 n까지 쓰기 위해 크기를 n+1로 설정하거나, 
        // n=1일 때를 대비해 여유 있게 91로 설정합니다.
        long[] dp = new long[91];

        // 4. 초기값 설정 (가장 작은 문제들의 정답)
        dp[1] = 1; // 1자리는 "1" 하나뿐
        dp[2] = 1; // 2자리는 "10" 하나뿐

        // 5. 점화식을 이용한 Bottom-Up 채우기
        // i가 3부터 시작하여 n까지 순차적으로 계산
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // 6. 결과 출력
        System.out.println(dp[n]);
        
        // 사용한 리소스 닫기 (생략 가능하지만 습관으로 두면 좋음)
        br.close();
        
    }
}
