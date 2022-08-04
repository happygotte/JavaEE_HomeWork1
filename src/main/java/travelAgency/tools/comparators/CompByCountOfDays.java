package travelAgency.tools.comparators;

import travelAgency.Voucher;

import java.util.Comparator;

public class CompByCountOfDays implements Comparator<Voucher> {

    @Override
    public int compare(Voucher o1, Voucher o2) {
        if (o1.getCountOfDays() > o2.getCountOfDays()) {
            return 1;
        } else if (o1.getCountOfDays() < o2.getCountOfDays()) {
            return -1;
        } else {
            return 0;
        }
    }
}
