package study;

import java.util.Stack;

public class SummerWinterCoding2018_SkillTree {
	
	public static void main(String[] args) throws Exception {

		String[] arr = {"BACDE", "CBADF", "AECB", "BDA"};
		int answer = solution("CBD", arr);
		System.out.println("answer " + answer);
	}
	
	
	 public static int solution(String skill, String[] skill_trees) {
	        int answer = 0;
	        char[] arr = skill.toCharArray();
	        
	        Stack<Character> stack = new Stack<Character>();
	        
	        
	       
	        
	        for (int i = 0; i < skill_trees.length; i++) { //trees 하나씩 비교
	        	 boolean b = true;
	        	for (int j = arr.length-1; j >= 0; j--) {
	        		stack.add(arr[j]);
	        	}
	        	
				// skill 포함하는지?
				loop: for (int j = 0; j < skill_trees[i].length(); j++) {
					for (int j2 = 0; j2 < arr.length; j2++) {
						if(skill_trees[i].charAt(j) == arr[j2]) {
							//System.out.println("같은거있음");
							
							// 순서 비교
							if(skill_trees[i].charAt(j) != stack.peek()) {
								//System.out.println("peek: " + stack.peek());
								b = false;
								break loop;
							}else {
								stack.pop();
							}
							
						}
					}
					
				}
	        	
				if(b) {
					answer++;
				}
			}
	        
	        return answer;
	    }

}
