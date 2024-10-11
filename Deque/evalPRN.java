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