public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        BankAccount bankAccount = new BankAccount();

        CheckingAccount checkingAccount = new CheckingAccount();
        SavingsAccount savingsAccount = new SavingsAccount();
        CertificateOfDeposit certificateOfDeposit = new CertificateOfDeposit();
        //bankAccount.getAccount();
        bankAccount.setAccount("Joseph Ngugi Muiruri");
        bankAccount.getBalance();
        bankAccount.setBalance(150000);

        System.out.println(bankAccount.getAccount());
        System.out.println(bankAccount.getBalance());
        checkingAccount.setAccount("Johansen");
        System.out.println(checkingAccount.getAccount());
        checkingAccount.setBalance(170000);
        System.out.println(checkingAccount.getBalance());
        System.out.println(savingsAccount.getAccount());
        System.out.println(savingsAccount.getBalance());
        System.out.println(certificateOfDeposit.getAccount());
        System.out.println(certificateOfDeposit.getBalance());
            System.out.println("Joseph Ngugi Muiruri");
    }
}
