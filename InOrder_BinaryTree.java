class inOrder{
	public static void main(String[] args){
	
	}
	public static ArrayList<Integer> inorderTraversal(TreeNode root) {
	        ArrayList<Integer> result = new ArrayList<Integer>();
	        if(root == null) return result;
	        Stack<TreeNode> stack = new Stack<TreeNode>();
	        TreeNode p = root;
	        while(!stack.empty()||p!=null){//watch out!
	            if(p!=null){
	                stack.push(p);//push root
	                p=p.left;
	            }else{//the left is over.
	                TreeNode n = stack.pop();//pop the most left node
	                result.add(n.val);
	                p=n.right;
	            }
	        }
	        return result;
	}
}