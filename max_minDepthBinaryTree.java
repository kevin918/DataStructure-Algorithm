class depth{

	public int minDepth(TreeNode root) {
        if(root==null) return 0;//
        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        LinkedList<Integer> count = new LinkedList<Integer>();
        nodes.add(root);
        count.add(1);
        while(!nodes.isEmpty()){
            TreeNode cur = nodes.remove();
            int h = count.remove();
            if(cur.left==null&&cur.right==null){
                return h;
            }
            if(cur.left!=null){
                nodes.add(cur.left);
                count.add(h+1);
            }
            if(cur.right!=null){
                nodes.add(cur.right);
                count.add(h+1);
            }
        }
        return 0;
    }

    //level order transformer
    public int maxDepth(TreeNode root) {
        ArrayList<ArrayList<Integer>> level = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root == null) return 0;
        LinkedList<TreeNode> children = new LinkedList<TreeNode>();
        LinkedList<TreeNode> parent = new LinkedList<TreeNode>();
        parent.add(root);
        while(!parent.isEmpty()){
            TreeNode current = parent.remove();
            if(current.left!=null) children.add(current.left);
            if(current.right!=null) children.add(current.right);
            list.add(current.val);
            if(parent.isEmpty()){
                parent = children;
                children = new LinkedList<TreeNode>();
                level.add(list);
                list = new ArrayList<Integer>();
            }
        }
        return level.size();
    }
}