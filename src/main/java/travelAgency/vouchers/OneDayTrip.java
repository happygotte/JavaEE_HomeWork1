package travelAgency.vouchers;

import travelAgency.api.Food;
import travelAgency.api.ITravelVoucher;
import travelAgency.api.Transport;

/**
 * One day shopping trip, food type and transport type are predefined
 */
public class OneDayTrip implements ITravelVoucher {

    private final String name;
    private final double pricePerDay;

    public OneDayTrip(String name, double pricePerDay) {
        this.name = name;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Transport getTransport() {
        return Transport.BUS;
    }

    @Override
    public Food getFood() {
        return Food.ROOM_ONLY;
    }

    @Override
    public double getPricePerDay() {
        return this.pricePerDay;
    }

    @Override
    public String toString() {
        return "One day trip '" + getName() + '\'' +
                ", transport=" + getTransport() +
                ", food=" + getFood() +
                ", price per day=" + getPricePerDay();
    }
}
