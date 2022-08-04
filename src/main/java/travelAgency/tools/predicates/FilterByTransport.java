package travelAgency.tools.predicates;

import travelAgency.Voucher;
import travelAgency.api.Transport;

import java.util.Objects;
import java.util.function.Predicate;

public class FilterByTransport implements Predicate<Voucher> {

    private final Transport transport;

    public FilterByTransport(Transport transport) {
        this.transport = transport;
    }

    @Override
    public boolean test(Voucher voucher) {
        return Objects.equals(voucher.getVoucher().getTransport(), transport);
    }
}
