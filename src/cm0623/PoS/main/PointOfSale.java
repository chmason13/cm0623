package cm0623.PoS.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.TreeSet;

public class PointOfSale {
    TreeSet rentalAgreements = new TreeSet(new Comparator() {
        public int compare(Object o1, Object o2) {
            RentalAgreement agreement1 = (RentalAgreement)o1;
            LocalDate checkoutDate1 = agreement1.getCheckoutDate();
            LocalDate dueDate1 = agreement1.getDueDate();
            RentalAgreement agreement2 = (RentalAgreement)o2;
            LocalDate checkoutDate2 = agreement2.getCheckoutDate();
            LocalDate dueDate2 = agreement2.getDueDate();
            int result = checkoutDate1.compareTo(checkoutDate2);

            if (result == 0) {
                result = dueDate1.compareTo(dueDate2);
            }

            return result;
        }
    });

    public RentalAgreement checkout(String toolCode, int rentalDayCount, int discountPercentage, String checkoutDate) throws Exception {
        if (rentalDayCount < 1) {
            throw new Exception("Invalid rental day count");
        } else if (discountPercentage < 0 || discountPercentage > 100) {
            throw new Exception("Invalid discount rate");
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
            LocalDate checkout = LocalDate.parse(checkoutDate, formatter);
            RentalAgreement agreement = new RentalAgreement(toolCode, rentalDayCount, discountPercentage, checkout);
            rentalAgreements.add(agreement);

            return agreement;
        }
    }

}
