import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;

/**
 * @author octopusthu@gmail.com
 */
public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello, world!");
        bagRemoval();
    }

    private static void bagRemoval() {
        Bag<String> bag = new HashBag<>();

        // add 6 copies of "ITEM"
        bag.add("ITEM", 6);

        // removes 2 copies of "ITEM"
        bag.remove("ITEM", 2);

        int itemsLeft = bag.getCount("ITEM");

        // returns 4, the number of copies in the bag (6 - 2)
        System.out.println("Add 6 items to the bag and remove 2 from it will leave "
            + itemsLeft + " items in the bag.");
    }

}
