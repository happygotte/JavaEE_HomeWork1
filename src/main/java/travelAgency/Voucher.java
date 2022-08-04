package travelAgency;

import travelAgency.api.Food;
import travelAgency.api.ITravelVoucher;
import travelAgency.api.Transport;

import java.util.Objects;

/**
 * The final price calculation class, which depends on the count of days,
 * the price of the type of transport and the type of food
 */
public class Voucher {
    private final ITravelVoucher voucher;
    private final int countOfDays;

    public Voucher(ITravelVoucher voucher, int countOfDays) {
        this.voucher = voucher;
        this.countOfDays = countOfDays;
    }

    public ITravelVoucher getVoucher() {
        return this.voucher;
    }

    public int getCountOfDays() {
        return this.countOfDays;
    }

    /**
     * Calculation of the price of transport depending on its type
     * @return the final transport price
     */
    public double transportPrice() {
        double price = 0;
        double pricePerDay = voucher.getPricePerDay();
        Transport transport = voucher.getTransport();
        if (transport == Transport.PLANE) {
            price = ((pricePerDay * 50) / 100);
        } else if (transport == Transport.TRAIN || transport == Transport.BUS) {
            price = ((pricePerDay * 10) / 100);
        } else if (transport == Transport.FERRY) {
            price = ((pricePerDay * 30) / 100);
        }
        return price;
    }

    /**
     * Calculation of the price of food depending on its type
     * @return the final food price
     */
    public double foodPrice() {
        double price = 0;
        double pricePerDay = voucher.getPricePerDay();
        Food food = voucher.getFood();
        if (food == Food.ALL_INCLUSIVE) {
            price = pricePerDay * 2;
        } else if (food == Food.HALF_BOARD) {
            price += (pricePerDay * 50) / 100;
        } else if (food == Food.BED_AND_BREAKFAST) {
            price += (pricePerDay * 10) / 100;
        }
        return price;
    }

    /**
     * Calculation of the final price of the voucher
     * @return the final price
     */
    public double getFinalPrice() {
        return ((voucher.getPricePerDay() +  foodPrice()) * countOfDays) + transportPrice();
    }

    @Override
    public String toString() {
        return voucher.toString() + ", count of days=" + countOfDays +
                ", finalPrice=" + getFinalPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voucher voucher1 = (Voucher) o;
        return countOfDays == voucher1.countOfDays && Objects.equals(voucher, voucher1.voucher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(voucher, countOfDays);
    }
}
