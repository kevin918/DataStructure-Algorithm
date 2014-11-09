import java.util.Stack;
class Untitled {
	public static void main(String[] args) {
		
	}
	//3.5 use two stack implement queue!!!
	Stack<T> incoming, outgoing;
	public void add(T value){
		incoming.push(value);
	} 
	public void move(){//watch out the conditions!!!
		if (outgoing.isEmpty()) {
			while (!incoming.isEmpty) {
				outgoing.push(incoming.pop());
			}
		}
	}
	public T peek(){
		move();//ensure the outgoing has the current elements!!!
		return outgoing.peek();
	}
	public T remove(){
		move();
		return outgoing.pop();
	}
	//3.6 sort a stack in ascending order(with biggest items on top) use additional stack.
	public static Stack<Integer> sort(Stack<Integer> s){
		Stack<Integer> r = new Stack<Integer>();
		while (!s.isEmpty()) {
			int temp = s.pop();
			while (!r.isEmpty()&&temp<r.peek()) {
				s.push(r.pop());
			}
			r.push(temp);
		}
		return r;
	}//n^2 time and n space
}