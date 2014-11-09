import java.util.Stack;
import java.util.LinkedList;
class Untitled {
	public static void main(String[] args) {
		
	}
	//2.1 remove duplicates
	public static void deletedups(LinkedListNode n){
		Hashtable table = new Hashtable();
		LinkedListNode previous =null;
		while (n!=null) {
			if (table.containsKey(n.data)) {
				previous.next = n.next;
			} else {
				table.put(n.data,true);
				previous = n;
			}
			n = n.next;
		}
	}// O(n) time complexity, but use extra space/buffer for hashtable
	
	//2.2 find the kth to last element of a singly linked list
	//2.3 delete a node in the middle of a singly linked list
	//2.6 circular linked list, return the node at the beginning of the loop
	LinkedListNode FindBeginning(LinkedListNode head){
		LinkedListNode slow = head;
		LinkedListNode fast = head;
		while (fast!=null && fast.next !=null) {
			slow = slow.next;
			fast = fast.next;
			if (slow == fast) {
				break;//collision
			}
		}
		if (fast == null || fast.next ==null) {
			return null;//error check, no meeting point, and therefore no loop
		}
		slow = head;//reset slow back to the head
		while (slow!=fast) {
			slow = slow.next;
			fast = fast.next;
		}//move them two same steps, then we'll got the starting point of the circular loop!!!
		return fast;
	}
	
	//2.7 palindrome linked list
	public boolean palindromeIterate(LinkedListNode n) {
		LinkedListNode fast = head;
		LinkedListNode slow = head;
		Stack<Integer> stack = new Stack<Integer>();
		while (fast!=null&&fast.next!=null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next;
		}//find the middle one push to a stack
		
		if(fast!=null){
			slow = slow.next;
		}// odd elements check!!!
		
		while (slow != null) {//compare the rest element with the stack ones!!!
			int top = stack.pop().intValue();
			if (top != slow.data) {
				return false;
			}
			slow = slow.next;
		}
		return true;
	}
	
	public boolean palindromeRecursive(LinkedList n){
		
	}
}