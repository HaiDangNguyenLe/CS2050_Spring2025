import java.util.*;

/**
 * 
 */
public class L19CollectionSortBooksLinkedList
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		Scanner keyboard = new Scanner(System.in) ;
		
		// Step 1: Create a LinkedList (dynamic)
		LinkedList<Book> bookInventory = new LinkedList<>();

		bookInventory.add(new Book("Unmasking AI", "Dr. Joy Buolamwini", 2023));
		bookInventory.add(new Book("Hello World", "Hannah Fry", 2018));
		bookInventory.add(new Book("The Mathematics of Love", "Hannah Fry", 2015));
		bookInventory.add(new Book("Weapons of Math Destruction", "Cathy O’Neil", 2016));
		bookInventory.add(new Book("Race After Technology", "Ruha Benjamin", 2019));

		System.out.println("Original LinkedList of books:");
		for (Book currentBook : bookInventory)
		{
			System.out.println(currentBook);
		}

		System.out.println();

		// Step 2: ***Convert to ArrayList for sorting
		
		List<Book> books = new ArrayList<>(bookInventory);

		// Step 3: Sort by Title
		System.out.println("3. Books sorted by title:");
		
		books.sort(Comparator.comparing(Book::getTitle));
		
		for (Book currentBook : books) //working through each book
		{
			System.out.println(currentBook);
		}

		System.out.println();

		// Step 4: Sort by year (newest to oldest)
		
		System.out.println("4. Books sorted by Year:");
		
		books.sort(Comparator.comparing(Book::getYear).reversed());
		
		for (Book currentBook : books) //working through each book
		{
			System.out.println(currentBook);
		}

		System.out.println();
		
		// Step 5: Sort by author then title
		
		System.out.println("5. Books sorted by Author then Title:");
		
		books.sort(Comparator.comparing(Book::getAuthor).thenComparing(Book::getTitle));
		
		for (Book currentBook : books) //working through each book
		{
			System.out.println(currentBook);
		}

		
		// Step 6: ***Add Queue for signing out books
		Queue<Book> signOutQueue = new LinkedList<>();

		// Simulate students requesting to sign out books
		signOutQueue.add(bookInventory.get(0)); // Unmasking AI
		signOutQueue.add(bookInventory.get(2)); // Weapons of Math Destruction

		System.out.println(); 
		System.out.println("6. Sign-out queue:");

		//show signOutQueue list
		System.out.println("Sign-out queue:");
		for (Book currentBook : signOutQueue) {
			System.out.println(currentBook);
		}

		System.out.println();

		// Step 7: Process the sign-out queue (using while loop remove books from signOutQueue, Queue = FIFO)
		System.out.println("7. Processing sign-outs:");
		// add code
		while (!signOutQueue.isEmpty()) {
			Book signedOut = signOutQueue.remove();//retrieves and removes the head
			//print signed out book
			System.out.println("Signed-out: " + signedOut );

		}

		//Step 8: Search by author
		System.out.println("8. Searching for books by Hannah Fry:");
		List<Book> searchBooksResult = findBooksByAuthor(bookInventory, "Hannah Fry");
		printBooks(searchBooksResult, "Hannah Fry", -1);

		//Step 9: search books by author and year
		System.out.println("9. search books by author and year: ");
		List<Book> foundBooks = findBooks(bookInventory, "Hannah Fry", 2018);
		printBooks(foundBooks, "Hannah Fry", 2018);
		
		// Step 10: Use HashMap to organize books by title
		System.out.println("\nStep 10 HashMap of books by title:");
	    
		Map<String, Book> bookMapByTitle = new HashMap<>();
	    
	    //Using for loop to create hashmap quickly for book titles
	    //Remember title must be unique
	    for (Book book : bookInventory) {
	    	
	    	//Add the book to the hashmap bookMapByTitle
	    	bookMapByTitle.put(book.getTitle(), book);  // key = title, value = book
	    }
	   	    
	   //Then update the code to 
	  		//Allow  the user to enter a book title , author and year.
	  		System.out.print("enter a book Title: ");
	  		String bookTitle = keyboard.nextLine();
	  		System.out.print("\nenter a book Author: ");
	  		String author = keyboard.nextLine();
	  		System.out.print("\nenter year: ");
	  		int year = keyboard.nextInt();
	  		keyboard.nextLine();
	  		
	  		//Add the book to the bookInventory linked list
	  		Book newBook = new Book (bookTitle, author, year) ;
	  		
	  		//Add the book to the hashmap bookMapByTitle
	  		bookMapByTitle.put(bookTitle, newBook);
	  		
	  		//Add code to allow the user to enter the title to search the book inventory
	  		System.out.println("enter a book title to search");
	  		String searchBookTitle = keyboard.nextLine();
	  		 
	  		//containsKey Returns true if the key exists
		    if (bookMapByTitle.containsKey(searchBookTitle)) {
		       
		    	System.out.println("Found book: " + bookMapByTitle.get(searchBookTitle));
		    	
		    } else {
		        System.out.println("Book not found: " + searchBookTitle);
		    }
		    
	
	}//END MAIN
	
	
	//METHODS:
	
	public static List<Book> findBooksByAuthor(List<Book> inventory, String author) {
		List<Book> results = new ArrayList<>();
		for (Book currentBook : inventory) {
			if (currentBook.getAuthor().equalsIgnoreCase(author)) {
				results.add(currentBook);
			}
		}
		return results;
	}

	//method to search books by author and year and return books that match sorted by title.
	public static List<Book> findBooks(List<Book> inventory, String author, int year) {
		List<Book> results = new ArrayList<>();
		for(Book currentBook : inventory) {
			if (currentBook.getAuthor().equalsIgnoreCase(author)&&currentBook.getYear()==year) {
				results.add(currentBook);
			}
		}
		return results;
	}//end find books
	
		
	public static void printBooks(List<Book> books, String author, int year) {
		String label;
		if (year != -1) {
			label = " in " + year;
		} else {
			label = "";
		}

		if (books.isEmpty()) {
			System.out.println("\nNo books found by " + author + label + ".");
		} else {
			System.out.println("\nBooks by " + author + label + ":");
			for (Book currentBook : books) {
				System.out.println(currentBook);
			}
		}
	}




}

class Book
{
	private String title;
	private String author;
	private int year;

	public Book(String title, String author, int year)
	{
		this.title = title;
		this.author = author;
		this.year = year;
	}

	public String getTitle()
	{
		return title;
	}

	public String getAuthor()
	{
		return author;
	}

	public int getYear()
	{
		return year;
	}

	@Override
	public String toString()
	{
		return title + " by " + author + " (" + year + ")";
	}
}
