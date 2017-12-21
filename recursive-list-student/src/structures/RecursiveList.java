package structures;

import java.util.Iterator;

public class RecursiveList<T> implements ListInterface<T> {
	int size;
	Node<T> head;
	Node<T> tail;


	public RecursiveList(){
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}
	

	@Override
	public ListInterface<T> insertFirst(T elem){		
	if(elem == null){
		throw new NullPointerException();
	}
		Node<T> nn = new Node<T>((T) elem);
		
		if(this.isEmpty()){
			head = nn;
			tail = head;
		}
		
		else {
			nn.next = head;
			head = nn;
		}
		
		size++;
		return this;
	
	}

	@Override
	public ListInterface<T> insertLast(T elem) {
		if(elem == null){
			throw new NullPointerException();
		}
		size++;
		Node<T> nn = new Node<T>(elem);
		if(isEmpty()){
			head = nn;
			tail = nn;
		}
		tail.next = nn;
		tail = nn;
		return this;
	}

	@Override
	public ListInterface<T> insertAt(int index, T elem) {
		if(elem == null){
			throw new NullPointerException();
		}
	
		if((index > this.size) || (index < 0)){
			throw new IndexOutOfBoundsException();
		}
		
		if(index == 0){
			return insertFirst(elem);
			
		}
	
		size++;
		inserthelper(index, elem, head);
		return this;
	}
	
	private void inserthelper(int index, T elem, Node<T> temp){
		if(index == 1){
			Node<T> nn = new Node<T>(elem);
			nn.next = temp.next;
			temp.next = nn;
			
			return;
		}
		
		if(temp.next != null){
		temp = temp.next;
		index --;
		inserthelper(index, elem, temp);
		}
		
		return;
	}

	@Override
	public T removeFirst() {
		if(isEmpty()){
			throw new IllegalStateException();
		}
		else{
		Node<T> temp = head;
		head = head.next;
		size--;
		return temp.data;
		}
	}

	@Override
	public T removeLast() {
	if(isEmpty()){
		throw new IllegalStateException();
	}
	
	return removeAt(this.size - 1);
	
	}

	@Override
	public T removeAt(int i) {
		if((i > size) || (i < 0) || (head == null)){
			throw new IndexOutOfBoundsException();
		}
		 
		
		 size--;
		 return removehelper(head, i);
	}
	
	private T removehelper(Node<T> node, int index){
		Node<T> temp = node.next;

		
		if(index == 0){
			this.removeFirst();
			size++;
			return node.data;
		}
		
		else if(index == 1){
			node.next = node.next.next;
			return temp.data;
		}
		
		index --;
		node = node.next;
		return removehelper(node, index);
	}

	@Override
	public T getFirst() {
		if(this.isEmpty()){
			throw new IllegalStateException();
		}
		return head.data;
	}

	@Override
	public T getLast() {
		if(this.isEmpty()){
			throw new IllegalStateException();
		}
		return get(size - 1);
	}

	@Override
	public T get(int i) {

		if((i >= this.size) || (i < 0) || head == null){
			throw new IndexOutOfBoundsException();
		}
		
		return gethelper(i, head);
				
		
	}
	
	private T gethelper(int i, Node<T> temp){
		if(i == 0){
			return temp.data;
		}
		
		i--;
		temp = temp.next;
		
		return gethelper(i, temp);
		
	}
	
	@Override
	public boolean remove(T elem){
		int index = indexOf(elem);
		if(elem == null){
			throw new NullPointerException();
		}
		
		if(index == -1){
			return false;
		}
	
		removeAt(index);
		return true;

	}
	
	@Override
	public int indexOf(T elem) {
		if(elem == null){
			throw new NullPointerException();
		}
		
		return indexhelper(head, elem, 0);
	}
	
	private int indexhelper(Node<T> node, T elem, int index){
		if(index == size){
			return -1;
		}
		
		if(node.data == elem){
			 return index;
		}
		
		index++;
		node = node.next;
		return indexhelper(node, elem, index);
	}

	@Override
	public boolean isEmpty() {
		if(head == null){
			return true;
		}
		return false;
	}

	  class Node<T> {
			public T data;
			public Node<T> next;
			public Node(T data) { this.data=data;}
			public Node(T data, Node<T> next) {
				this.data = data; this.next=next;
			}
				
	  }

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}


	  
	  
}
