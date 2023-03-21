package Entities;

public class Article {
    private int reference;
    private String name;
    private float price;

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String toString(){
        return String.format("REF : %d, NAME : %s, PRICE : $%.2f", this.getReference(), this.getName(), this.getPrice());
    }
}
