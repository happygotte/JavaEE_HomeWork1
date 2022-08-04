package travelAgency.vouchers;

import travelAgency.api.Food;
import travelAgency.api.ITravelVoucher;
import travelAgency.api.Transport;

/**
 * Food type are predefined
 */
public class WellnessVacation extends OneDayTrip implements ITravelVoucher {

    private Transport transport;

    public WellnessVacation(String name, Transport transport, double pricePerDay) {
        super(name, pricePerDay);
        this.transport = transport;
    }

    @Override
    public Transport getTransport() {
        return this.transport;
    }

    @Override
    public Food getFood() {
        return Food.HALF_BOARD;
    }

    @Override
    public double getPricePerDay() {
        return super.getPricePerDay();
    }

    @Override
    public String toString() {
        return "Wellness vacation '" + super.getName() + '\'' +
                ", transport=" + getTransport() +
                ", food=" + getFood() +
                ", price per day=" + getPricePerDay();
    }
}
