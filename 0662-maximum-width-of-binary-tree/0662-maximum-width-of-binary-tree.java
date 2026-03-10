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
    class Pair 
    {
        TreeNode node;
        long idx;
        Pair(TreeNode n, long i) 
        {
            node = n;
            idx = i;
        }
    }

    public int widthOfBinaryTree(TreeNode root) 
    {
        if (root == null)
        {
            return 0;
        }
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        int maxWidth = 0;
        while (!q.isEmpty()) 
        {
            int size = q.size();
            long start = q.peek().idx;
            long end = start;
            for (int i = 0; i < size; i++) 
            {
                Pair p = q.poll();
                TreeNode node = p.node;
                long idx = p.idx;
                end = idx;
                if (node.left != null)
                {
                    q.offer(new Pair(node.left, 2 * idx));
                }
                if (node.right != null)
                {
                    q.offer(new Pair(node.right, 2 * idx + 1));
                }
            }
            maxWidth = Math.max(maxWidth, (int)(end - start + 1));
        }
        return maxWidth;
    }
}