import java.util.Random;

public class Account {
    int accountNumber;
    double asset=0;
    double debt=0;

    CreditCard creditCard;
    Customer customer;

    public Account() {
        Random rand = new Random();
        accountNumber = rand.nextInt(90000)+10000;
    }

    public Account(Customer customer) {
        this.customer = customer;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getDebt() {
        return debt;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }

    public double getAsset() {
        return asset;
    }

    public void setAsset(double asset) {
        this.asset = asset;
    }

    public void withdraw(double money, Customer customer) {
        if (money <= customer.account.asset) {
            customer.account.asset -= money;
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void deposit(double money,Customer customer) {
        customer.account.asset=+money;
        System.out.println("deposit successfully");
    }
    public void transfer(double money, Account receivedAccount, Account sentAccount) {
        if (money <= sentAccount.asset) {
            receivedAccount.asset += money;
            sentAccount.asset -= money;
            System.out.println("Transfer successful");
        } else {
            System.out.println("Insufficient balance");
        }
    }
}
