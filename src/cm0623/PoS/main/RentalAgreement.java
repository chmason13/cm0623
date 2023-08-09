package cm0623.PoS.main;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.DayOfWeek;


public class RentalAgreement {
    private Tool tool;
    private int rentalDays;
    private int chargeDays;
    private int discountPercentage;
    private double preDiscountCharge;
    private double discountAmount;
    private double finalCharge;
    private LocalDate checkoutDate;
    private LocalDate dueDate;

    public RentalAgreement(String toolCode, int rentalDays, int discountPercentage, LocalDate checkoutDate) throws Exception {
        this.checkoutDate = checkoutDate;
        this.tool = new Tool(toolCode);
        this.discountPercentage = discountPercentage;
        this.rentalDays = rentalDays;
        this.dueDate = this.checkoutDate.plusDays(rentalDays);
        this.chargeDays = this.calculateChargeDays(this.checkoutDate, this.dueDate, this.tool);
        this.preDiscountCharge = round(this.chargeDays * this.tool.getRate());
        this.discountAmount = round(this.preDiscountCharge * this.discountPercentage / 100);
        this.finalCharge = round(this.preDiscountCharge - this.discountAmount);
    }

    private int calculateChargeDays(LocalDate checkoutDate, LocalDate dueDate, Tool tool) {
        int chargeDays = 0;
        LocalDate independenceDay = LocalDate.of(checkoutDate.getYear(),7, 4);
        LocalDate laborDay = getLaborDay(checkoutDate.getYear());

        if (!tool.getHolidayCharge()) {
            if (laborDay.isAfter(checkoutDate) && laborDay.isBefore(dueDate.plusDays(1))) {
                chargeDays --;
            }

            if (independenceDay.isAfter(checkoutDate) && independenceDay.isBefore(dueDate.plusDays(1))) {
                switch (independenceDay.getDayOfWeek()) {
                    case SATURDAY:
                        if (independenceDay.minusDays(1).isAfter(checkoutDate)) {
                            chargeDays --;
                        }
                        break;
                    case SUNDAY:
                        if (independenceDay.plusDays(1).isBefore(dueDate.plusDays(1))) {
                            chargeDays --;
                        }
                        break;
                    default:
                        chargeDays --;
                }
            }
        }

        checkoutDate = checkoutDate.plusDays(1);

        while (checkoutDate.isBefore(dueDate.plusDays(1))) {
            switch(checkoutDate.getDayOfWeek()) {
                case SATURDAY:
                case SUNDAY:
                    if (tool.getWeekendCharge()) {
                        chargeDays ++;
                    }
                    break;
                default:
                    chargeDays ++;
            }

            checkoutDate = checkoutDate.plusDays(1);
        }

        return chargeDays;
    }

    private LocalDate getLaborDay(int year) {
        LocalDate tempDate = LocalDate.of(year, 9, 1);
        boolean done = false;

        while(!done) {
            if (tempDate.getDayOfWeek().equals(DayOfWeek.MONDAY)) {
                done = true;
            } else {
                tempDate = tempDate.plusDays(1);
            }
        }

        return tempDate;
    }

    private double round(double value) {
        BigDecimal roundedValue = new BigDecimal(Double.toString(value));
        roundedValue = roundedValue.setScale(2, RoundingMode.HALF_UP);

        return roundedValue.doubleValue();
    }

    public LocalDate getCheckoutDate() {
        return this.checkoutDate;
    }

    public LocalDate getDueDate() {
        return this.dueDate;
    }

    public Tool getTool() {
        return this.tool;
    }

    public int getChargeDays() {
        return this.chargeDays;
    }

    public double getPreDiscountCharge() {
        return this.preDiscountCharge;
    }

    public double getDiscountAmount() {
        return this.discountAmount;
    }

    public double getFinalCharge() {
        return this.finalCharge;
    }

    public String toString() {
        int checkoutMonth = this.checkoutDate.getMonthValue();
        int checkoutDay = this.checkoutDate.getDayOfMonth();
        int checkoutYear = this.checkoutDate.getYear();
        int dueDateMonth = this.dueDate.getMonthValue();
        int dueDateDay = this.dueDate.getDayOfMonth();
        int dueDateYear = this.dueDate.getYear();
        StringBuilder rentalAgreement = new StringBuilder();

        rentalAgreement.append(this.tool.toString());
        rentalAgreement.append("\nRental Days: " + this.rentalDays);
        rentalAgreement.append(String.format("\nCheckout Date: %d/%d/%d", checkoutMonth, checkoutDay, checkoutYear));
        rentalAgreement.append(String.format("\nDue Date: %d/%d/%d", dueDateMonth, dueDateDay, dueDateYear));
        rentalAgreement.append(String.format("\nDaily Rental Charge: %.2f",  this.tool.getRate()));
        rentalAgreement.append("\nCharge Days: " + this.chargeDays);
        rentalAgreement.append(String.format("\nPre-discount Charge: $%.2f", this.preDiscountCharge));
        rentalAgreement.append("\nDiscount Percent: " + this.discountPercentage + "%");
        rentalAgreement.append(String.format("\nDiscount Amount: $%.2f", this.discountAmount));
        rentalAgreement.append(String.format("\nFinal Charge: $%.2f", this.finalCharge));

        return rentalAgreement.toString();
    }


}
