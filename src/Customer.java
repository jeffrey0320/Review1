import java.util.ArrayList;

public class Customer {
    private String customerNum;
    private String name;
    private double balanceDue;
    ArrayList<Transaction> transactions;

    public Customer(String customerNum, String name, double balanceDue) {
        this.customerNum = customerNum;
        this.name = name;
        this.balanceDue = balanceDue;
    }

    public void makePayment(){
        for (Transaction transaction : transactions) {
            if (transaction.getTransactionType().equals("O")) {
                
            }
        }
    }

    public String getCustomerNum() {
        return customerNum;
    }

    public String getName() {
        return name;
    }

    public double getBalanceDue() {
        return balanceDue;
    }

    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }
}
