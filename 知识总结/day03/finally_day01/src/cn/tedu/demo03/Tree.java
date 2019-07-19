package cn.tedu.demo03;

public class Tree<E extends Comparable<E>> {
	private Node root;
	private int size;
	private class Node{
		E data;
		Node left;
		Node right;
		Node(E e){
			data=e;
		}
		public boolean addChild(E e) {
			//�ȱȽϴ�С
			//����
			//С��
			//����
			int val = data.compareTo(e);
			if(val==0) { //��Ȳ����Ԫ��
				return false;
			} else if(val>0) { //�������
				if(left==null) {
					left = new Node(e);
					size++;
					return true;
				} else {
					//������ڲ��ݹ����Ԫ��
					return left.addChild(e);
				}
			} else { //�������
				if(right==null) {
					right = new Node(e);
					size++;
					return true;
				} else {
					return right.addChild(e);
				}
			}
		}
		
		public void appendTo(StringBuilder buf) {
			//��������� ���У���
			if(left!=null) {
				left.appendTo(buf); 
			}
			buf.append(data).append(", ");
			if(right!=null) {
				right.appendTo(buf); 
			}
		}
		
	}
	public boolean add(E e) {
		if(root==null) {
			root = new Node(e);
			size++;
			return true;
		} else {
			return root.addChild(e); 
		}
	}
	
	public String toString() {
		if(root==null) {
			return "[]";
		}
		StringBuilder buf = new StringBuilder("[");
		root.appendTo(buf);
		buf.delete(buf.lastIndexOf(","), buf.length());
		return buf.append("]").toString();
	}
}












