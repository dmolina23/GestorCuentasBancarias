package modelo.DTO;



import org.bson.types.ObjectId;

import java.util.Date;

public class Cuenta {
    private ObjectId id;
    private String iban;
    private String creditCard;
    private Double balance;
    private String fullName;
    private String date;

    public Cuenta(ObjectId id, String iban, String creditCard, Double balance, String fullName, String date) {
        this.id = id;
        this.iban = iban;
        this.creditCard = creditCard;
        this.balance = balance;
        this.fullName = fullName;
        this.date = date;
    }

    public Cuenta(String iban, String creditCard, Double balance, String fullName, String date) {
        this.iban = iban;
        this.creditCard = creditCard;
        this.balance = balance;
        this.fullName = fullName;
        this.date = date;
    }

    public ObjectId getId() {
        return id;
    }

    public String getIban() {
        return iban;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public Double getBalance() {
        return balance;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDate() {
        return date;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("Cuenta: %s,%s,%s, %.2f, %s, %s", id, iban, creditCard, balance, fullName, date.toString());
    }
}
