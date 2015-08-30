package datastructures;

public class CircularlyLinkedList {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();

		print("check head and tail");
		print(list.first() + " " + list.last());

		print("add 1,2,8 to tail");
		list.addLast(1).addLast(2).addLast(8);

		print(list);

		print("check head and tail");
		print(list.first() + " :: " + list.last());

		print("add 5 to first");
		list.addFirst(5);
		print(list);

		print("add 4 to tail");
		list.addLast(4);
		print(list);

		print("remove head");
		list.removeFirst();
		print(list);
		print("remove head 2 times");
		list.removeFirst();
		list.removeFirst();
		print(list);


	}
	public static void print(Object str) {
		System.out.println(str);
	}
}

/**
 * All operations of Circularly linked list happen in constant time
 * Removing from the tail (not implemented) cannot happen in constant
 */
class LinkedList<T> {
	private int size 		= 0;
	private Node<T> tail 	= null;

	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public Node<T> first() {
		return tail != null ? tail.getNext() : null;
	}
	public Node<T> last() {
		return tail != null ? tail : null;
	}

	public LinkedList<T> addFirst(T elem) {
		head = new Node<>(elem, head);
		if(isEmpty()) {
			tail = head;
		}
		size++;
		return this;
	}
	public LinkedList<T> addLast(T elem) {
		Node<T> newTail = new Node<T>(elem, null);
		if(isEmpty()) {
			head = newTail;
		} else {
			tail.setNext(newTail);
		}
		tail = newTail;
		size++;
		return this;
	}
	public Node<T> removeFirst() {
		if(isEmpty()) {
			return null;
		} else {
			Node<T> oldHead = head;
			head = head.getNext();
			size--;
			return oldHead;
		}
	}
	@Override
	public String toString() {
		Node<T> curNode = head;
		StringBuffer sb = new StringBuffer();
		while(curNode != null) {
			sb.append(curNode.getElement() + " -> ");
			curNode = curNode.getNext();
		}
		sb.append("@");
		return sb.toString();
	}

	private static class Node<T> {
		private T element;
		private Node<T> next = null;

		public Node() {
			this(null, null);
		}
		public Node(T e, Node<T> n) {
			element = e;
			next 	= n;
		}

		public T getElement() { 
			return element;  
		}
		public Node<T> getNext() { 
			return next;  
		}
		public void setNext(Node<T> n) { 
			next = n; 
		}

		@Override
		public String toString() {
			return "(" +element+ ")" + " -> " + (next == null ? "@" : "{}");
		}
	}
}

