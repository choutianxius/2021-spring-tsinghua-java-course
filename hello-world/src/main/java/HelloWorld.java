import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;

/**
 * @author octopusthu@gmail.com
 */
public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello, world!");
        fruitsInBag();
    }

    private static void fruitsInBag() {
        Bag<String> bag = new HashBag<>();
        System.out.println("Initialize a new bag");

        bag.add("APPLE", 6);
        System.out.println("Add 6 apples to the bag");
        bag.add("PEAR", 5);
        System.out.println("Add 5 pears to the bag");

        System.out.println("Now the bag has "
            + bag.getCount("APPLE") + " apples and "
            + bag.getCount("PEAR") + " pears in it.");

        bag.remove("APPLE", 2);
        System.out.println("Remove 2 apples from the bag");
        bag.add("PEAR", 2);
        System.out.println("Add 2 pears to the bag");

        System.out.println("Now the bag has "
            + bag.getCount("APPLE") + " apples and "
            + bag.getCount("PEAR") + " pears in it.");
    }

}
