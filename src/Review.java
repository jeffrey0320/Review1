import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Review {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Customer> customer = new ArrayList<>();
        readMasterFile(customer);

        String line;
        File transactionFile = new File("transactionFile.txt");
        Scanner readFile = new Scanner(transactionFile);

        while (readFile.hasNext()) {
            line = readFile.nextLine();
            String[] tokens = line.split(" ");
            Customer person;

            if (tokens[0].equals("O")) {
                Transaction order = new Transaction(tokens[0].charAt(0), tokens[1], tokens[2], tokens[3], Integer.parseInt(tokens[4]), Double.parseDouble(tokens[5]));
                int index = findAcct(tokens[1],customer);
                if(index == -1){
                    System.out.println("Customer not found");
                }else{
                    person = customer.get(index);
                    person.makeOrder(order,person);
                    person.addTransaction(order);
                }
            } else {
                Transaction payment = new Transaction(tokens[0].charAt(0), tokens[1], tokens[2], Double.parseDouble(tokens[3]));
                int index = findAcct(tokens[1],customer);
                if(index == -1){
                    System.out.println("Customer not found");
                }else{
                    person = customer.get(index);
                    person.makePayment(payment,person);
                    person.addTransaction(payment);
                }
            }
        }
        print(customer);
        readFile.close();
    }

    public static void readMasterFile (ArrayList < Customer > info) throws FileNotFoundException {
        String line;
        File masterFile = new File("masterFile.txt");
        Scanner readFile = new Scanner(masterFile);

        while (readFile.hasNext()) {
            line = readFile.nextLine();
            String[] tokens = line.split(" ");

            Customer newCustomer = new Customer(tokens[0], tokens[1], Double.parseDouble(tokens[2]));
            info.add(newCustomer);
        }
        readFile.close();
    }

    public static void print(ArrayList<Customer> customers) throws FileNotFoundException {
        File outputFile = new File("utput.txt");
        PrintWriter out = new PrintWriter(outputFile);

        for(int i = 0; i < customers.size(); i++){
            Customer info = customers.get(i);

            out.println(info.getName() + " " +info.getCustomerNum());
            out.printf("\t\t\t\tPrevious Balance $%.2f\n", info.getInitialBal());

            for(int j = 0;j < info.getTransactions().size();j++){
                Transaction transactionInfo = info.getTransactions().get(j);
                out.print("Transaction# " + transactionInfo.getTransactionNumber());
                if(transactionInfo.getTransactionType() == 'O'){
                    out.printf(" ITEM ORDERED $%.2f\n", transactionInfo.getTotalCost());
                }else {
                    out.printf(" PAYMENT $%.2f\n", transactionInfo.getAmountOfPayment());
                }
            }
            out.flush();
            out.printf("\t\t\t\tBalance Due $%.2f\n", info.getPostBalanceDue());
            out.println();
        }
        out.flush();
    }

    public static int findAcct(String reqAccount,ArrayList<Customer> customers){
        for (int index = 0; index < customers.size(); index++)
            if (customers.get(index).getCustomerNum().equals(reqAccount))
                return index;
        return -1;
    }
}
