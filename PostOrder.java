class PostOrder{
	public static void main(String[] args){
	
	}
	
	//Print the binary tree in post order
	public ArrayList<Integer> postorder(TreeNode root){
		ArrayList<Integer> post = new ArrayList<Integer>();
		if (root == null) {
			return null;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode previous = null;
		while (!stack.empty()) {
			TreeNode n = stack.peek();
			if(previous==null||previous.left==n||previous.right==n){
				if (n.left!=null) {
					stack.push(n.left);
				} else if (n.right!=null) {
					stack.push(n.right);
				} else {
					post.add(stack.pop().val);
				}
			} else if (n.left == previous) {
				if(n.right!=null) stack.push(n.right);
				else stack.pop(); post.add(n.val);
				
			} else if (n.right==previous) {
				stack.pop();
				post.add(n.val);
			}
			previous = n;
		}
		return post;
	}
}