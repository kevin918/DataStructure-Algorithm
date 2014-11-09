import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Stack;

class BinaryTree{
	public static void main(String[] args) {	
		TreeNode root = new TreeNode(5);
		root.val = 5;
		root.left.val = 3;
		root.right.val = 10;
		root.left.left.val = 20;
		root.left.right.val=21;
		root.right.left.val=1;
		System.out.println(countVisible(root)); 
	}
	
	// Validate a binary search tree
	public boolean BST(TreeNode root){
		return validateBST(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	public boolean validateBST(TreeNode root, int min, int max){
		if (root==null) {
			return true;
		}
		if (root.val<=min||root.val>=max) return false;
		return validateBST(root.right,root.val,max) && validateBST(root.left,min,root.val);
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
	
	//Preorder, applying the Depth First Search
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
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
	
	//Inorder
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
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
	
	//print visible nodes of binary tree
	public static int countVisible(TreeNode root) {
		ArrayList<Integer> pre = new ArrayList<Integer>();
		if(root == null) return 0;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		int count=1;
		stack.push(root);
		while(!stack.empty()){
			TreeNode current = stack.pop();
			pre.add(current.val);
			
			int maxSofar = current.val;
			if (current.left!=null) {
				if (current.left.val>=current.val) {
					stack.push(current.left);
					maxSofar = current.left.val;
					count++;
				}
				current = current.left;
			}
			
			if (current.right!=null) {
				if (current.right.val>= current.val) {
					stack.push(current.right);
					maxSofar = current.right.val;
					count++;
				}
				current = current.right;
			}
			
		}
		return count;
	}

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
	//4.2 given a directed graph, desiagn an algorithm to find out whether there is a route between two nodes.
	public enum state{
		unvisited,visited,visiting;
	}
	public static boolean search(Graph g, Node start, Node end){
		LinkedList<Node> q = new LinkedList<Node>();
		for (Node u:g.getNodes()) {
			u.state = state.unvisited;
		}
		start.state = visiting;
		q.add(start);
		Node u;
		while (!q.isEmpty()) {
			u = q.removeFirst();
			if (u!=null) {
				for (expressions) {
					
				}
			}
		}
	}
	
	//4.3 given a sorted array with unique integer elements, create a binary search tree with minimal height.
    TreeNode createMinimalBST(int arr[], int start, int end){
		if (start>end) {
			return null;
		}
		int mid = (start+end)/2;
		TreeNode n = new TreeNode(arr[mid]);
		n.left = creatMinimalBST(arr,start,mid-1);
		n.right = createMinimalBST(arr,mid+1,end);
		return n;	
	}
	TreeNode createMinimalBST(int array[]){
		return createMinimalBST(array,0,array.length-1);
	}
}

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val=x;
	}
}