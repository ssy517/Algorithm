package study;

public class SummerWinterCoding2018_Jump {
	
	public static void main(String[] args) throws Exception {

		int n = 6;
		int answer = solution(n);
		System.out.println(answer);
	}
	
	public static int solution(int n) {
        int ans = 1;

        int i=n;
        while(i/2 != 0) {
        	if(i%2 == 1) {
        		i = i-1;
        		System.out.println("i: " + i);
        		ans++;
        	}
        	i = i/2;
        }
        
        return ans;
    }

}
