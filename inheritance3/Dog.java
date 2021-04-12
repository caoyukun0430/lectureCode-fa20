import java.util.Comparator;

public class Dog implements Comparable<Dog> {
    public String name;
    private int size;

    public Dog(String n, int s) {
        name = n;
        size = s;
    }

    @Override
    public int compareTo(Dog uddaDog) {
        //assume nobody is messing up and giving us
        //something that isn't a dog.
        return size - uddaDog.size;
    }


    public void bark() {
        System.out.println(name + " says: bark");
    }

    public static class NameComparator implements Comparator<Dog> {

        @Override
        public int compare(Dog o1, Dog o2) {
            return o1.name.compareTo(o2.name);
        }
    }

    // we do not need to instantiate a Dog to get a NameComparator
    public static Comparator<Dog> getNameComparator() {
        return new NameComparator();
    }

}