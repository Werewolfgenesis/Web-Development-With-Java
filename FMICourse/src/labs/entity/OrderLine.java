package labs.entity;

import labs.vo.OrderLineStatus;

/**
 * Create OrderLine which holds information for:
 * Item, enum for status, boolean specialOffer and count
 * Implement setters/getters/constructor
 */
public class OrderLine {

    private Item item;
    private boolean specialOffer;
    private int count;
    private OrderLineStatus status;

    public OrderLine() {
        status = OrderLineStatus.WAITING_FOR_STOCK;
        item = new Item();
        specialOffer = false;
        count = 0;
    }

    public int getCount() {
        return count;
    }

    public OrderLineStatus getStatus() {
        return status;
    }

    public boolean isSpecialOffer() {
        return specialOffer;
    }

    public Item getItem() {
        return item;
    }
}
