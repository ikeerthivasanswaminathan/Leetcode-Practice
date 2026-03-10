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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) 
    {
        solve(root);
        return maxSum;
    }
    private int solve(TreeNode node) 
    {
        if (node == null)
        {
            return 0;
        }
        int left = Math.max(0, solve(node.left));
        int right = Math.max(0, solve(node.right));
        maxSum = Math.max(maxSum, node.val + left + right);
        return node.val + Math.max(left, right);
    }
}