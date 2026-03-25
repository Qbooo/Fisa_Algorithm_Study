import java.util.*;
import java.io.*;
public class Main {
    // 코드를 작성해주세요
    /*
    순열 구하는거는 예전에 백트레킹으로 했었다.
    근데 여기서는 미친 변수 발생이 같은 수를 여러번 골라도 된다는게 변수긴 하다.
    이러면 그냥 계속 테이블에는 숫자를 두고 M개를 뽑는데 조건에 맞는지 확인하고 근데 전에 뽑았던 순열인지 아닌지는 어떻게 해결해야지?
    전에 뽑았던 순열 완성된거를 저장하는 배열을 하나 만들어야 하나?
    DFS를 활용한 백트래킹 자체가 하나에서 시작해서 여러개로 한번에 뻗어나가는 특성이 있고 다 다른 경우의 수로 뻗어나가기 때문에 중복은 신경 쓸 필요가 없다고 한다.
    
    숫자 테이블을 위한 배열과 내가 숫자를 담을 배열이 필요하다. - q1
    그리고 안내림차순을 만들기 위해서 숫자 테이블 자체를 미리 정렬해두면 간편하다고 한다.
    
    
    */
    static int N, M;
    static int[] arr;
    static int[] input;
    static StringBuilder sb = new StringBuilder();
    
    public static void backTracking(int cnt, int start) {
        if(cnt == M){
            for(int i = 0; i < M; i++) {
                if (i > 0) sb.append(" ");
                sb.append(arr[i]);
            }
            sb.append("\n");
            return;
        }
        
        for(int i = start; i < N; i++){
            if(i > start && input[i] == input[i - 1]) continue;
           
            arr[cnt] = input[i];
            backTracking(cnt+1, i);
            
        }
        
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // ← N, M 파싱 빠짐
        M = Integer.parseInt(st.nextToken());

        input = new int[N];
        arr = new int[M];
    
        st = new StringTokenizer(br.readLine()); // ← 두 번째 줄 읽기
        
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input); // 사전순 출력을 위해 정렬

        backTracking(0, 0);
        System.out.print(sb);
    }
}
