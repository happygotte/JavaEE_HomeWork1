package travelAgency.tools.predicates;

import travelAgency.Voucher;

import java.util.function.Predicate;

public class FilterByUpperPrice implements Predicate<Voucher> {

    private final double price;

    public FilterByUpperPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean test(Voucher voucher) {
        return voucher.getFinalPrice() < price;
    }
}
