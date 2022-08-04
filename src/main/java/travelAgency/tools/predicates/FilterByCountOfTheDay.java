package travelAgency.tools.predicates;

import travelAgency.Voucher;
import travelAgency.api.ITravelVoucher;

import java.util.function.Predicate;

public class FilterByCountOfTheDay implements Predicate<Voucher> {

    private final int count;

    public FilterByCountOfTheDay(int count) {
        this.count = count;
    }

    @Override
    public boolean test(Voucher voucher) {
        return voucher.getCountOfDays() == count;
    }
}
