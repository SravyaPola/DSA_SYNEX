package linkedlist;

public class ModifiedInsertAndDelete {
    private ListNode head;

    public ModifiedInsertAndDelete() {
        this.head = null;
    }

    public void insertEnd(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode curr = head;
        while (curr.getNext() != null) {
            curr = curr.getNext();
        }
        curr.setNext(newNode);
    }

    public void deleteByValue(int key) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.getData() == key) {
            head = head.getNext();
            return;
        }
        ListNode prev = head;
        ListNode curr = head.getNext();
        while (curr != null && curr.getData() != key) {
            prev = curr;
            curr = curr.getNext();
        }
        if (curr == null) {
            System.out.println("Value " + key + " not found in list.");
            return;
        }
        prev.setNext(curr.getNext());
    }

    public void printList() {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.getData() + " -> ");
            curr = curr.getNext();
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        ModifiedInsertAndDelete list = new ModifiedInsertAndDelete();
        list.insertEnd(10);
        list.insertEnd(20);
        list.insertEnd(30);    
        list.printList();
        list.insertEnd(40);      
        list.printList();
        list.deleteByValue(20);
        list.printList();
        list.deleteByValue(10);
        list.printList();
        list.deleteByValue(99);
    }
}
