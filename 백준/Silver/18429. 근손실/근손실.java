import java.util.*;
import java.io.*;

public class Main {
    static int N;              // 뽑아야 할 개수
    static int K; 
    static int[] M;    // 사용할 재료 (운동 키트)
    static boolean[] visited; // 사용 여부 체크 (T/F)
    static int cnt = 0;
    
    static void backtracking(int depth, int val) {
        if(depth == N){
            cnt++;
            return;
        }
        
        for(int i = 0; i < N; i++){
            if(!visited[i] && val + M[i] - K >= 0) {
                visited[i] = true;
                
                backtracking(depth + 1, val + M[i] - K);
                
                visited[i] = false;
                
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        /*
        일단 또 경우의 수 문제다. 경우의 수 문제는 저번에 DP로 푼 경험이 있다.
        이 경우 더하는 수 - K를 해 갈때 한번 도 음수로 떨어지지 않아야 한다.
        그러면 이것도 DP로 풀 수 있나?
        DP는 큰 문제를 작게 분해해서 해결하는 것이다. 그런데 가능할 거 같다. 지금까지 가능 했던 경우의 수가 있으니까 앞으로도 가능하게 수를 붙이면 되는것이다.
        
        예전처럼 직접 손으로 만들어보자 운동키트는 한번만 사용가능
        
        K가 4고 N이 3이며, 1- 3, 2- 7, 3- 5
        이렇게 있을때 일단 첫번째 순서로 1번은 못온다.
        그래서 가능한건 2일때랑 3일때 이것도 하나씩 해보자
        
        1: 7 - 4 = 3 1가지
        2: 3 + (3 - 4) / 3 + (5 - 4) 2가지 
        3: 
        
        흠 근데 뭔가 N 값이 작은게 브루트 포스인듯????
        
        브루트 포스로 한번 접근해 보면 쉽긴한데 1초 안에 해결 되는지 생각을 해보자
        그러면 그냥 다 해보고 될때마다 카운트 올리면 될듯
        
        모든 경우의 수 대로 다 섞는거는 어떻게 해야 할까?
        
        1 2 3
        1 3 2
        2 1 3
        2 3 1
        3 1 2
        3 2 1
        
        어떻게 만들지? 
        
        순열을 만드는 방법은 1. 백트래킹 2. 중첩 반복문 3. 비트마스킹을 활용한 DP (Bitmask DP)
        이 있다고 한다.
        
        
        */


        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        M = new int[N];
        visited = new boolean[N];
        
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            M[i] = Integer.parseInt(st.nextToken());
        }
        
        backtracking(0, 0);
        
        System.out.println(cnt);
        
        
        
        
    }
}
