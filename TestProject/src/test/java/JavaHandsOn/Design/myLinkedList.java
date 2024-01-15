package JavaHandsOn.Design;

import io.cucumber.java.mk_latn.No;

public class myLinkedList {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public myLinkedList insert_last(myLinkedList list, int data) {

        Node new_node = new Node(data);
        /** if list is empty then make new_node as head*/
        if (list.head == null)
            list.head = new_node;

        else {
            Node last = list.head;
            while (last.next != null)
                last = last.next;
            /** as we reached last we will put this node**/
            last.next = new_node;
        }
        return list;

    }

    void printNthNodeFromLast(int n, myLinkedList list) {
        int len = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        if (len < n) return;

        temp = head;
        for (int i = 1; i < len - n + 1; i++) {
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    void addNodefront(myLinkedList list, int data) {
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
    }

    public void printlist(myLinkedList list) {
        Node curr = list.head;
        while (curr != null) {

            System.out.println(curr.data);
            curr = curr.next;
        }

    }

    public static void main(String[] args) {
//        myLinkedList ll= new myLinkedList();
//        for (int i=0;i<10;i++)
//         ll.insert_last(ll,i*2);
//         ll.printlist(ll);

    }
}
