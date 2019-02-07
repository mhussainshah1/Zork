/**
 * @author djw
 * Methods allow you to divide your program into workable, reusable components
 *
 */
public class Application {

    public static void main(String[] args) {
        boolean isFixed = false;

        // once callPlumber executes, isFixed doesn't care what happens in
        // the method... it just wants a return value.
        isFixed = callPlumber();

        if (isFixed) {
            System.out.println("My wife is happy. The drain is fixed.");
        } else {
            System.out.println("I'm in the doghouse. The drain is leaking.");
        }

    }

    private static boolean callPlumber() {
        // Some code here where plumber does his thing - I don't even
        // know what he does because I don't have to pay attention
        // I just call him and pay him.

        //calculate cost method takes two parameters but doesn't return a value
        String customer = "Mr. Fix-it";
        String repairs = "fixed drain";
        double labor_hours = 1.5;
        double materials_cost = .75;

        //this method calls another method:
        GenerateInvoice(customer, repairs, labor_hours, materials_cost);

        return true;
    }

    private static void GenerateInvoice(String customer, String repairs, double labor, double materials) {
        //calculates cost and prints invoice
        double hourlyrate = 99.0;
        double cost = (hourlyrate * labor) + materials;

        System.out.println(" --- Invoice ---");
        System.out.println("Customer: " + customer);
        System.out.println("Repairs: " + repairs);
        System.out.println("Cost: " + cost);
        System.out.println();//prints blank line
    }

}


