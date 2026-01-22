import java.io.*;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;

        while(n>0){
            if(n%5==0){
                cnt = cnt + n/5;
                break;
            }
            n = n - 3;
            cnt++;
        }
        if(n%5 == 0){
            System.out.print(cnt);
        }else{
            System.out.print(-1);
        }

    }
}