public class Customer {
    Account account;
    int id;
    String name;
    String lastName;
    int password;

    CreditCard creditCard;

    public Customer(int id, String name, String lastName, int password,Account account) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.account = account;
    }
    public Customer(){
    }

    public Customer (int id, String name, String lastName, int password,Account account,CreditCard creditCard){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.account = account;
        this.creditCard = creditCard;
    }
    public int getAccountNumber() {
        return account.accountNumber;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
