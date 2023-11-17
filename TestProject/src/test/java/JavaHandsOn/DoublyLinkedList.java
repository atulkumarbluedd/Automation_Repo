package JavaHandsOn;

public class DoublyLinkedList {
 

	class Node {
		int data;
		Node previous;
		Node next;

		public Node(int data) {
			this.data = data;
		}

	}

	Node head, tail;

	public void addNode(int data) {
		Node newNode = new Node(data);
		/*if list is empty*/
		if (head == null) {
			/* both head and tail will point to newNode */
			head = tail = newNode;
			/* head's previous will point to null */
//			head.previous = null;
//			/* tail's next will point to null as it is last node in the ll */
//			tail.next = null;
		} else {
			/*newNode will be added after tail such that tail's next will point to newNode*/
			tail.next = newNode;
			/* newNode's previous will point to tail */
			newNode.previous = tail;
			/* newNode will become new tail */
			tail = newNode;
			/* as it is last node so tail's next will point to null */
			tail.next = null;

		}
	}
	/**
	 * This method is used to insert node 
	 * in the beginning of the existing
	 * linkedlist
	 * @param data
	 */
	public void addNodeFirst(int data) {
		Node node = new Node(data);
		 node.next=head;
	        head.previous=node;
	        head=node;
	}
	/**
	 * This method is used to insert node 
	 * at the end of the existing
	 * linkedlist
	 * @param data
	 */
	public void addNodeLast(int data) {
		Node node= new Node(data);
		 Node temp=head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		node.previous=temp;
		temp.next=node;
		tail=node;
	}
	/**
	 * add node at specific place in b/w linkedlist
	 * @param data
	 */
	public void addNodeBetween(int v, int nodeTobeAdded) {
		Node curr=head;
		Node newNode=new Node(nodeTobeAdded);
		while(curr.data!=v) {
			curr=curr.next;
		}
		newNode.next=curr.next;
		newNode.previous=curr;
		newNode.next.previous=newNode;
		curr.next=newNode;
		
	}

	public void display() {
		Node current = head;
		if (head == null)
			return;
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}
	public static void main(String[] args) {  
		  
        DoublyLinkedList dList = new DoublyLinkedList();  
        //Add nodes to the list  
        dList.addNode(1);  
        dList.addNode(2);  
        dList.addNode(3);  
        dList.addNode(4);  
        dList.addNode(5);  
        dList.addNodeFirst(32);
        dList.addNodeLast(323);
        dList.addNodeFirst(30);
        dList.addNodeLast(100);
        dList.addNodeBetween(32,45);
        //Displays the nodes present in the list  
        dList.display();  
    }  

}
