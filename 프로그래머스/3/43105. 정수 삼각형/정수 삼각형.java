class Solution {
    public int solution(int[][] triangle) {
        
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                
                if (j == 0) {
                    triangle[i][j] += triangle[i - 1][j];
                } 
                else if (j == i) {
                    triangle[i][j] += triangle[i - 1][j - 1];
                } 
                else {
                    triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
                }
            }
        }


        
        return findMax(triangle[triangle.length - 1]);
    }
    

    private int findMax(int[] lastRow) {
        int max = 0;
        for (int value : lastRow) {
            if (value > max) max = value;
        }
        return max;
    }
}