package homework3.task1;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class CardTest {

    private Card cardWithBalance = new Card("Vasilkov", new BigDecimal(694));
    private Card cardWithoutBalance = new Card("Ivanov");

    @Test
    public void testToStringForCardWithBalance() {
        String actual = cardWithBalance.toString();
        String expected = "Card{"
                + "name = " + cardWithBalance.getName()
                + ", balance = " + cardWithBalance.getBalance()
                + '}';
        assertEquals(expected, actual);
    }

    @Test
    public void testToStringForCardWithoutBalance() {
        String actual = cardWithoutBalance.toString();
        String expected = "Card{"
                + "name = " + cardWithoutBalance.getName()
                + ", balance = " + null
                + '}';
        assertEquals(expected, actual);
    }

    @Test
    public void testRefillAccount_ForCardWithBalance() {
        BigDecimal sumOfRefill = new BigDecimal(164);
        BigDecimal actual = cardWithBalance.refillAccount(sumOfRefill);
        BigDecimal expected = new BigDecimal(858);
        assertEquals(expected, actual);
    }

    @Test
    public void testRefillAccount_ForCardWithBalance_IfBalanceIsZero() {
        BigDecimal sumOfRefill = new BigDecimal(0);
        BigDecimal actual = cardWithBalance.refillAccount(sumOfRefill);
        BigDecimal expected = new BigDecimal(694);
        assertEquals(expected, actual);
    }

    @Test
    public void testRefillAccount_ForCardWithoutBalance() {
        cardWithoutBalance.setBalance(new BigDecimal(974));
        BigDecimal sumOfRefill = new BigDecimal(164);
        BigDecimal actual = cardWithoutBalance.refillAccount(sumOfRefill);
        BigDecimal expected = new BigDecimal(1138);
        assertEquals(expected, actual);
    }

    @Test
    public void testRefillAccountForCardWithoutBalance__IfSumOfRefillIsZero() {
        cardWithoutBalance.setBalance(new BigDecimal(814));
        BigDecimal sumOfRefill = new BigDecimal(0);
        BigDecimal actual = cardWithoutBalance.refillAccount(sumOfRefill);
        BigDecimal expected = new BigDecimal(814);
        assertEquals(expected, actual);
    }

    @Test
    public void testWithdraw_ForCardWithBalance() {
        BigDecimal sumOfWithdraw = new BigDecimal(295);
        BigDecimal actual = cardWithBalance.withdraw(sumOfWithdraw);
        BigDecimal expected = new BigDecimal(399);
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdraw_ForCardWithBalanceNegative_IfBalanceLessSumOfWithdraw() {
        BigDecimal sumOfWithdraw = new BigDecimal(917);
        BigDecimal actual = cardWithBalance.withdraw(sumOfWithdraw);
    }

    @Test
    public void testWithdraw_ForCardWithoutBalance_IfSumOfWithdrawEqualsBalance() {
        cardWithoutBalance.setBalance(new BigDecimal(1000));
        BigDecimal sumOfWithdraw = new BigDecimal(1000);
        BigDecimal actual = cardWithoutBalance.withdraw(sumOfWithdraw);
        BigDecimal expected = new BigDecimal(0);
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdraw_ForCardWithoutBalanceNegative_IfBalanceEqualsZero() {
        cardWithoutBalance.setBalance(new BigDecimal(0));
        BigDecimal sumOfWithdraw = new BigDecimal(250);
        BigDecimal actual = cardWithoutBalance.withdraw(sumOfWithdraw);
    }

    @Test
    public void testExchangeBalanceInfo_ForCardWithBalance_InDollars() {
        BigDecimal actual = cardWithBalance.exchangeBalanceInfo(Currency.DOLLAR);
        BigDecimal expected = new BigDecimal(277);
        assertEquals(expected, actual);
    }

    @Test
    public void testExchangeBalanceInfo_ForCardWithBalance_InEuro() {
        BigDecimal actual = cardWithBalance.exchangeBalanceInfo(Currency.EURO);
        BigDecimal expected = new BigDecimal(236);
        assertEquals(expected, actual);
    }

    @Test
    public void testExchangeBalanceInfo_ForCardWithBalance_InRubRF() {
        BigDecimal actual = cardWithBalance.exchangeBalanceInfo(Currency.RUB_RF);
        BigDecimal expected = new BigDecimal(20351);
        assertEquals(expected, actual);
    }

    @Test
    public void testExchangeBalanceInfo_ForCardWithoutBalance_InDollars() {
        cardWithoutBalance.setBalance(new BigDecimal(1450));
        BigDecimal actual = cardWithoutBalance.exchangeBalanceInfo(Currency.DOLLAR);
        BigDecimal expected = new BigDecimal(579);
        assertEquals(expected, actual);
    }

    @Test
    public void testExchangeBalanceInfo_ForCardWithoutBalance_InEuro_IfBalanceIsZero() {
        cardWithoutBalance.setBalance(new BigDecimal(0));
        BigDecimal actual = cardWithoutBalance.exchangeBalanceInfo(Currency.EURO);
        BigDecimal expected = new BigDecimal(0);
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExchangeBalanceInfoNegative_ForCardWithoutBalance_InRubRF_IfBalanceIsNegative() {
        cardWithoutBalance.setBalance(new BigDecimal(-120));
        BigDecimal actual = cardWithoutBalance.exchangeBalanceInfo(Currency.RUB_RF);
    }
}
