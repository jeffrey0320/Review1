import java.io.File;
import java.io.FileNotFoundException;
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
                Transaction order = new Order(tokens[0].charAt(0), tokens[1], tokens[2], tokens[3], Integer.parseInt(tokens[4]), Double.parseDouble(tokens[5]));
                int index = findAcct(tokens[1],customer);
                if(index == -1){
                    System.out.println("Customer not found");
                }else{
                    person = customer.get(index);
                    person.addTransaction(order);

                    //makeOrder(customer,person);
                }

            } else {
                Transaction payment = new Payment(tokens[0].charAt(0), tokens[1], tokens[2], Double.parseDouble(tokens[3]));
                int index = findAcct(tokens[1],customer);
                if(index == -1){
                    System.out.println("Customer not found");
                }else{
                    person = customer.get(index);
                    person.addTransaction(payment);


                }
            }
            //System.out.println(customer.get(0).getBalanceDue());
        }
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

    public static void output(ArrayList<Customer> customers){

    }

    public static int findAcct(String reqAccount,ArrayList<Customer> customers){
        for (int index = 0; index < customers.size(); index++)
            if (customers.get(index).getCustomerNum().equals(reqAccount))
                return index;
        return -1;
    }
}
