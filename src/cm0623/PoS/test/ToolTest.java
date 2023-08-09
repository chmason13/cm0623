package cm0623.PoS.test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import cm0623.PoS.main.Tool;

import org.junit.jupiter.api.Test;

public class ToolTest {
    Tool tool;
    String toolStr;

    @Test
    void testCHNS() {
        try {
            toolStr = "Tool code: CHNS\nTool type: Chainsaw\nTool brand: Stihl";
            tool = new Tool("CHNS");
        } catch (Exception e) {
            fail("Constructor error on valid code");
        }

        assertEquals(tool.getToolCode(), Tool.ToolCode.CHNS);
        assertEquals(tool.getToolType(), "Chainsaw");
        assertEquals(tool.getToolBrand(), "Stihl");
        assertEquals(tool.getRate(), 1.49);
        assertFalse(tool.getWeekendCharge());
        assertTrue(tool.getHolidayCharge());
        assertEquals(tool.toString(), toolStr);
    }

    @Test
    void testLADW() {
        toolStr = "Tool code: LADW\nTool type: Ladder\nTool brand: Werner";
        tool = new Tool("LADW");

        assertEquals(tool.getToolCode(), Tool.ToolCode.LADW);
        assertEquals(tool.getToolType(), "Ladder");
        assertEquals(tool.getToolBrand(), "Werner");
        assertEquals(tool.getRate(), 1.99);
        assertTrue(tool.getWeekendCharge());
        assertFalse(tool.getHolidayCharge());
        assertEquals(tool.toString(), toolStr);
    }

    @Test
    void testJAKD() {
        toolStr = "Tool code: JAKD\nTool type: Jackhammer\nTool brand: DeWalt";
        tool = new Tool("JAKD");

        assertEquals(tool.getToolCode(), Tool.ToolCode.JAKD);
        assertEquals(tool.getToolType(), "Jackhammer");
        assertEquals(tool.getToolBrand(), "DeWalt");
        assertEquals(tool.getRate(), 2.99);
        assertFalse(tool.getWeekendCharge());
        assertFalse(tool.getHolidayCharge());
        assertEquals(tool.toString(), toolStr);
    }

    @Test
    void testJAKR() {
        toolStr = "Tool code: JAKR\nTool type: Jackhammer\nTool brand: Ridgid";
        tool = new Tool("JAKR");

        assertEquals(tool.getToolCode(), Tool.ToolCode.JAKR);
        assertEquals(tool.getToolType(), "Jackhammer");
        assertEquals(tool.getToolBrand(), "Ridgid");
        assertEquals(tool.getRate(), 2.99);
        assertFalse(tool.getWeekendCharge());
        assertFalse(tool.getHolidayCharge());
        assertEquals(tool.toString(), toolStr);
    }

    @Test()
    void testInvalidTool() {
        Throwable exception = assertThrows(Exception.class, () -> {
            tool = new Tool ("AAAA");
        });
    }
}
