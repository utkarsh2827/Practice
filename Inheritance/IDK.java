import java.util.*;
class Base{
	int x;
	Base(){
		x = 2;
	}
	void hello(){
		System.out.println("hello");
	}
	void print(){
		System.out.println(x);
	}
}
class Derived extends Base{
	int x;
	Derived(){
		x = 1;
	}
	void print(){
		
		System.out.println(x+" "+x);
		super.print();
	}
}

public class IDK{
	public static void main(String[] args) {
		Base b = new Derived();
		b.hello();
		b.print();
	}
}