class preOrder{
	public static void main(String[] args){
	
	}
	//Preorder, applying the Depth First Search
	public static ArrayList<Integer> preorderTraversal(TreeNode root) {
	        ArrayList<Integer> pre = new ArrayList<Integer>();
	        if(root==null) return pre;//return pre, not null!!!
	        Stack<TreeNode> stack = new Stack<TreeNode>();
	        stack.push(root);
	        while(!stack.empty()){
	            TreeNode current = stack.pop();
	            pre.add(current.val);
	            if(current.right!=null){
	                stack.push(current.right);
	            } 
	            if(current.left!=null){
	                stack.push(current.left);
	            }
	        }
	        return pre;
	}
}