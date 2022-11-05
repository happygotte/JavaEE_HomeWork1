package travelAgency.tools;

import travelAgency.Voucher;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * Class for filtering or sorting the elements of the voucher collection depending on the request
 */
public class VoucherService {

    /**
     * Filtering by passed attribute
     * @param vouchers collection of vouchers
     * @param someFilter predicate
     * @return filtered collection of vouchers or null
     */
    public List<Voucher> filter(List<Voucher> vouchers, Predicate<Voucher> someFilter) {
        List<Voucher> filter = new ArrayList<>();
        for (Voucher voucher : vouchers) {
            if(someFilter.test(voucher)) {
                filter.add(voucher);
            }
        }
        return filter;
    }

    /**
     * Sorting by passed attribute
     * @param vouchers collection of vouchers
     * @param comparator comparator
     */
    public void sort(List<Voucher> vouchers, Comparator<Voucher> comparator){
        vouchers.sort(comparator);
    }


}
