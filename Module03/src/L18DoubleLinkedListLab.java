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
		if (head == null)
		{
			head = newNode;
		} else
		{
			NodeL18 temp = head;
			while (temp.next != null)
			{
				temp = temp.next;
			}
			temp.next = newNode;
			newNode.prev = temp; // Backward link
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
		
		if (head == null)
		{
			head = newNode;
		} else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;

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
		while (current != null && !found){
			if (current.data == data){
				found = true;
			} else{
				previous = current;
				current = current.next;
			}
		}
		////delete node
		if (found){
			if (previous == null){
				head = current.next;
				if (head != null){
					head.prev = null;
				}
			} else{
				previous.next = current.next;
				if (current.next != null){
					current.next.prev = previous;
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
