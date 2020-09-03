public class Transaction {
    private char transactionType;
    private String customerNum;
    private String transactionNumber;
    private String item;
    private int quantity;
    private double costOfItem;
    private double amountOfPayment;

    public Transaction(char type, String customerNum, String transactionNum,String item, int quantity, double costOfItem) {
        this.transactionType = type;
        this.customerNum = customerNum;
        this.transactionNumber = transactionNum;
        this.item = item;
        this.quantity = quantity;
        this.costOfItem = costOfItem;
    }

    public Transaction(char transactionType, String customerNum, String transactionNumber,double amountOfPayment) {
        this.transactionType = transactionType;
        this.customerNum = customerNum;
        this.transactionNumber = transactionNumber;
        this.amountOfPayment = amountOfPayment;
    }


    public char getTransactionType() {
        return transactionType;
    }

    public String getCustomerNum() {
        return customerNum;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public double getTotalCost() {
        return quantity * costOfItem;
    }

    public String getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getCostOfItem() {
        return costOfItem;
    }

    public double getAmountOfPayment() {
        return amountOfPayment;
    }

}
