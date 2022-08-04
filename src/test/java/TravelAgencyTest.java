import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import travelAgency.TravelAgency;
import travelAgency.Voucher;
import travelAgency.api.Food;
import travelAgency.api.Transport;
import travelAgency.vouchers.Cruise;
import travelAgency.vouchers.OneDayTrip;
import travelAgency.vouchers.Tour;
import travelAgency.vouchers.WellnessVacation;

public class TravelAgencyTest {

    Voucher trip = new Voucher(new OneDayTrip
            ("В Жлобин на закупы", 25), 1);
    Voucher cruise = new Voucher(new Cruise
            ("По волнам Свислочи", Food.BED_AND_BREAKFAST,125), 5);
    Voucher wellnessVacation = new Voucher(new WellnessVacation
            ("Садовое товарищество", Transport.PLANE, 500), 30);
    Voucher tour = new Voucher(new Tour
            ("Цикл экскурсий по Чижовке", Transport.TRAIN,Food.ALL_INCLUSIVE,
                    100), 7);
    @Test
    public void testAdd(){
        TravelAgency agency = new TravelAgency();

        agency.add(trip);
        agency.add(cruise);
        agency.add(wellnessVacation);
        agency.add(tour);

        Assertions.assertEquals(4, agency.getVouchers().size());
    }
}
