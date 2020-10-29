package study;

public class SummerWinterCoding2018_stations {
	
	public static void main(String[] args) throws Exception {

		int[] stations = {9};
		int answer = solution(16, stations, 2);
		System.out.println(answer);
	}
	
	 public static int solution(int n, int[] stations, int w) {
	        int answer = 0;
	        int location = 1;
	        int sIndex = 0;
	        
	        while(location <= n) {
	        	
	        	// 기지국 범위 안에 있을 때
	        	if( sIndex < stations.length && location >= stations[sIndex]-w) {
	        		location = stations[sIndex] + w + 1;
	        		sIndex++;
	        	}else {	// 기지국 범위 밖에 있을 때
	        		answer++;
	        		location += w*2 + 1;
	        	}
	        	
	        }
	        
	        
	        	
	        return answer;
	    }

}
