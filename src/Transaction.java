public  abstract class Transaction {
    private char transactionType;
    private String customerNum;
    private String transactionNumber;

    public Transaction(char transactionType, String customerNum, String transactionNumber) {
        this.transactionType = transactionType;
        this.customerNum = customerNum;
        this.transactionNumber = transactionNumber;
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
}
