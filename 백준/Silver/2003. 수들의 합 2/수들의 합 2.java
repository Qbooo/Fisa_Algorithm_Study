import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        /*
            생각1 윈도우 슬라이딩 방식으로 해결해야하나?
            생각2 각 위치마다 한칸씩 더해가며 M이 나오거나 끝까지 가면 다음 숫자
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int num = 0;
        
        for(int i = 0; i < N; i++){
            int sum = 0;
            if(arr[i]==M){
                num++;
                continue;
            }
            for(int j = i; j < N; j++){
                sum += arr[j];
                if(sum == M){
                    num++;
                    break;
                }
            }
        }
        System.out.println(num);
    }
}
