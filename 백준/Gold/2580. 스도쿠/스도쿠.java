import java.util.*;
import java.io.*;

public class Main {
    static int[][] board = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0);
    }

    static boolean solve(int row, int col) {
        // 한 줄 끝나면 다음 줄로
        if (col == 9) return solve(row + 1, 0);
        // 모든 칸 완료
        if (row == 9) {
            print();
            return true;
        }
        // 이미 숫자가 있으면 다음 칸으로
        if (board[row][col] != 0) return solve(row, col + 1);

        // 1~9 시도
        for (int num = 1; num <= 9; num++) {
            if (isValid(row, col, num)) {
                board[row][col] = num;
                if (solve(row, col + 1)) return true;
                board[row][col] = 0; // 백트래킹
            }
        }
        return false; // 실패 → 되돌아가기
    }

    static boolean isValid(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            // 같은 행 체크
            if (board[row][i] == num) return false;
            // 같은 열 체크
            if (board[i][col] == num) return false;
        }
        // 3x3 박스 체크
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }
        return true;
    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (j > 0) sb.append(' ');
                sb.append(board[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}