package JavaHandsOn;

public class DoublyLinkedList {
	int data;

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
			head.previous = null;
			/* tail's next will point to null as it is last node in the ll */
			tail.next = null;
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

	public void display() {
		Node current = head;
		if (head == null)
			return;
		while (current != null) {
			System.out.print(current.data);
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
  
        //Displays the nodes present in the list  
        dList.display();  

	}
}
