import java.util.Comparator;

public class DogLauncher {
    public static void main(String[] args) {
        Dog d1 = new Dog("Elyse", 3);
        Dog d2 = new Dog("Sture", 9);
        Dog d3 = new Dog("Benjamin", 15);
        Dog[] dogs = new Dog[]{d1, d2, d3};

        Dog d = (Dog) Maximizer.max(dogs);
        System.out.println(d.name);

        // Comparator<Dog> nameComparator =new Dog.NameComparator();
        //do not need to instantiate a Dog to get a NameComparator
        Comparator<Dog> nameComparator = Dog.getNameComparator();
        if (nameComparator.compare(d1, d3) > 0) { // Elyse should bark
            d1.bark();
        } else {
            d3.bark();
        }
    }
}
