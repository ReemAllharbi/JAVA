import java.util.ArrayList;

public class TestOrders {
    public static void main(String[] args) {
        Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();
        Item item4 = new Item();




        // Menu items
        item1.name="mocha";
        item1.price=22;

        item2.name="latte";
        item2.price=12;

        item3.name="dripCoffee";
        item3.price=16;

        item4.name="capuccino";
        item4.price=17;

        // Order variables -- order1, order2 etc.
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order();
        Order order4 = new Order();

        order1.name="Cindhuri";


        order2.name="Jimmy";
        order2.items.add( item1.name);
        order2.total= item1.price;
        order2.ready= true;

        order3.name="Noah";
        order2.items.add( item4.name);
        order4.total= item4.price;


        order4.name="Sam";
        order4.items.add( item2.name);
        order4.items.add( item2.name);
        order4.items.add( item2.name);
        order4.total= item2.price*3;
        order4.ready= true;

    
        // Application Simulations
        // Use this example code to test various orders' updates
        System.out.printf("Name: %s\n", order4.name);
        System.out.printf("Name: %s\n", order4.items);
        System.out.printf("Total: %s\n", order4.total);
        System.out.printf("Ready: %s\n", order4.ready);

    }
}
