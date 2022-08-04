package travelAgency.vouchers;

import travelAgency.api.Food;
import travelAgency.api.ITravelVoucher;
import travelAgency.api.Transport;

/**
 * All properties can be set
 */
public class Tour extends Cruise implements ITravelVoucher  {

    private Transport transport;

    public Tour(String name, Transport transport, Food food, double pricePerDay) { //шоппинг, экскурсии, отдых
        super(name, food, pricePerDay);
        this.transport = transport;
    }

    @Override
    public Transport getTransport() {
        return this.transport;
    }

    @Override
    public String toString() {
        return "Tour '" + super.getName() + '\'' +
                ", transport=" + getTransport() +
                ", food=" + super.getFood() +
                ", price per day=" + super.getPricePerDay();
    }
}
