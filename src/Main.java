import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.exit;

public class Main {
    static Customer logedInCustomer = new Customer();

    static Customer recievedCustomer = new Customer();

    public static void main(String[] args) {
        ArrayList<Customer> arrayList = new ArrayList<>();
        Account oykuAccount = new Account();
        CreditCard creditCard = new CreditCard(1500, oykuAccount);
        Customer customer = new Customer(1,"Oyku","Kurtgoz",12345,oykuAccount);
        System.out.println("Oyku account number: " + oykuAccount.getAccountNumber());
        arrayList.add(customer);
        System.out.println("press 1 for sign up, press 2 for sign in");
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        if (a == 1) {
            System.out.println("Enter your ID,name,last name and password ");
            Account account = new Account();
            CreditCard creditCard1 = new CreditCard(1500,account);
            int id = scan.nextInt();
            scan.nextLine();
            String name = scan.nextLine();
            String lastName = scan.nextLine();
            int password = scan.nextInt();
            Customer customer1 = new Customer(id, name, lastName, password,account,creditCard1);
            arrayList.add(customer1);
            logedInCustomer = customer1;
            System.out.println("singed in successfully");
        } else {
            System.out.println("Enter your ID and password");
            Customer customer2 = new Customer();
            int id = scan.nextInt();
            int password = scan.nextInt();
            customer2.setPassword(password);
            customer2.setId(id);
            for (int i = 0; i < arrayList.size(); i++) {
                if (customer2.id == arrayList.get(i).id) {
                    if (customer2.password == arrayList.get(i).password) {
                        System.out.println("entered successfully");
                        logedInCustomer = arrayList.get(i);
                        break;
                    }else {
                        System.out.println("wrong id or password");
                    }
                }
            }
        }
        while (true) {
            System.out.println("enter 1 to deposit\nenter 2 to withdraw \nenter 3 to transfer \n" +
                    "enter 4 to see your account");
            int b = scan.nextInt();
            switch (b) {
                case 1:
                    System.out.println("enter 1 for account enter 2 for credit card");
                    int c = scan.nextInt();
                    if (c == 1) {
                        System.out.println("enter the amount of money to deposit");
                        double money = scan.nextDouble();
                        logedInCustomer.account.deposit(money,logedInCustomer);
                        System.out.println("your asset: "+ logedInCustomer.account.asset);
                    } else {
                        CreditCard creditCard1 = new CreditCard(1500, logedInCustomer.account);
                        System.out.println("enter the amount of money");
                        double money = scan.nextDouble();
                        creditCard1.deposit(money, logedInCustomer.account);
                        System.out.println("your limit: "+ creditCard1.limit);
                    }
                    break;
                case 2:
                    System.out.println("Enter amount of money to withdraw");
                    double money = scan.nextDouble();
                    logedInCustomer.account.withdraw(money,logedInCustomer);
                    System.out.println("your asset: "+ logedInCustomer.account.asset);
                    break;
                case 3:
                    System.out.println("Enter amount of money to transfer");
                    double money1 = scan.nextDouble();
                    System.out.println("Enter the account number of the recipient");
                    int accountNumber = scan.nextInt();

                    Account account1 = new Account();
                    account1.setAccountNumber(accountNumber);


                    for (int i = 0; i < arrayList.size(); i++){
                        if (account1.getAccountNumber() == arrayList.get(i).getAccountNumber()) {
                            logedInCustomer.account.transfer(money1, arrayList.get(i).account, logedInCustomer.account);
                            System.out.println("Your asset: " + logedInCustomer.account.asset);
                            System.out.println("revieved account asset: "+arrayList.get(i).account.getAsset());
                        }
                    }
                    break;
                case 4:
                    System.out.println("Your asset: " + logedInCustomer.account.asset +
                            "your debt: " + logedInCustomer.account.debt);
                    break;
            }
            System.out.println("to exit press 1, go back to menu press 2");
            int c = scan.nextInt();
            if (c == 1){
                exit(1);
            }else continue;
        }
    }
}

