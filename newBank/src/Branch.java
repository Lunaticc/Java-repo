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

        }
    }
    private void menuList(){
        System.out.println("Enter: ");
        System.out.println("0 - Exit\n" +
                "1 - Add costumer\n" +
                "2 - Remove Costumer\n" +
                "3 - Print costumers\n" +
                "4 - Add transaction\n"); //fix
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
        }else{
            System.out.println("Please enter different name - Already taken!");
        }
    }

    private void addTransaction(String name){
        int found = findCostumer(name);
        if(found >= 0){
            System.out.println("How much would you like to add?");
            double amount = scan.nextDouble();
            scan.nextLine(); // Buffer
            costumers.get(found).getTransactions().add(amount);
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
