import java.util.*;
import java.io.*;

class Player {
    int level;
    String nickname;
    
    public Player(int level, String nickname) {
        this.level = level;
        this.nickname = nickname;
    }
}

class Room {
    int baseLevel;
    ArrayList<Player> players = new ArrayList<>();
    
    public Room (Player player){
        this.baseLevel = player.level;
        this.players.add(player);
    }
    
    public void addPlayer(Player player) {
        this.players.add(player);
    }
}

public class Main {
    /*
    1.+-10 처음 입장 플레이어 기준 
    2. 정원 대기(먼저 생성된 방 우선)
    3. 정원 차면 게임 시작
    
    내 생각에는 P(플레이어 수), m(방의 정원) 은 정해 놓고
    l과 n은 클래스로 만들어서
    
    그리고 방도 배열(or 리스트)로 만들어서 뭐가 먼저 만든 방인지 알아야될거 같다
    
    그래서 모든 방에 대해서 게임 시작 유무와 방에 들어있는 플레이어들의 레벨과 아이디를 출력한다. 방은 생성된 순서대로 출력한다. 방에 있는 플레이어들의 정보는 닉네임이 사전순
    
    시작된 방은 Started! 대기중이면 Waiting
    
    처음에는 방은 그냥 리스트나 배열이면 될 줄 알았는데, 방이 또 플레이어들을 가지고 있는 거니까 방도 클래스여야 방이 어떤 유저들을 지니고 있는건지 기록 할 수 있을거 같긴 하다. <객체 지향적 사고>
    
    */
    static int p;
    static int m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        ArrayList<Room> rooms = new ArrayList<>();

        for(int i = 0; i < p; i++){
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String nickname = st.nextToken();
            
            Player player = new Player(level, nickname);
            
            boolean isMatched = false;
            
            for(Room room : rooms) {
                if(room.players.size() < m && Math.abs(room.baseLevel - level) <= 10) {
                    room.addPlayer(player);
                    isMatched = true;
                    break;
                }
            }
            if (!isMatched) {
                rooms.add(new Room(player));
            }
            
            
        }
        
        for (Room room : rooms) {
    // 1. 정렬: 익명 클래스 방식
    Collections.sort(room.players, new Comparator<Player>() {
        @Override
        public int compare(Player p1, Player p2) {
            return p1.nickname.compareTo(p2.nickname);
        }
    });

    // 2. 출력: System.out 방식
    if (room.players.size() == m) System.out.println("Started!");
    else System.out.println("Waiting!");

    for (Player p : room.players) {
        System.out.println(p.level + " " + p.nickname);
    }
}
      
        
        
    }
}
