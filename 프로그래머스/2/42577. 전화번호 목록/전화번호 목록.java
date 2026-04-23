import java.util.HashSet;

class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>();
        
        for (String number : phone_book) {
            set.add(number);
        }
        
        for (String number : phone_book) {
            // nember -> number로 수정!
            for(int j = 1; j < number.length(); j++) {
                String prefix = number.substring(0, j);
                
                if (set.contains(prefix)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}