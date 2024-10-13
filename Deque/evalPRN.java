import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result=new int[temperatures.length];
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        for(int i=1;i<temperatures.length;i++){
            if(temperatures[i]<=temperatures[stack.peek()]){
                stack.push(i);
            }
            else{
                while(!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                    result[stack.peek()]=i-stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return result;
    }
}


class Solution {
    public int change(int amount, int[] coins) {
        int[] dp=new int[amount+1];
        dp[0]=1;

        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++){
                dp[j]=dp[j]+dp[j-coins[i]];
            }
        }

        return dp[amount];
    }
}