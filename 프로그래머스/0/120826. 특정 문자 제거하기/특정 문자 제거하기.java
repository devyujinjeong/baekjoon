class Solution {
    public String solution(String my_string, String letter) {
        String answer = "";
        
        if(my_string.contains(letter)){
            my_string = my_string.replaceAll(letter,"");
        }
        
        answer = my_string;
        
        return answer;
    }
}