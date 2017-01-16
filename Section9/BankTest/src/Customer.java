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

public class Customer {
    private String name;
    private double balance;
    private ArrayList<Double> transaction;
    private boolean check;


    {
        this.transaction = new ArrayList<Double>();
    }

    //get instance 1
    public static Customer newCustomer(String name) {
        return new Customer(name);
    }

    //get instance 2
    public static Customer newCustomer(String name, Double transaction) {
        return new Customer(name, transaction);
    }

    //Constructor 1
    public Customer(String name) {
        this.name = name;
    }

    //Constructor 2
    public Customer(String name, Double transaction) {
        this.name = name;
        this.transaction.add(transaction);
    }

    //get name
    public String getName() {
        return name;
    }

    //get balance
    public double getBalance() {
        return balance;
    }

    //add transaction
    public boolean addTransaction(Double transaction) {
        check = this.transaction.add(transaction);
        return check;
    }


    //print customer name & transaction List
    public void printCustomer() {
        System.out.println(getName());
        for (int i = 0; i < transaction.size(); i++) {
            System.out.printf(" %d# : %.3f\n", i, transaction.get(i));
        }
        this.balance();
        System.out.println("balance : " + balance);
    }

    //customer total balance
    public void balance() {
        double total = 0.0;
        if (this.transaction.size() >= 0) {
            return;
        }
        for (int i = 0; i < transaction.size(); i++) {
            total += transaction.get(i);
        }
        this.balance = total;
    }

    //compare transaction for equal customer
    private boolean equalsTransaction(ArrayList o) {
        if (o == null) return false;
        if (o.size() != this.transaction.size()) return false;

        for (int i = 0; i < this.transaction.size(); i++) {
            if (transaction.get(i) != o.get(i))
                return false;
        }

        return true;
    }

    //equal customer
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;

        Customer customer = (Customer) o;

        if (this.getName().equals(customer.getName()) &&
                this.equalsTransaction(customer.transaction)) {
            return true;
        }
        return false;
    }

}
