import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import travelAgency.Voucher;
import travelAgency.api.Food;
import travelAgency.api.Transport;
import travelAgency.vouchers.Cruise;
import travelAgency.vouchers.OneDayTrip;
import travelAgency.vouchers.Tour;
import travelAgency.vouchers.WellnessVacation;

public class VoucherTest {

    Voucher trip = new Voucher(new OneDayTrip
            ("В Жлобин на закупы", 25), 1);
    Voucher cruise = new Voucher(new Cruise
            ("По волнам Свислочи", Food.BED_AND_BREAKFAST,125), 5);
    Voucher wellnessVacation = new Voucher(new WellnessVacation
            ("Садовое товарищество",Transport.PLANE, 500), 30);
    Voucher tour = new Voucher(new Tour
            ("Цикл экскурсий по Чижовке", Transport.TRAIN,Food.ALL_INCLUSIVE,
                    100), 7);
    @Test
    public void testTransportPrice(){
        Assertions.assertEquals(2.5,trip.transportPrice());
        Assertions.assertEquals(37.5,cruise.transportPrice());
        Assertions.assertEquals(250,wellnessVacation.transportPrice());
        Assertions.assertEquals(10,tour.transportPrice());
    }

    @Test
    public void testFoodPrice(){
        Assertions.assertEquals(0,trip.foodPrice());
        Assertions.assertEquals(12.5,cruise.foodPrice());
        Assertions.assertEquals(250,wellnessVacation.foodPrice());
        Assertions.assertEquals(200,tour.foodPrice());
    }

    @Test
    public void testGetFinalPrice(){
        Assertions.assertEquals(27.5,trip.getFinalPrice());
        Assertions.assertEquals(725,cruise.getFinalPrice());
        Assertions.assertEquals(22750,wellnessVacation.getFinalPrice());
        Assertions.assertEquals(2110,tour.getFinalPrice());
    }
}
