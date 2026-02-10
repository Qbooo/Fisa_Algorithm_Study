import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /*1. 최대값을 고른다
          2. 모든 점수를 n/최대값으로 고친다.
          3. 평균을 낸다
        
          배열 하나만 있으면 될거 같은데
        
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double [] a = new double [n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        double max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(a[i], max);
        }
        for(int i = 0; i < n; i++){
            a[i] = a[i]/max * 100;
        }

        double avg = Arrays.stream(a)
                   .average()
                   .orElse(0);
        System.out.println(avg);
    }
}
