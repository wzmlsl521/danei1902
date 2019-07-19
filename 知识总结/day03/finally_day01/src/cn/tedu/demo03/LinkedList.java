package cn.tedu.demo03;

public class LinkedList<E> {
	private Node head;
	private int size = 0;
	private class Node{
		E data;
		Node next;
		Node prev;
		Node(E e){
			data = e;
		}
	}
	public int size() {
		return size;
	}
	public String toString() {
		//[��ͷǿ, Tom, Jerry] 
		if(head==null) {
			return "[]";
		}
		StringBuilder buf = new StringBuilder("[");
		buf.append(head.data);
		Node node = head.next;
		while(node!=head) {
			buf.append(", ").append(node.data);
			node = node.next;
		}
		buf.append("]");
		return buf.toString();
	}
	public E remove(int index) {
		if(index<0||index>=size) {
			throw new IndexOutOfBoundsException("Խ��"+index);
		}
		if(size==1) {
			E e = head.data;
			head = null;
			size--;
			return e;
		}
		Node node = find(index);
		Node prev = node.prev;
		Node next = node.next;
		prev.next = next;
		next.prev = prev;
		node.next = null;
		node.prev = null;
		if(index==0) {
			head = next;
		}
		size--;
		return node.data;
	}
	public boolean add(int index, E e) {
		if(index<0 || index>size) {
			throw new IndexOutOfBoundsException("Խ��");
		}
		if(index==size) return add(e); 
		Node next = find(index);
		Node prev = next.prev;
		Node node = new Node(e);
		prev.next = node;
		node.next = next;
		next.prev = node;
		node.prev = prev;
		if(index==0) {
			head = node;
		}
		size++;
		return true;
	}
	
	public E get(int index) {
		Node node;
		node = find(index);
		return node.data;
	}

	private Node find(int index) {
		Node node;
		if(index<size>>1) {
			node = head;
			for(int i=0; i<index; i++) {
				node=node.next;
			}
		} else {
			node = head.prev;
			for(int i=size-1; i>index;i--) {
				node = node.prev;
			}
		}
		return node;
	}
	
	/**
	 * �򼯺���ӣ�׷�ӣ�Ԫ��
	 * @param e ����ӵ�Ԫ��
	 * @return ��ӳɹ����� true
	 */
	public boolean add(E e) {
		if(head==null) {
			head = new Node(e); 
			//ʵ��ѭ����ϵ
			head.next = head;
			head.prev = head;
		}else{
			Node node = new Node(e);
			Node last = head.prev;
			head.prev = node;
			node.prev = last;
			last.next = node;
			node.next = head;
		}
		size++;
		return true;
	}
}






