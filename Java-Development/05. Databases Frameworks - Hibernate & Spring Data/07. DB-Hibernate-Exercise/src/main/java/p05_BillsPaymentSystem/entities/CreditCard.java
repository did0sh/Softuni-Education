package p05_BillsPaymentSystem.entities;

import sun.plugin.dom.exception.InvalidStateException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "credit_cards")
public class CreditCard extends BillingDetail {
    private String cardType;
    private int expirationMonth;
    private int expirationYear;

    @Column(name = "card_type", length = 30, nullable = false)
    public String getCardType() {
        return this.cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @Column(name = "expiration_month")
    public int getExpirationMonth() {
        return this.expirationMonth;
    }

    public void setExpirationMonth(int expirationMonth) {
        if (expirationMonth >= 1 && expirationMonth <= 12){
            this.expirationMonth = expirationMonth;
        } else {
            throw new InvalidStateException("Expiration month not valid");
        }
    }

    @Column(name = "expiration_year")
    public int getExpirationYear() {
        return this.expirationYear;
    }

    public void setExpirationYear(int expirationYear) {
        if (expirationYear >= 2018 && expirationYear <= 2028){
            this.expirationYear = expirationYear;
        } else {
            throw new InvalidStateException("Expiration year not valid");
        }
    }
}
