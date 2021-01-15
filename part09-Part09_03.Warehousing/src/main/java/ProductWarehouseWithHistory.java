import java.util.ArrayList;

public class ProductWarehouseWithHistory extends ProductWarehouse{
    private ChangeHistory history = new ChangeHistory();

    public ProductWarehouseWithHistory(String productName,double capacity,double initialBalance){
        super(productName,capacity);
        super.addToWarehouse(initialBalance);
        history.add(initialBalance);
    }
    public String history() {
        return history.toString();
    }
    public void addToWarehouse(double amount) {
        double balance = 0;
//        if (amount < 0) {
//            return;
//        }
//        if (amount <= super.howMuchSpaceLeft()) {
//            balance = super.getBalance() + amount;
//            history.add(balance);
//        } else {
//            balance = super.getCapacity();
//            history.add(balance);
//        }
        balance = (double) super.getBalance() + amount;
        history.add(balance);
        super.addToWarehouse(amount);
    }
    public double takeFromWarehouse(double amount) {
        double balance = 0;
        balance = super.getBalance() - amount;
        history.add(balance);
        return super.takeFromWarehouse(amount);
    }
    public void printAnalysis() {
        System.out.println("Product: " + super.getName());
        System.out.println("History: " + history());
        System.out.println("Largest amount of product: " + history.maxValue());
        System.out.println("Smallest amount of product: " + history.minValue());
        System.out.println("Average: " + history.average());
    }
}
