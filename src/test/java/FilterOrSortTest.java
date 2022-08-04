import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import travelAgency.Voucher;
import travelAgency.api.Food;
import travelAgency.api.Transport;
import travelAgency.tools.FilterOrSort;
import travelAgency.tools.comparators.CompByCountOfDays;
import travelAgency.tools.comparators.CompByName;
import travelAgency.tools.comparators.CompByPrice;
import travelAgency.tools.predicates.FilterByCountOfTheDay;
import travelAgency.tools.predicates.FilterByFood;
import travelAgency.tools.predicates.FilterByUpperPrice;
import travelAgency.tools.predicates.FilterByTransport;
import travelAgency.vouchers.Cruise;
import travelAgency.vouchers.OneDayTrip;
import travelAgency.vouchers.Tour;
import travelAgency.vouchers.WellnessVacation;

import java.util.ArrayList;
import java.util.List;

public class FilterOrSortTest {

    List<Voucher> vouchers = new ArrayList<>();
    FilterOrSort filtration = new FilterOrSort();

    Voucher cruise = new Voucher(new Cruise("По волнам Свислочи", Food.BED_AND_BREAKFAST,
            125), 5);
    Voucher wellnessVacation = new Voucher(new WellnessVacation("Садовое товарищество",
            Transport.PLANE, 500), 30);
    Voucher tour = new Voucher(new Tour("Цикл экскурсий по Чижовке", Transport.TRAIN,
            Food.ALL_INCLUSIVE, 100), 7);
    Voucher trip = new Voucher(new OneDayTrip("В Жлобин на закупы", 25), 1);


    @BeforeEach
    public void init(){
        vouchers.add(trip);
        vouchers.add(cruise);
        vouchers.add(wellnessVacation);
        vouchers.add(tour);
    }

    @Test
    public void testFilter(){
        List<Voucher> filtred = filtration.filter(vouchers, new FilterByUpperPrice(2000));
        List<Voucher> filtred1 = filtration.filter(vouchers, new FilterByUpperPrice(10));
        List<Voucher> filtred2 = filtration.filter(vouchers, new FilterByTransport(Transport.PLANE));
        List<Voucher> filtred3 = filtration.filter(vouchers, new FilterByTransport(Transport.TRAIN));
        List<Voucher> filtred4 = filtration.filter(vouchers, new FilterByTransport(Transport.BUS));
        List<Voucher> filtred5 = filtration.filter(vouchers, new FilterByTransport(Transport.FERRY));
        List<Voucher> filtred6 = filtration.filter(vouchers, new FilterByTransport(null));
        List<Voucher> filtred7 = filtration.filter(vouchers, new FilterByFood(Food.ALL_INCLUSIVE));
        List<Voucher> filtred8 = filtration.filter(vouchers, new FilterByFood(Food.ROOM_ONLY));
        List<Voucher> filtred9 = filtration.filter(vouchers, new FilterByFood(Food.BED_AND_BREAKFAST));
        List<Voucher> filtred10 = filtration.filter(vouchers, new FilterByFood(Food.HALF_BOARD));
        List<Voucher> filtred11 = filtration.filter(vouchers, new FilterByFood(null));
        List<Voucher> filtred12 = filtration.filter(vouchers, new FilterByCountOfTheDay(30));
        List<Voucher> filtred13 = filtration.filter(vouchers, new FilterByCountOfTheDay(0));
        List<Voucher> filtred14 = filtration.filter(vouchers, new FilterByCountOfTheDay(-5));

        Assertions.assertEquals(2, filtred.size());
        Assertions.assertEquals(0, filtred1.size());
        Assertions.assertEquals(1, filtred2.size());
        Assertions.assertEquals(1, filtred3.size());
        Assertions.assertEquals(1, filtred4.size());
        Assertions.assertEquals(1, filtred5.size());
        Assertions.assertEquals(0, filtred6.size());
        Assertions.assertEquals(1, filtred7.size());
        Assertions.assertEquals(1, filtred8.size());
        Assertions.assertEquals(1, filtred9.size());
        Assertions.assertEquals(1, filtred10.size());
        Assertions.assertEquals(0, filtred11.size());
        Assertions.assertEquals(1, filtred12.size());
        Assertions.assertEquals(0, filtred13.size());
        Assertions.assertEquals(0, filtred14.size());
    }

    @Test
    public void testSort(){

        filtration.sort(vouchers,new CompByCountOfDays());
        Assertions.assertEquals(trip, vouchers.get(0));
        Assertions.assertEquals(cruise, vouchers.get(1));
        Assertions.assertEquals(tour, vouchers.get(2));
        Assertions.assertEquals(wellnessVacation, vouchers.get(3));

        filtration.sort(vouchers, new CompByName());
        Assertions.assertEquals(trip, vouchers.get(0));
        Assertions.assertEquals(cruise, vouchers.get(1));
        Assertions.assertEquals(wellnessVacation, vouchers.get(2));
        Assertions.assertEquals(tour, vouchers.get(3));

        filtration.sort(vouchers, new CompByPrice());
        Assertions.assertEquals(trip, vouchers.get(0));
        Assertions.assertEquals(cruise, vouchers.get(1));
        Assertions.assertEquals(tour, vouchers.get(2));
        Assertions.assertEquals(wellnessVacation, vouchers.get(3));

    }

}
