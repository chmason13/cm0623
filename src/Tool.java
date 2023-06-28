public class Tool {
    enum ToolCode {
        CHNS,
        LADW,
        JAKD,
        JAKR
    }

    private ToolCode toolCode;
    private String toolType;
    private String toolBrand;
    private double rate;
    private boolean weekdayCharge;
    private boolean weekendCharge;
    private boolean holidayCharge;

    public Tool(String toolCode) {
        this.toolCode = ToolCode.valueOf(toolCode);

        if (this.toolCode == ToolCode.CHNS) {
            this.toolType = "Chainsaw";
            this.toolBrand = "Stihl";
            this.rate = 1.49;
            this.weekdayCharge = true;
            this.weekendCharge = false;
            this.holidayCharge = true;
        } else if (this.toolCode == ToolCode.LADW) {
            this.toolType = "Ladder";
            this.toolBrand = "Werner";
            this.rate = 1.99;
            this.weekdayCharge = true;
            this.weekendCharge = true;
            this.holidayCharge = false;
        } else if (this.toolCode == ToolCode.JAKD) {
            this.toolType = "Jackhammer";
            this.toolBrand = "DeWalt";
            this.rate = 2.99;
            this.weekdayCharge = true;
            this.weekendCharge = false;
            this.holidayCharge = false;
        } else {
            this.toolType = "Jackhammer";
            this.toolBrand = "Ridgid";
            this.rate = 2.99;
            this.weekdayCharge = true;
            this.weekendCharge = false;
            this.holidayCharge = false;
        }
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
