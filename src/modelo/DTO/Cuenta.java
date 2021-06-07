package modelo.DTO;



import java.util.Date;

public class Cuenta {
    private String id;
    private String iban;
    private String creditCard;
    private Double balance;
    private String fullName;
    private Date date;

    public Cuenta(String id, String iban, String creditCard, Double balance, String fullName, Date date) {
        this.id = id;
        this.iban = iban;
        this.creditCard = creditCard;
        this.balance = balance;
        this.fullName = fullName;
        this.date = date;
    }

    public Cuenta(String iban, String creditCard, Double balance, String fullName, Date date) {
        this.iban = iban;
        this.creditCard = creditCard;
        this.balance = balance;
        this.fullName = fullName;
        this.date = date;
    }

    public String getId() {
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

    public Date getDate() {
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

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("Cuenta: %s,%s,%s, %.2f, %s, %s", id, iban, creditCard, balance, fullName, date.toString());
    }
}
