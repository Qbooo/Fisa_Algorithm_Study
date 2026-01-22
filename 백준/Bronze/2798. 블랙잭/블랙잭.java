import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄: N(카드 개수), M(목표값)
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());  // 카드 개수
        int m = Integer.parseInt(st.nextToken());  // 목표값
        
        // 두 번째 줄: N개의 카드 숫자들
        st = new StringTokenizer(br.readLine());
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        
        // 여기서부터 3장 뽑아서 합 구하는 로직 작성
        int max = 0;
        for(int i = 0; i < n-2; i++){
            for(int j = i + 1; j < n - 1; j++){
                for(int k = j + 1; k < n; k++){
                    
                    int a = cards[i]+cards[j]+cards[k];
                    if(max < a && a <= m){
                        max = a;
                    }
                }
            }
        }
        System.out.println(max);
    }
}