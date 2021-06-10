package pl.edu.pwsztar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO: Prosze dokonczyc implementacje oraz testy jednostkowe
// TODO: Prosze nie zmieniac nazw metod - wszystkie inne chwyty dozwolone
// TODO: (prosze jedynie trzymac sie dokumentacji zawartej w interfejsie BankOperation)
class Bank implements BankOperation {

    private int accountNumber = 0;
    private Map<Integer, Integer> accounts = new HashMap<Integer, Integer>();

    public int createAccount() {
        int newAccountNumber = ++accountNumber;
        accounts.put(newAccountNumber, 0);
        return newAccountNumber;
    }

    public int deleteAccount(int accountNumber) {
        System.out.println(accounts.containsKey(accountNumber));
        if(accounts.containsKey(accountNumber)){
            int amount = accounts.get(accountNumber);
            accounts.remove(accountNumber);
            return amount;
        }

        return -1;
    }

    public boolean deposit(int accountNumber, int amount) {
        if(accounts.get(accountNumber) != null){
            if(amount <= 0){
                return false;
            }

            accounts.put(accountNumber, amount);
            return true;
        }
        return false;
    }

    public boolean withdraw(int accountNumber, int amount) {
        return false;
    }

    public boolean transfer(int fromAccount, int toAccount, int amount) {
        return false;
    }

    public int accountBalance(int accountNumber) {
        return 0;
    }

    public int sumAccountsBalance() {
        return 0;
    }
}
