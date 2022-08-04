package travelAgency.vouchers;

import travelAgency.api.Food;
import travelAgency.api.ITravelVoucher;
import travelAgency.api.Transport;

/**
 * Transport type are predefined
 */
public class Cruise extends OneDayTrip implements ITravelVoucher {

    private Food food;

    public Cruise(String name, Food food, double pricePerDay) {
        super(name, pricePerDay);
        this.food = food;
    }

    @Override
    public Transport getTransport() {
        return Transport.FERRY;
    }

    @Override
    public Food getFood() {
        return this.food;
    }

    @Override
    public double getPricePerDay() {
        return super.getPricePerDay();
    }

    @Override
    public String toString() {
        return "Cruise '" + super.getName() + '\'' +
                ", transport=" + getTransport() +
                ", food=" + getFood() +
                ", price per day=" + getPricePerDay();
    }
}
