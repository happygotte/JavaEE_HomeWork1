package travelAgency.tools.comparators;

import travelAgency.Voucher;

import java.util.Comparator;

public class CompByPrice implements Comparator<Voucher> {

    @Override
    public int compare(Voucher o1, Voucher o2) {
        return Double.compare(o1.getFinalPrice(), o2.getFinalPrice());
    }
}
