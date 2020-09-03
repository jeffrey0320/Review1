import java.util.ArrayList;

public class Customer {
    private String customerNum;
    private String name;
    private double preBalanceDue;
    private double postBalanceDue;
    private double initialBal;
    private ArrayList<Transaction> transactions;

    public Customer(String customerNum, String name, double preBalanceDue) {
        this.customerNum = customerNum;
        this.name = name;
        this.preBalanceDue = preBalanceDue;
        this.initialBal = preBalanceDue;
        transactions = new ArrayList<>();
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void makePayment(Transaction payment, Customer info){
        setPostBalanceDue(info.getPreBalanceDue() - payment.getAmountOfPayment());
        this.preBalanceDue = info.getPostBalanceDue();
    }

    public void makeOrder(Transaction order, Customer info){
        setPostBalanceDue(info.getPreBalanceDue() + order.getTotalCost());
        this.preBalanceDue = info.getPostBalanceDue();
    }

    public String getCustomerNum() {
        return customerNum;
    }

    public String getName() {
        return name;
    }

    public double getPreBalanceDue() {
        return preBalanceDue;
    }

    public double getPostBalanceDue(){
        return postBalanceDue;
    }

    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }

    private void setPreBalanceDue(double preBalanceDue){
        this.preBalanceDue = preBalanceDue;
    }

    private void setPostBalanceDue(double newBalance){
        this.postBalanceDue = newBalance;
    }

    public double getInitialBal() {
        return initialBal;
    }
}
