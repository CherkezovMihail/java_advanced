package hotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputData = scanner.nextLine().split(" ");

        double pricePerDay = Double.parseDouble(inputData[0]);
        int numberOfDays = Integer.parseInt(inputData[1]);
        Season season = Season.valueOf(inputData[2].toUpperCase());
        DiscountType discountType = DiscountType.valueOf(inputData[3].toUpperCase());

        double holidayPrice = PriceCalculator.calculatePrice(pricePerDay, numberOfDays, season, discountType);

        System.out.printf("%.2f%n", holidayPrice);

    }
}
