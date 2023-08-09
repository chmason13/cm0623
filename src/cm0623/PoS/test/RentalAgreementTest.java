package cm0623.PoS.test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import cm0623.PoS.main.PointOfSale;
import cm0623.PoS.main.Tool;
import cm0623.PoS.main.RentalAgreement;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RentalAgreementTest {
    RentalAgreement agreement;
    PointOfSale pos = new PointOfSale();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");

    @Test
    void testLADW() {
        try {
            agreement = pos.checkout("LADW", 3, 10, "7/2/2020");
        } catch (Exception e) {
            fail("Constructor failing due to invalid rental period or discount");
        }

        assertEquals(2, agreement.getChargeDays());
        assertEquals(3.98, agreement.getPreDiscountCharge());
        assertEquals(.40, agreement.getDiscountAmount());
        assertEquals(3.58, agreement.getFinalCharge());

        String receipt =
                "Tool code: LADW\n" +
                "Tool type: Ladder\n" +
                "Tool brand: Werner\n" +
                "Rental Days: 3\n" +
                "Checkout Date: 7/2/2020\n" +
                "Due Date: 7/5/2020\n" +
                "Daily Rental Charge: 1.99\n" +
                "Charge Days: 2\n" +
                "Pre-discount Charge: $3.98\n" +
                "Discount Percent: 10%\n" +
                "Discount Amount: $0.40\n" +
                "Final Charge: $3.58";
        assertEquals(receipt, agreement.toString());
    }

    @Test
    void testCHNS() {
        try {
            agreement = pos.checkout("CHNS", 5, 25, "7/2/2015");
        } catch (Exception e) {
            fail("Constructor failing due to invalid rental period or discount");
        }

        assertEquals(3, agreement.getChargeDays());
        assertEquals(4.47, agreement.getPreDiscountCharge());
        assertEquals(1.12, agreement.getDiscountAmount());
        assertEquals(3.35, agreement.getFinalCharge());

        String receipt =
                "Tool code: CHNS\n" +
                "Tool type: Chainsaw\n" +
                "Tool brand: Stihl\n" +
                "Rental Days: 5\n" +
                "Checkout Date: 7/2/2015\n" +
                "Due Date: 7/7/2015\n" +
                "Daily Rental Charge: 1.49\n" +
                "Charge Days: 3\n" +
                "Pre-discount Charge: $4.47\n" +
                "Discount Percent: 25%\n" +
                "Discount Amount: $1.12\n" +
                "Final Charge: $3.35";
        assertEquals(receipt, agreement.toString());
    }

    @Test
    void testJAKD() {
        try {
            agreement = pos.checkout("JAKD", 6, 0, "9/3/2015");
        } catch (Exception e) {
            fail("Constructor failing due to invalid rental period or discount");
        }

        assertEquals(3, agreement.getChargeDays());
        assertEquals(8.97, agreement.getPreDiscountCharge());
        assertEquals(0, agreement.getDiscountAmount());
        assertEquals(8.97, agreement.getFinalCharge());

        String receipt =
                "Tool code: JAKD\n" +
                "Tool type: Jackhammer\n" +
                "Tool brand: DeWalt\n" +
                "Rental Days: 6\n" +
                "Checkout Date: 9/3/2015\n" +
                "Due Date: 9/9/2015\n" +
                "Daily Rental Charge: 2.99\n" +
                "Charge Days: 3\n" +
                "Pre-discount Charge: $8.97\n" +
                "Discount Percent: 0%\n" +
                "Discount Amount: $0.00\n" +
                "Final Charge: $8.97";
        assertEquals(receipt, agreement.toString());
    }

    @Test
    void testJAKR1() {
        try {
            agreement = pos.checkout("JAKR", 5, 10, "9/3/2015");
        } catch (Exception e) {
            fail("Constructor failing due to invalid rental period or discount");
        }

        assertEquals(2, agreement.getChargeDays());
        assertEquals(5.98, agreement.getPreDiscountCharge());
        assertEquals(.6, agreement.getDiscountAmount());
        assertEquals(5.38, agreement.getFinalCharge());

        String receipt =
                "Tool code: JAKR\n" +
                "Tool type: Jackhammer\n" +
                "Tool brand: Ridgid\n" +
                "Rental Days: 5\n" +
                "Checkout Date: 9/3/2015\n" +
                "Due Date: 9/8/2015\n" +
                "Daily Rental Charge: 2.99\n" +
                "Charge Days: 2\n" +
                "Pre-discount Charge: $5.98\n" +
                "Discount Percent: 10%\n" +
                "Discount Amount: $0.60\n" +
                "Final Charge: $5.38";
        assertEquals(receipt, agreement.toString());
    }

    @Test
    void testJAKR2() {
        try {
            agreement = pos.checkout("JAKR", 9, 0, "7/2/2015");
        } catch (Exception e) {
            fail("Constructor failing due to invalid rental period or discount");
        }

        assertEquals(5, agreement.getChargeDays());
        assertEquals(14.95, agreement.getPreDiscountCharge());
        assertEquals(0, agreement.getDiscountAmount());
        assertEquals(14.95, agreement.getFinalCharge());

        String receipt =
                "Tool code: JAKR\n" +
                "Tool type: Jackhammer\n" +
                "Tool brand: Ridgid\n" +
                "Rental Days: 9\n" +
                "Checkout Date: 7/2/2015\n" +
                "Due Date: 7/11/2015\n" +
                "Daily Rental Charge: 2.99\n" +
                "Charge Days: 5\n" +
                "Pre-discount Charge: $14.95\n" +
                "Discount Percent: 0%\n" +
                "Discount Amount: $0.00\n" +
                "Final Charge: $14.95";
        assertEquals(receipt, agreement.toString());
    }

    @Test
    void testJAKR3() {
        try {
            agreement = pos.checkout("JAKR", 4, 50, "7/2/2020");
        } catch (Exception e) {
            fail("Constructor failing due to invalid rental period or discount");
        }

        assertEquals(1, agreement.getChargeDays());
        assertEquals(2.99, agreement.getPreDiscountCharge());
        assertEquals(1.5, agreement.getDiscountAmount());
        assertEquals(1.49, agreement.getFinalCharge());

        String receipt =
                "Tool code: JAKR\n" +
                "Tool type: Jackhammer\n" +
                "Tool brand: Ridgid\n" +
                "Rental Days: 4\n" +
                "Checkout Date: 7/2/2020\n" +
                "Due Date: 7/6/2020\n" +
                "Daily Rental Charge: 2.99\n" +
                "Charge Days: 1\n" +
                "Pre-discount Charge: $2.99\n" +
                "Discount Percent: 50%\n" +
                "Discount Amount: $1.50\n" +
                "Final Charge: $1.49";
        assertEquals(receipt, agreement.toString());
    }
}
