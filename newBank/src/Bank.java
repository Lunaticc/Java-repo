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

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    private ArrayList<Branch> branches;
    private Branch branch;
    private Scanner scan = new Scanner(System.in);

    public Bank() {
        this.branches = new ArrayList<>();
    }



    private void addBranch(){
        System.out.print("Enter name for new branch: ");
        String name = scan.nextLine();
        if(findBranch(name) < 0){
            branch = new Branch(name);
            branches.add(branch);
            System.out.println(branch.getName() + " added\n");
        }else{
            System.out.println("Unable to add branch - Branch already existing");
        }

    }

    private void printBranches(){
        for (int i=0; i<branches.size(); i++){
            System.out.println((i+1) +" - "+ branches.get(i).getName());
        }
        System.out.println("");
    }
    private void removeBranch(){
        printBranches();
        System.out.print("Chose a branch to remove: ");
        String choice = scan.nextLine();
        int removed = findBranch(choice);
        if(removed >= 0){
            branches.remove(removed);
            System.out.println("Branch removed!\n");
        }else {
            System.out.println("Branch not found!\n");
        }
    }
    private void enterBranch(){
        printBranches();
        System.out.print("What branch would you like to enter? ");
        String branch = scan.nextLine();
        int found = findBranch(branch);
        if (found >= 0){
            branches.get(found).menu();
        }
    }
    private int findBranch(String name){ // Find index of searched branch.
        for (int i=0; i<branches.size(); i++){
            if(branches.get(i).getName().equalsIgnoreCase(name)){
                return i;
            }
        }
        return -1;
    }

    public void menu(){
        boolean isOff = false;

        while (!isOff){
            menuList();
            int choice = scan.nextInt();
            scan.nextLine(); // Buffer

            switch (choice){
                case 0:
                    isOff = true;
                    break;
                case 1:
                    addBranch();
                    break;
                case 2:
                    removeBranch();
                    break;
                case 3:
                    printBranches();
                    break;
                case 4:
                    enterBranch();
                    break;
            }
        }
    }

    private void menuList(){
        System.out.println("Enter: ");
        System.out.println("0 - Exit\n" +
                "1 - Add new branch\n" +
                "2 - Remove branch\n" +
                "3 - Print branches\n" +
                "4 - Enter Branch\n");
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }
}
