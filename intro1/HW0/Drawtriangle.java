/*
Draw the lower trainagle shape of *
*/
public class Drawtriangle {
	public static void draw(int x) {
		// i is from row and j is for column
		for (int i=1; i<=x; i=i+1 ){
			for (int j=1; j<=i; j=j+1 ){
				System.out.print('*');
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		draw(5);
	}
} 

/*
1. Functions must be declared as part of a class in Java.
   A function that is part of a class is called a "method".
   So in Java, all functions are methods.
2. To define a function in Java, we use "public static".
   We will see alternate ways of defining functions later.
3. All parameters of a function must have a declared type,
   and the return value of the function must have a declared type.
   Functions in Java return only one value!
*/
