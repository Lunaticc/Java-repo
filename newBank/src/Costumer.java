import java.util.ArrayList;

public class Costumer {
    private ArrayList<Double> transactions;
    private String name;

    public Costumer(String name, double amount) {
        this.name = name;
        transactions = new ArrayList<>();
        newTransaction(amount);
    }

    public void newTransaction(double amount){
        this.transactions.add(amount);
    }
    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public String getName() {
        return name;
    }
}
