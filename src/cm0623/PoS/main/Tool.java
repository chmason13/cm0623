package cm0623.PoS.main;

public class Tool {
    public enum ToolCode {
        CHNS,
        LADW,
        JAKD,
        JAKR
    }

    private ToolCode toolCode;
    private String toolType;
    private String toolBrand;
    private double rate;
    private boolean weekendCharge;
    private boolean holidayCharge;

    public Tool(String toolCode) {
        this.toolCode = ToolCode.valueOf(toolCode);

        switch(this.toolCode) {
            case CHNS:
                this.toolType = "Chainsaw";
                this.toolBrand = "Stihl";
                this.rate = 1.49;
                this.weekendCharge = false;
                this.holidayCharge = true;
                break;
            case LADW:
                this.toolType = "Ladder";
                this.toolBrand = "Werner";
                this.rate = 1.99;
                this.weekendCharge = true;
                this.holidayCharge = false;
                break;
            case JAKD:
                this.toolType = "Jackhammer";
                this.toolBrand = "DeWalt";
                this.rate = 2.99;
                this.weekendCharge = false;
                this.holidayCharge = false;
                break;
            case JAKR:
                this.toolType = "Jackhammer";
                this.toolBrand = "Ridgid";
                this.rate = 2.99;
                this.weekendCharge = false;
                this.holidayCharge = false;
                break;
        }
    }

    public ToolCode getToolCode() {
        return this.toolCode;
    }

    public String getToolType() {
        return this.toolType;
    }

    public String getToolBrand() {
        return this.toolBrand;
    }

    public double getRate() {
        return rate;
    }

    public boolean getWeekendCharge() {
        return this.weekendCharge;
    }

    public boolean getHolidayCharge() {
        return this.holidayCharge;
    }

    public String toString() {
        StringBuilder tool = new StringBuilder();
        tool.append("Tool code: ");
        tool.append(this.toolCode);
        tool.append("\nTool type: ");
        tool.append(this.toolType);
        tool.append("\nTool brand: ");
        tool.append(this.toolBrand);

        return tool.toString();
    }
}
