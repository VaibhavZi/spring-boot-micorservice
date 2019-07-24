package com.vz.programs;

public class LinkedListImpl {
	static LinkedListImpl linkedList;
	Node head;

	public static void main(String[] args) {
		LinkedListImpl  impl = new LinkedListImpl();
		impl = impl.insert(impl, 1);
		impl = impl.insert(impl, 2);
		impl = impl.insert(impl, 4);
		impl = impl.insert(impl, 5);
		printList(impl);
		
	}

	private static LinkedListImpl insert(LinkedListImpl node, int data) {

		Node new_node = new Node(data);
		new_node.next=null;
		
		if (linkedList == null) {
			linkedList = new LinkedListImpl();
		}
			if(linkedList.head==null) {
				linkedList.head=new_node;
			}else {
				Node last = linkedList.head;
				while(last.next!=null) {
					last=last.next;
				}
				last.next=new_node;

			}
		return linkedList;
	}
	static class Node {
		private Node next;
		private int data;

		public Node(int data) {
			this.data = data;
			next=null;
		}
	}

	static void printList(LinkedListImpl impl) {
		Node node = impl.head;
		while(node.next!=null) {
			System.out.println(node.data);
			node= node.next;
		}
	}
}

