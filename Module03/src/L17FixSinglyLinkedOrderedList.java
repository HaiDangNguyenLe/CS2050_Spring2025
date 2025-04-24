/**
 * 
 */

/**
 * 
 */
public class L17FixSinglyLinkedOrderedList
{

	// Test the Singly Linked List
	public static void main(String[] args)
	{
		SinglyLinkedListFix list = new SinglyLinkedListFix();
		list.insertNode(4);
		list.insertNode(2);
		list.insertNode(8);
		list.insertNode(3);

		list.printList();
		list.deleteNode(0);
		list.deleteNode(3);
		list.printList();
	}

}


class NodeFix {
    int data;
    NodeFix next;

    public NodeFix(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedListFix {
	NodeFix head;

    // BUGGY insertNode method
    public void insertNode(int number) {
    	NodeFix newNode = new NodeFix(number);
    	NodeFix current = head;
    	NodeFix previous = null;
    	
    	// update previous and current: this is right position to insert number
    	while (current != null &&          // run while loop for all node ( current != null, mean to the end)
    		   current.data < number) {    // increasing odder, so number must be < than current node data
    		//update previous and current : move to right 1 step
            previous = current;
            current = current.next; 
        }
        
        //if linked list empty, asign newNode is head
    	if (previous == null) { //chi co head
            newNode.next = head;
            head = newNode;
        
        //insert newNode to right position between previous and current
    	} else {
           //link newnode between previous and current
    		previous.next = newNode; //previous link to newNode
            newNode.next = current; //newNode link to current
        }
    }

    // BUGGY deleteNode method
    public void deleteNode(int number) {
    	NodeFix current = head;
    	NodeFix previous = null;
    	//move to the right ultil find out node.data = number (delete value)
        while (current != null && current.data != number) { // current = number to delete
            previous = current; 
            current = current.next;
        }
        //linked empty, nothing to delete
        if (current == null) {
			System.out.println("Node not found");
		}
        
        //delete node
        if(current != null) {          //linkedlist NOt empty
        	 if (previous == null) {   //mean current is head
                 head = current.next;  //delete current, head = current.next (value on rightside of current)
             } else {                  //current is a node on right of head
                 previous.next = current.next; // previous.next link to current.next, reject current node
             }
        }
       
    }

    public void printList() {
    	NodeFix current = head;
        while (current != null) {
            System.out.print(current.data + " → ");
            current = current.next;
        }
        System.out.println("null");
    }
}