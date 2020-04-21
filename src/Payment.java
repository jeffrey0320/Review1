public class Payment extends Transaction {
    private double amountOfPayment;

    public Payment(char transactionType, String customerNum, String transactionNumber,double amountOfPayment) {
        super(transactionType,customerNum,transactionNumber);
        this.amountOfPayment = amountOfPayment;
    }

    public void makePayment(){

    }
}
