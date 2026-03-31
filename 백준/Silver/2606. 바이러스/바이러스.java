import java.util.*;
import java.io.*;

public class Main {
    /*
        1이랑 연결되어 있으면 다 걸린다.
        N 컴퓨터의 수, M 링크의수, M개의 링크 쌍
        배열을 하나 만들어서 infected com인지 아닌지 체크하면 될거 같고
        만약 infected com이면 쌍에 있는 다른 컴퓨터도 infected 상태로 만들어서 마지막에 배열에 infected가 몇개인지 세면 될거 같다.
        
        근데 위 풀이에 허점이 있었다. 예를 들어 순서쌍이 2-3, 1-2 이렇게 나오면 순서 때문에 3이 infected가 안된다. 이를 해결하기 위해서 BFS를 써봐야할거 같다.
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        ArrayList<Integer>[] arr = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            arr[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
        
            arr[u].add(v);
            arr[v].add(u);
        }// 여기까지 리스트의 배열을 만드는 과정
        
        boolean[] infected = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();
        
        int count = 0;
        
        queue.add(1);
        infected[1] = true;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(int next : arr[curr]){
                if(!infected[next]) {
                    infected[next] = true;
                    queue.add(next);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
