import java.util.Random;

public class CreditCard{
    double limit=0;
    Account account;
    double cardNumber;

    Random rand = new Random();

    public CreditCard(double limit, Account account) {
        this.limit = limit;
        this.account = account;
        this.cardNumber = rand.nextInt(90000)+10000;
    }

    public void deposit(double money, Account account) {
        if (money<=account.debt){
            account.debt = account.debt - money;
            limit += money;
            System.out.println("deposit successfully");
        }else {
            System.out.println("out of limit");
        }
    }

    public double getLimit() {
        return limit;
    }

    public double getCardNumber() {
        return cardNumber;
    }

    public void spending (double money, Account account){
        if (money<=limit){
            account.debt = account.debt + money;
            limit -= money;
        }else {
            System.out.println("limit is insufficient");
        }
    }
}
