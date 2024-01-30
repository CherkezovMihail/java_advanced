package hotelReservation;

public enum DiscountType {

    VIP(20),
    SECONDVISIT(10),
    NONE(0);

    int discount;

    DiscountType(int discount) {
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
