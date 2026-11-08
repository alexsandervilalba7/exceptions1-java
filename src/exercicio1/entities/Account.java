package exercicio1.entities;

import exercicio1.exceptions.BusinessException;

public class Account {

    private Integer number;
    private String Holder;
    private Double balance;
    private Double withdrawLimit;

    public Account() {
    }

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.Holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return Holder;
    }

    public void setHolder(String holder) {
        Holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(Double amount){
        balance += amount;
    }
    public void withdraw(Double amount){
        validateWithdraw(amount);
        balance -= amount;
    }
    private void validateWithdraw(double amount){
        if (amount > getWithdrawLimit()) {
            throw new BusinessException("Withdraw error: The amount exceeds withdraw limit");
        }
        if (amount > getBalance()) {
            throw new BusinessException("Withdraw error: Not enough balance");
        }
    }
}

