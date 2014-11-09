class levelOrder{
	public static void main(String[] args){
	
	}

	//level order, applying the Breadth first search
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root){
		ArrayList<ArrayList<Integer>> level = new ArrayList<ArrayList<Integer>>();
	    ArrayList<Integer> list = new ArrayList<Integer>();
	    if(root == null) return level;
	     
	    LinkedList<TreeNode> parent = new LinkedList<TreeNode>();
	    LinkedList<TreeNode> children = new LinkedList<TreeNode>();
	        
		parent.add(root);
	    while(!parent.isEmpty()){
	    	TreeNode node = parent.remove();
	        if(node.left != null)
	            children.add(node.left);
	        if(node.right != null)
	            children.add(node.right);//store the two children
	        list.add(node.val);//parents add to the list
	        if(parent.isEmpty()){
	            parent = children;
	            children = new LinkedList();
	            level.add(list);
	            list = new ArrayList();
	        }
	    }
	    return level;
	}
}