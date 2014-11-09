class Balanced{
	
	//4.1 check if a binary tree is balanced!!!definition is for each node, the two subtrees differ in height by no more than one!!
	
	public static int getHeight() {
		if (root == null) {
			return 0;//base case
		}
		return Math.max(getHeight(root.left),getHeight(root.right))+1;//recurse!!!
	}
	public boolean isBalanced(TreeNode root){
		if (root==null) {
			return true;//base case!
		}
		int heightdiff = getHeight(root.left) - getHeight(root.right);
		if(Math.abs(heightdiff)>1){
			return false;
		}else {
			return isBalanced(root.left) && isBalanced(root.right);
		}
	}
}