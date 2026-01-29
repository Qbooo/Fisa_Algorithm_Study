import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        /*
        2부터 숫자를 올려가면서 나머지가 0일때만 나누고
        나눈숫자에 동일 로직 반복
        그리고 나눈 숫자 자체가 1이 되면 반복 종료
        */
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(br.readLine());

        while (a > 1) {
            int i = 2;

            while (a % i != 0) {
                i++;
            }

            sb.append(i).append("\n"); // 소인수 출력
            a /= i;
        }

        System.out.print(sb.toString());
    }
}
