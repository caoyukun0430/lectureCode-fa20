public class DogLauncher {
	public static void main(String[] args) {
		Dog d = new Dog(15);

		Dog d2 = new Dog(100);

		// If we instantiate Dog.maxDog, the method needs to be static, otherwise
		// non-static
//		Dog bigger = Dog.maxDog(d, d2);
		// if we call maxDog as instance method from an existing instance d, method is not static
		Dog bigger = d.maxDog(d, d2);
		bigger.makeNoise();

		//System.out.println(d.binomen);
		//System.out.println(d2.binomen);
		//System.out.println(Dog.binomen);
//		d.makeNoise();
	}
} 