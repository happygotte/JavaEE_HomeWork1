package travelAgency.tools.comparators;

import travelAgency.Voucher;

import java.util.Comparator;

public class CompByName implements Comparator<Voucher> {

    @Override
    public int compare(Voucher o1, Voucher o2) {
        return o1.getVoucher().getName().compareTo(o2.getVoucher().getName());
    }
}
