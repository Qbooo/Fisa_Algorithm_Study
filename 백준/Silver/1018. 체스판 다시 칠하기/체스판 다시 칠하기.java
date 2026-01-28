import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");

        int N = Integer.parseInt(first[0]);
        int M = Integer.parseInt(first[1]);

        char[][] board = new char[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int answer = Integer.MAX_VALUE;

        // 8x8 시작 위치 전부 탐색
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {

                int wStart = 0; // 왼쪽 위가 W일 때
                int bStart = 0; // 왼쪽 위가 B일 때

                for (int r = i; r < i + 8; r++) {
                    for (int c = j; c < j + 8; c++) {

                        // (r + c)가 짝수면 시작 색
                        if ((r + c) % 2 == 0) {
                            if (board[r][c] != 'W') wStart++;
                            if (board[r][c] != 'B') bStart++;
                        } else {
                            if (board[r][c] != 'B') wStart++;
                            if (board[r][c] != 'W') bStart++;
                        }
                    }
                }

                int repaint = Math.min(wStart, bStart);
                answer = Math.min(answer, repaint);
            }
        }

        System.out.println(answer);
    }
}
