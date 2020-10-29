package study;

import java.util.HashSet;

public class SummerWinterCoding2018_visitLength {
	
	public static void main(String[] args) throws Exception {

		String drs = "LULLLLLLU";
		int answer = solution(drs);
		System.out.println(answer);
	}
	
	public static int solution(String dirs) {
		int answer = 0;     
        int x = 0, y = 0;
        
        HashSet<String> set = new HashSet<>();
        
        for(Character dir : dirs.toCharArray()){
            int lastX = x, lastY = y;
            
            if(dir == 'U' && y+1 <= 5) y++;
            if(dir == 'D' && y-1 >= -5) y--;
            if(dir == 'R' && x+1 <= 5) x++;
            if(dir == 'L' && x-1 >= -5) x--;   
            
            if(lastX == x && lastY == y){
                continue;
            }
            
            //양방향 다 넣어주기
            set.add(lastX+""+lastY+""+x+""+y);
            set.add(x+""+y+""+lastX+""+lastY);
        }
        
        answer = set.size()/2;
        return answer;
    }

}
