import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by johnm on 2017-01-16.
 */
public class BankTest {
    private static boolean check = true;
    private static ArrayList<Branch> myBranch = new ArrayList<Branch>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("The \"AssHole\" Bank System Initialized.");

        while (check) {
            printAction();
            int action = scanner.nextInt();
            scanner.nextLine();

            if (action < 1 || action > 4) {
                System.out.println("Not Available Action Number. Try again please.");
                continue;
            }


            switch (action) {
                case 1:
                    System.out.println("please set new branch name : \n");
                    String branchName = scanner.nextLine();
                    System.out.println("please tell Customer name : \n");
                    String customerName = scanner.nextLine();
                    System.out.println("please tell this customer transaction : \n");
                    double money = scanner.nextDouble();
                    scanner.nextLine();

                    check = myBranch.add(Branch.newBranch(branchName, Customer.newCustomer(customerName, money)));
                    if (!check) {
                        System.out.println("Failed add new branch");
                    } else {
                        System.out.println("Successfully added new branch " + branchName);
                    }
                    break;

                case 2:
                    printBranchList();
                    break;




            }

        }


    }

    public static void printAction() {
        System.out.println("-------Main Menu-------\n" +
                "1.add new branch.\n" +
                "2.print branch list.\n" +
                "3.find branch.\n" +
                "4.delete branch.\n" +
                "5.Exit\n" +
                "Select Action Number : \n");
    }

    public static void printBranchList() {
        if (myBranch.size() <= 0){
            System.out.println("There no branch in the list");
            return;
        }else{
            for(int i=0; i<myBranch.size(); i++){
                myBranch.get(i).printBranchInfo();
            }
        }
    }

}
