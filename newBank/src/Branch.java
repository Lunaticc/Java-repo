import java.util.ArrayList;
import java.util.Scanner;

// Branch:
// Need to be able to add a new customer and initial transaction amount.
// Also needs to add additional transactions for that customer/branch


public class Branch {
    private ArrayList<Costumer> costumers;
    private Costumer costumer;
    private String name;
    private Scanner scan = new Scanner(System.in);

    public Branch(String name) {
        this.name = name;
        costumers = new ArrayList<>();
    }

    public void menu(){
        boolean isOff = false;


        while(!isOff){
            menuList();
            int choice = scan.nextInt();
            scan.nextLine(); // buffer!
            switch (choice) {
                case 0 -> isOff = true;
                case 1 -> addCostumer();
                case 2 -> removeCostumer();
                case 3 -> printCostumers();
                case 4 -> addTransaction();
                case 5 -> showTransactions();
            }
        }
    }
    private void menuList(){
        System.out.println("Enter: ");
        System.out.println("0 - Exit\n" +
                "1 - Add costumer\n" +
                "2 - Remove Costumer\n" +
                "3 - Print costumers\n" +
                "4 - Add transaction\n" +
                "5 - Show transactions\n"); //fix
    }
    private void printCostumers(){
        for (int i=0; i<costumers.size(); i++){
            System.out.println("Costumer name: " + costumers.get(i).getName());
        }
    }

    private void showTransactions(){

        System.out.println("Show transaction for? ");
        printCostumers();
        String name = scan.nextLine();
        int index = findCostumer(name);
        Costumer costumer = costumers.get(index);

        for (int i=0 ; i<costumers.get(index).getTransactions().size(); i++){
            System.out.println("Transaction for costumer: " + name + " " + costumer.getTransactions().get(i));
        }
    }
    private void removeCostumer(){
        System.out.print("Who would you like to remove? ");
        String name = scan.nextLine();
        int found = findCostumer(name);
        if (found >= 0) {
            costumers.remove(found);
            System.out.println("Costumer removed!");
        }else{
            System.out.println("Costumer not found!");
        }
    }
    private void addCostumer(){
        System.out.println("Enter name and initial amount for new costumer: ");
        System.out.print("Name: ");
        String name = scan.nextLine();
        System.out.print("Amount: ");
        double amount = scan.nextDouble();
        scan.nextLine(); // Buffer!
        if(findCostumer(name) == -1){
            costumer = new Costumer(name, amount);
            this.costumers.add(costumer);
            System.out.println("Costumer added!");
        }else{
            System.out.println("Please enter different name - Already taken!");
        }
    }

    private void addTransaction(){
        System.out.println("Who would you like to add a transaction to?");
        printCostumers();
        String name = scan.nextLine();
        int found = findCostumer(name);
        if(found >= 0){
            System.out.println("How much would you like to add?");
            double amount = scan.nextDouble();
            scan.nextLine(); // Buffer
            costumers.get(found).newTransaction(amount);
        }else{
            System.out.println("Cant find costumer");
        }
    }


    private int findCostumer(String name){
        for (int i=0; i<costumers.size(); i++){
            if (costumers.get(i).getName().equalsIgnoreCase(name)){
                return i;
            }
        }
        return -1;
    }


    public ArrayList<Costumer> getCostumers() {
        return costumers;
    }

    public String getName() {
        return name;
    }
}
