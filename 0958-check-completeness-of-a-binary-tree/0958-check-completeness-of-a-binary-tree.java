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

class Solution 
{
    public boolean isCompleteTree(TreeNode root) 
    {
        java.util.Queue<TreeNode> q = new java.util.LinkedList<>();
        q.offer(root);
        boolean nullSeen = false;
        while (!q.isEmpty()) 
        {
            TreeNode cur = q.poll();
            if (cur == null) 
            {
                nullSeen = true;
            }
            else 
            {
                if (nullSeen)
                {
                    return false;
                }
                q.offer(cur.left);
                q.offer(cur.right);
            }
        }
        return true;
    }
}