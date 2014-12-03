import java.util.*;

public class solution{
	
	//recursion method
	public boolean hasPathSum(TreeNode root, int sum){
		if(root==null) return false;
		if(root.val==sum && root.left==null && root.right==null)
			return true;
		return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
	}

	//iteration method
	public boolean hasPathSum2(TreeNode root, int sum){
		if(root==null) return false;
		LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
		LinkedList<Integer> sumer = new LinkedList<Integer>();
		nodes.add(root);
		sumer.add(root.val);
		while(!nodes.isEmpty()){
			TreeNode current = nodes.remove();
			int count = sumer.remove();
			if(current.left==null && current.right==null && count == sum){
				return true;
			}
			if(current.left != null){
				nodes.add(current.left);
				sumer.add(count+current.left.val);
			}
			if(current.right != null){
				nodes.add(current.right);
				summer.add(current.right.val+count);
			}
		}
		return false;
	}

}