
public class HaiDangLeTestSimpleRectangle {

	public static void main(String[] args) {
		//a.Create rectangle1 with SimpleRectangle() constructor
		SimpleRectangle rectangle1 = new SimpleRectangle();
		//b.Create rectangle 2 and 3 with the SimpleRectangle(newLength: double, newWidth:double) constructor 
		SimpleRectangle rectangle2 = new SimpleRectangle(4,2);
		SimpleRectangle rectangle3 = new SimpleRectangle(2,1);
		//call the methods for each rectangle to print the area and perimeter for each of the 3 rectangles. 
		System.out.println("Area of rectangle 1 is " + rectangle1.getArea() + ". Perimeter of rectangle 1 is " + rectangle1.getPerimeter());
		System.out.println("Area of rectangle 2 is " + rectangle2.getArea() + ". Perimeter of rectangle 2 is " + rectangle2.getPerimeter());
		System.out.println("Area of rectangle 3 is " + rectangle3.getArea() + ". Perimeter of rectangle 3 is " + rectangle3.getPerimeter());
	
	}//end main

}//end HaiDangLeTestSimpleRectangle

class SimpleRectangle{
	private double length;
	private double width;
	
	//constructor rectangle with default size
	public SimpleRectangle() {
		
	}
	
	//constructor with specific length and width
	public SimpleRectangle(double newLength, double newWidth) {
		length = newLength;
		width = newWidth;
	}
	
	//Method to get area of rectangle
	double getArea() {
		return length*width;
	}
	
	//method to get parameter
	double getPerimeter() {
		return 2*(length+width);
	}
	
	//set length
	void setLength(double newLength) {
		length = newLength;
	}
	
	//set width
		void setWidth(double newWidth) {
			length = newWidth;
		}
}// end SimpleRectangle