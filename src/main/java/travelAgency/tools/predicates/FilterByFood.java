package travelAgency.tools.predicates;

import travelAgency.Voucher;
import travelAgency.api.Food;

import java.util.Objects;
import java.util.function.Predicate;

public class FilterByFood implements Predicate<Voucher> {

    private final Food food;

    public FilterByFood(Food food) {
        this.food = food;
    }

    @Override
    public boolean test(Voucher voucher) {
        return Objects.equals(voucher.getVoucher().getFood(), food);
    }
}
