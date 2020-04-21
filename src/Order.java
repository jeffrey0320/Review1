import java.util.ArrayList;

public class Order extends Transaction {
    private String item;
    private int quantity;
    private double costOfItem;

    public Order(char type, String customerNum, String transactionNum,String item, int quantity, double costOfItem) {
        super(type,customerNum,transactionNum);
        this.item = item;
        this.quantity = quantity;
        this.costOfItem = costOfItem;
    }
}
