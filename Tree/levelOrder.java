package Tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> result=new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        seQueue(root);
        return result;
    }

    public void seQueue(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null){
            return;
        }
        queue.add(root);
        int size=queue.size();
        List<Integer> arr=new ArrayList<>();

        while(size-->0){
            TreeNode node=queue.poll();
            arr.add(node.val);
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
            result.add(arr);
        }
    }
}