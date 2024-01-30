package hotelReservation;

public class PriceCalculator {

    public static double calculatePrice(double pricePerDay, int days, Season season, DiscountType discountType) {
        double priceForAllDays = days * pricePerDay;
        priceForAllDays *= season.getCoeff();
        priceForAllDays = priceForAllDays - (priceForAllDays * discountType.getDiscount() / 100);
        return priceForAllDays;
    }
}
