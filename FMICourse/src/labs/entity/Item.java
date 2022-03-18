package labs.entity;

import java.math.BigDecimal;

/**
 * Implement Item with description:String and price:BigDecimal
 */

public class Item {
    private String description;
    private BigDecimal price;

    public Item(){
        this.description = "Default";
        this.price = BigDecimal.ZERO;
    }

    public Item(String description, BigDecimal price){
        this.description = description;
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Item{" +
                "description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
