/**
 * 
 */

/**
 * 
 */
public class L18DoubleLinkedListLab
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		DoublyLinkedListL18 list = new DoublyLinkedListL18();

		System.out.println("Inserting at the End:");
		list.insertAtEnd(10);
		list.insertAtEnd(20);
		list.insertAtEnd(30);
		list.printForward();
		list.printBackward();

		System.out.println("\nInserting at the Head:");
		list.insertAtHead(5);
		list.insertAtHead(1);
		list.printForward();
		list.printBackward();

		System.out.println("\nDeleting Node 20:");
		list.deleteNode(20);
		list.printForward();
		list.printBackward();

		System.out.println("\nReversing the List:");
		list.reverseList();
		list.printForward();
		list.printBackward();

	}

}

class NodeL18
{
	int data;
	NodeL18 next;
	NodeL18 prev;

	public NodeL18(int data)
	{
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}

class DoublyLinkedListL18
{
	NodeL18 head;

	// Insert at the end (already implemented)
	
	public void insertAtEnd(int data)
	{
		NodeL18 newNode = new NodeL18(data);
		//empty linkedlist, newnode is head
		if (head == null) 
		{
			head = newNode;
		//linkedlist has node(s)
		} else
		{
			NodeL18 temp = head;       //start from head
			while (temp.next != null)  //ultil tail : temp.next = null , temp is tail
			{
				temp = temp.next;		//move temp to the right 1 step
			}
			//When while stop, is at the end, then do:
			temp.next = newNode;	//Link temp (tail node) to the new node
			newNode.prev = temp;    //Backward link new node to temp 
		}
	}

	// Print the list forward
	public void printForward()
	{
		NodeL18 current = head;
		System.out.print("Forward: ");
		while (current != null)
		{
			System.out.print(current.data + " ⇄ ");
			current = current.next;
		}
		System.out.println("null");
	}

	// Students must complete this method
	
	public void insertAtHead(int data)
	{
		System.out.println("Implement Insert at the Head:" + data);
		NodeL18 newNode = new NodeL18(data);
		//empty linked list, new node is head
		if (head == null)
		{
			head = newNode;
		
		//linkedlist has node(s)
		} else {
			newNode.next = head; //Link newnode to head
			head.prev = newNode; //Backward link newnode to head
			head = newNode;		 //update now newnode is head

		}
	}

	// Students must complete this method
	public void deleteNode(int data)
	{
		System.out.println("Implement delete node:" + data);
		NodeL18 current = head;
		NodeL18 previous = null;
		boolean found = false;
		
		//find right node to delete
		while (current != null && !found){ //iterate through the linkedlist ultil on node match delete value
			
			if (current.data == data){
				found = true;
			} else{
				previous = current;
				current = current.next;
			}
		}
		
		//if found is true, delete node
		if (found){
			//found node (node to delete) is head
			if (previous == null){
				head = current.next;    //move head to the next node on the right
				if (head != null){		
					head.prev = null;	
				}
			//found node (node to delete) is not head
			} else{
				previous.next = current.next;	//skip current (node to delete), relink previous to next
				if (current.next != null){		   //if current is not a tail
					current.next.prev = previous;  //need backward link next to previous
				}
			}
		}
	}

	
		// Students must complete this method
		public void reverseList()
		{
			// Implement this
			System.out.println("Implement reverse list:");
			NodeL18 current = head;
			NodeL18 temp = null;
			while (current != null){
				temp = current.prev;
				current.prev = current.next;
				current.next = temp;
				current = current.prev; 
			}
			if (temp != null){
				head = temp.prev;

			}
		}//end reverseList


		// Print the list backward
		public void printBackward()
		{
			// Implement this
			System.out.println("Implement printbackward:");
			NodeL18 current = head;
			boolean hasElements = false;
			while (current != null && current.next != null){
				current = current.next;
				hasElements = true;
			}
			System.out.print("Backward: ");
			if (!hasElements){
				System.out.println("null");
			} else{
				while (current != null){
					System.out.print(current.data + " ⇄ ");
					current = current.prev;
				}
				System.out.println("null");
			}

		}
	}
