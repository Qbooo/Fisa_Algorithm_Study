import java.util.*;
import java.io.*;
class Node implements Comparable<Node> {
    int target;
    int cost;
    
    public Node(int target, int cost) {
        this.target = target;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Node other) {
        return this.cost - other.cost;
    }
}
public class Main {
    /* 가중치가 있는 길찾기 = 가중치가 있는 조합?
    
    헛간 N개 [n] 길 M -
     A-B로 N끼리 잇는다 A-B에는 C마리의 소가 있다.
    
    일단 길을 어떻게 코드로 표현할거냐? 첫번째 관건
    
    전에 가중치가 있는 조합은 DP를 활용해서 풀었는데 맞는가?
    
    근데 여기서는 DP가 아닌거 같다.
    
    오히려 백트래킹이 맞지 않을까? 싶기도 하다
    
    처음 연결되는 길의 가중치 합을 저장해두고 이후에 해당 가중치 보다 커지면 바로 백트래킹 하고 해당 가중치 보다 작은것만 두 헛간을 연결하게 해서 기존 값보다 작으면 가중치의 합의 값을 바꾼다.
    
    이러면 답이 나올거 같은데 일단 코드로 어떻게 길을 표현할 것인지가 조금 관건이다.
    
    값이 너무 많아서 백트래킹으로 하면 안되고 다익스트라라고 해야한다고 한다 근데 나는 다익스트라를 모른다
    
    */
    static int n;
    static int m;
    static ArrayList<Node>[] adj;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    
    adj = new ArrayList[n+1];
    
    for(int i = 1; i < n+1; i++){
        adj[i] = new ArrayList<>();
    }
    
    for (int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        // 양방향 길이라는 점 주의!
        adj[a].add(new Node(b, c));
        adj[b].add(new Node(a, c));
    }
    
    dist = new int[n + 1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    
    dijkstra(1);
    
    System.out.println(dist[n]);
        
    }
    
    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int now = current.target;
            int nowCost = current.cost;

            if (dist[now] < nowCost) continue;

            for (Node neighbor : adj[now]) {
                int nextCost = dist[now] + neighbor.cost;

                if (nextCost < dist[neighbor.target]) {
                    dist[neighbor.target] = nextCost;
                    pq.add(new Node(neighbor.target, nextCost));
                }
            }
        }
    }
}
