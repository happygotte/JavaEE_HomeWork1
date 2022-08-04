package travelAgency;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to create a collection of vouchers
 */
public class TravelAgency {

    private List<Voucher> vouchers;

    public TravelAgency() {
        this.vouchers = new ArrayList<>();
    }

    public void add(Voucher voucher){
        this.vouchers.add(voucher);
    }

    public List<Voucher> getVouchers() {
        return this.vouchers;
    }

}
