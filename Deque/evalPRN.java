import javax.swing.tree.TreeNode;
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

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0||postorder.length==0){
            return null;
        }
        TreeNode root=makeTree(inorder,0,inorder.length,postorder,0,postorder.length);
        return root;
    }

    public TreeNode makeTree(int[] inorder,int inorderStart,int inorderEnd,int[] postorder,int postorderStart,int postorderEnd){
        if(postorderStart==postorderEnd){
            return null;
        }

        int rootVal=postorder[postorderEnd-1];
        TreeNode root=new TreeNode(rootVal);

        int rootIndex;
        for(rootIndex=inorderStart;rootIndex<inorderEnd;rootIndex++){
            if(inorder[rootIndex]==rootVal){
                break;
            }
        }

        int leftNum=rootIndex-inorderStart;

        int leftInorderStart=inorderStart;
        int leftInorderEnd=rootIndex;
        int rightInorderStart=rootIndex+1;
        int rightInorderEnd=inorderEnd;

        int leftPostOrderStart=postorderStart;
        int leftPostOrderEnd=postorderStart+leftNum;
        int rightPostOrderStart=leftPostOrderEnd;
        int rightPostOrderEnd=postorderEnd-1;

        root.left=makeTree(inorder,leftInorderStart,leftInorderEnd,postorder,leftPostOrderStart,leftPostOrderEnd);
        root.right=makeTree(inorder,rightInorderStart,rightInorderEnd,postorder,rightPostOrderStart,rightPostOrderEnd);

        return root;
    }
}

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if(s.equals(" ")){
            return false;
        }
        int len=s.length();
        s=" "+s;
        int[] next=new int[len+1];
        char[] ch=s.toCharArray();
        int j=0;
        for(int i=2;i<=len;i++){
            while(j>0&&ch[i]!=ch[j+1]){
                j=next[j];
            }
            if(ch[i]==ch[j+1]){
                j++;
            }
            next[i]=j;
        }
        if(next[len]>0&&len%(len-next[len])==0){
            return true;
        }
        return false;
    }
}

class Solution {
    public int strStr(String haystack, String needle) {
        int m=haystack.length();
        int n=needle.length();
        char[] h=haystack.toCharArray();
        char[] x=needle.toCharArray();
        for(int i=0;i<m-n+1;i++){
            int a=i,b=0;
            while(b<n&&h[a]==x[b]){
                a++;
                b++;
            }
            if(b==n){
                return i;
            }
        }
        return -1;
    }
}