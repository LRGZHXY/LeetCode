import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque=new LinkedList<>();

        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+")){
                deque.push(deque.pop()+deque.pop());
            }else if(tokens[i].equals("-")){
                deque.push(-deque.pop()+deque.pop());
            }else if(tokens[i].equals("*")){
                deque.push(deque.pop()*deque.pop());
            }else if(tokens[i].equals("/")){
                int a=deque.pop();
                int b=deque.pop();
                deque.push(b/a);
            }else{
                deque.push(Integer.valueOf(tokens[i]));
            }
        }

        return deque.pop();
    }
}