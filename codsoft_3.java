import java.util.*;
class BankAcc {
    double balance;
    void setBal(double initialBal) {
        balance = initialBal;
    }
    double getBal() {
        return balance;
    }
    String deposit(double amt) {
        balance += amt;
        return "Deposited: Rs." + amt;
    }
    String withdraw(double amt) {
        if (amt <= balance) {
            balance -= amt;
            return "Withdrew: Rs." + amt;
        }
         else {
            return "Insufficient Balance!";
        }
    }
}
class ATM {
    static BankAcc bankacc;
    static Scanner scanner = new Scanner(System.in);
    public static void initialize(BankAcc account) {
        bankacc = account;
    }
    public static void start() {
        while(true){
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice=scanner.nextInt();
            if(choice==4){
                System.out.println("Exiting...");
                break;
            }
            switch(choice){
                case 1:System.out.println("Current Balance: Rs " + bankacc.getBal());
                    break;
                case 2:System.out.print("Enter amount to deposit: ");
                    double depositAmt = scanner.nextDouble();
                    System.out.println(bankacc.deposit(depositAmt));
                    break;
                case 3:System.out.print("Enter amount to withdraw: ");
                    double withdrawAmt = scanner.nextDouble();
                    System.out.println(bankacc.withdraw(withdrawAmt));
                    break;
                default:System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void main(String args[]) {
        BankAcc bankAcc=new BankAcc();
        bankAcc.setBal(1000);
        ATM.initialize(bankAcc);
        ATM.start();
    }
}
