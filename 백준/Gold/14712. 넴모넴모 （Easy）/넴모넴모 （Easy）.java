import java.io.*;
import java.util.*;
public class Main {
    // 코드를 작성해주세요/
        /* 빈칸에 넴모 넣고 2x2나오면 터트리기 근데 노잼격자판 위에 없앨 수 있는 넴모가 없으면 게임 그만.
        게음을 그만 두었을때 나올 수 있는 넴모의 배치 가짓수
        
        2x2일때 15가지 어떻게 해야할까 생각나는거 첫번째는
        1. 완전탐색하면서 2x2있는건는 안 세기
        
        그러면 백 트래킹으로 코드를 짜고  메소드 하나 만들어서 2x2가 있는거를 검사까지 해주면서 2x2있으면 넘어가고 백트래킹 코드는 그냥 하나씩 다 채워보는걸로 하면 될거 같긴 함 일단 해볼까
        
        백트레킹은 결정 - 탐색 - 복구의 과정
        매 칸마다 넴모를 놓을지 놓지 않을지를 생각해야 한다.
        넴모를 놓으려 할때는 넴모를 놓아도 사각형이 생기지 않는지 확인해야한다.
        
        백트레킹에 대한 이해 DFS에 대한 이해 조금 더 필요
        
        일단 내가 정해 놓은 틀 안에서 못 나가게 메서드 하나
        조건을 만족하는지 메서드 또 하나 
        를 놓고서 백트래킹으로 하면 될거 같긴 하다.
        
        
        */
    static int N, M;
    static boolean[][] checked;
    static int cnt = 0;
    
    public static boolean isNemo(int r, int c){
        // 현재 칸에 넴모를 놓았을 때 2x2 사각형이 만들어지면 true 반환
        return checked[r - 1][c] && checked[r][c - 1] && checked[r - 1][c - 1];
    }
    
    public static void backtracking(int blocks){
        if(blocks == N * M) {
            cnt++;
            return;
        }
        
        int r = blocks / M + 1;
        int c = blocks % M + 1;
        
        // [선택지 1] 현재 칸에 넴모를 놓지 않는 경우
        // 넴모를 안 놓으면 2x2가 생길 일이 없으니 언제나 탐색 가능
        backtracking(blocks + 1);

        // [선택지 2] 현재 칸에 넴모를 놓는 경우
        // 단, 2x2 사각형이 형성되지 않을 때만 (isNemo가 false일 때만)
        if (!isNemo(r, c)) {
            checked[r][c] = true;    // 결정 (상태 변경)
            backtracking(blocks + 1); // 탐색 (다음 단계로)
            checked[r][c] = false;   // 복구 (상태 되돌리기)
        }
        
        
    }
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        // 인덱스 에러(r-1, c-1)를 방지하기 위해 배열을 넉넉하게 잡음
        checked = new boolean[N + 1][M + 1];

        // 0번 칸(0, 0)부터 탐색 시작
        backtracking(0);

        // 최종 결과 출력
        System.out.println(cnt);
        
        
    }
}
