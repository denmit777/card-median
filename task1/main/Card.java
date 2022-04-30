package homework3.task1;

import java.math.BigDecimal;

public class Card {

    private String name;
    private BigDecimal balance;

    public Card(String name, BigDecimal balance) {
        this.name = name;
        this.balance = balance;
    }

    public Card(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        if (balance.compareTo(BigDecimal.valueOf(0)) < 0) {
            throw new IllegalArgumentException("Wrong enter");
        }
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Card{"
                + "name = " + name
                + ", balance = " + balance
                + '}';
    }

    /**
     * returns an account balance on card after refill account.
     *
     * @param sum  money deposited into the account.
     * @return newBalance - sum of initial balance and deposited money.

     */

    public BigDecimal refillAccount(BigDecimal sum) {
        BigDecimal newBalance = balance.add(sum);
        System.out.println("Your card balance has been replenished by " + sum + " rub. and is equal to:");
        return newBalance;
    }

    /**
     * returns an account balance on card after cash withdrawal.
     *
     * @param sum  money for withdraw.
     * @return balance after money withdrawal.
     * @throws IllegalArgumentException if balance is negative after cash withdrow.
     */

    public BigDecimal withdraw(BigDecimal sum) {
        if (balance.compareTo(sum) < 0) {
            throw new IllegalArgumentException("Not enough money to withdraw");
        } else {
            System.out.println("Account balance after withdraw:");
            return balance.subtract(sum);
        }
    }

    /**
     * returns curse of necessary currency against the Belarusian rub.
     *
     * @param currency  type of currency.
     * @return curse of necessary currency.
     */

    private BigDecimal getCurse(Currency currency) {
        switch (currency) {
            case DOLLAR:
                return new BigDecimal(2.5030);
            case EURO:
                return new BigDecimal(2.9341);
            case RUB_RF:
                return new BigDecimal(0.0341);
            default:
                System.out.println("There is no such a currency");
                return null;
        }
    }

    /**
     * returns balance in the currency we need
     *
     * @param currency  type of currency we need.
     * @return currencyBalance - balance of exchange.
     */

    public BigDecimal exchangeBalanceInfo(Currency currency) {
        BigDecimal currencyBalance = balance.divide(getCurse(currency), 3);
        System.out.println("Your card balance in currency terms is:");
        return currencyBalance;
    }
}
