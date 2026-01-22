import java.io.*;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        int num = 0;
        int j = 1;
        for(int i = 0; i < n; i++){
            for(; j <= Integer.MAX_VALUE; j++){
                if(String.valueOf(j).contains("666")){
                    num = j++;
                    break;
                }   
            }
        }
        System.out.println(num);
    }
}