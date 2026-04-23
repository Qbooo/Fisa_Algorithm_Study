class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];
        
        for (int[] puddle : puddles) {
            dp[puddle[1] - 1][puddle[0] - 1] = -1;
        }
        
        dp[0][0] = 1;
        
        // 4. 격자 순회
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                // 웅덩이인 경우 경로의 수를 0으로 만들고 다음 칸으로
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                
                // 위쪽 칸에서 오는 경로 더하기 (첫 행 제외)
                if (i > 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j]) % 1000000007;
                }
                
                // 왼쪽 칸에서 오는 경로 더하기 (첫 열 제외)
                if (j > 0) {
                    dp[i][j] = (dp[i][j] + dp[i][j - 1]) % 1000000007;
                }
            }
        }
        
        // 5. 학교 위치(n-1, m-1)의 결과 반환
        return dp[n - 1][m - 1];
        

        
    }
}