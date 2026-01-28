import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int tc = 0; tc < t; tc++) {

            int n = Integer.parseInt(br.readLine()); // 옷 개수
            Map<String, Integer> map = new HashMap<>();

            // 종류별 개수 세기
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();               // 옷 이름 (안 씀)
                String type = st.nextToken(); // 옷 종류

                map.put(type, map.getOrDefault(type, 0) + 1);
            }

            // 경우의 수 계산
            int result = 1;
            for (int count : map.values()) {
                result *= (count + 1);
            }

            // 알몸인 경우 제거
            result -= 1;

            System.out.println(result);
        }
    }
}
