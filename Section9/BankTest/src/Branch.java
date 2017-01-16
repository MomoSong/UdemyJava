import java.util.ArrayList;

/**
 * Created by johnm on 2017-01-16.
 */
// You job is to create a simple banking application.
// There should be a Bank class
// It should have an arraylist of Branches
// Each Branch should have an arraylist of Customers
// The Customer class should have an arraylist of Doubles (transactions)
// Customer:
// Name, and the ArrayList of doubles.
// Branch:
// Need to be able to add a new customer and initial transaction amount.
// Also needs to add additional transactions for that customer/branch
// Bank:
// Add a new branch
// Add a customer to that branch with initial transaction
// Add a transaction for an existing customer for that branch
// Show a list of customers for a particular branch and optionally a list
// of their transactions
// Demonstration autoboxing and unboxing in your code
// Hint: Transactions
// Add data validation.
// e.g. check if exists, or does not exist, etc.
// Think about where you are adding the code to perform certain actions

public class Branch {
    private boolean check;
    private String name;
    private ArrayList<Customer> customers;
    private double branchBalance;

    {
        this.customers = new ArrayList<Customer>();
    }

    //get instance 1
    public static Branch newBranch(String name) {
        return new Branch(name);
    }

    //get instance 2
    public static Branch newBranch(String name, Customer customer) {
        return new Branch(name, customer);
    }

    //Constructor 1
    public Branch(String name) {
        this.name = name;
    }

    //Constructor 2
    public Branch(String name, Customer customers) {
        this.name = name;
        this.customers.add(customers);
    }

    //get name
    public String getName() {
        return name;
    }

    //new Customer 1
    public Customer newCustomer(String name) {
        return Customer.newCustomer(name);
    }

    //new Customer 2
    public Customer newCustomer(String name, Double transaction) {
        return Customer.newCustomer(name, transaction);
    }

    //customer new transaction
    public boolean addCustomerTransaction(String name, double money) {
        if (findCustomer(name) < 0) {
            System.out.println("Can't find customer.");
            return false;
        } else {
            this.customers.get(findCustomer(name)).addTransaction(money);
            System.out.println("Successfully added transaction. ");
            return true;
        }
    }

    public boolean deleteCustomer(String name) {
        int index = findCustomer(name);
        if (index < 0) {
            System.out.println("Customer " + name + " doesn't exist");
            return false;
        } else {
            this.customers.remove(index);
            System.out.println("Successfully deleted customer " + name + " information.");
            return true;
        }
    }

    //print customer name of list
    public void printCustomerListName() {
        for (int i = 0; i < this.customers.size(); i++) {
            System.out.println(this.customers.get(i).getName());
        }
    }

    //print someone's transaction information
    public void printCustomerInfo(String name) {
        int index = findCustomer(name);
        if (index < 0) {
            System.out.println("Customer " + name + " doesn't exist");
        } else {
            this.customers.get(findCustomer(name)).printCustomer();
            System.out.println("....successfully printed.");
        }
    }

    //print money branch information
    public void printBranchInfo() {
        getBranchBalance();
        System.out.println(this.name + " branch, has " + customers.size() + "customers " +
                "Total balance " + branchBalance);
        for(int i=0; i<customers.size(); i++){
            customers.get(i).printCustomer();
        }
    }

    //calculate branch money
    public void getBranchBalance(){
        for(int i=0; i<this.customers.size(); i++){
            this.customers.get(i).balance();
            branchBalance += this.customers.get(i).getBalance();
        }
    }

    // find index of customer by name
    private int findCustomer(String name) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().equals(name)) {
                return customers.indexOf(customers.get(i));
            }
        }
        return -1;
    }

    // find index of customer by object
    private int findCustomer(Customer customer) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).equals(customer)) {
                return customers.indexOf(customers.get(i));
            }
        }
        return -1;
    }
}

