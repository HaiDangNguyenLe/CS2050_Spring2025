
public class MySubClass extends Draft1{
	
	void message() 
    { 
        System.out.println("This is sub class"); 
    } 
	
	void display() 
    { 
        // will invoke or call current 
        // class message() method 
        message(); 
  
        // will invoke or call parent 
        // class message() method 
        //super.message(); 
    } 

}
