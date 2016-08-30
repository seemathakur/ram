package com.vsp.Mix.Tests.EInsurance.LensOptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

//import com.vsp.il.util.Preferences;

/**
 * Created with IntelliJ IDEA.
 * User: scotli
 * Date: 5/10/13
 * Time: 7:47 AM
 *
 * Updated for iDr framework / decouple from com.vsp.il.util.Preferences
 * by Carl Kidwell
 * Date: 8/15/2016
 *
 * This class receives a Row from the XLSParser and parses the Row to extract all the information relevant to to test
 * this lens style.
 */

public class TestRow {

    private Row row;
    private static final String LENS = "lens";

    private String finishing;
    private String styleCode;
    private String description;
    private String arDescription;
    private String material;
    private String visionType;
    private Map<String, Boolean> optionCodes;
    private List<String> optionCodesList;
    private String custom;

    public TestRow(String finishing, String visionType, String material) {
        this.finishing = finishing;
        this.visionType = visionType;
        this.material = material;
        styleCode = "Duplicate";
        description = "";
        arDescription = "";
        optionCodes = new HashMap<String, Boolean>();
        optionCodesList = new ArrayList<String>();
        custom = "";
    }

    public TestRow(Row row, String finishing) {
        this.row = row;
        //NOTE: Carl removed calls to com.vsp.il.Preferences and hard coded cell #'s for now
        // cell numbers can be observed by opening the lens option excel sheet and counting what row the item is on if it ever changes
        // TODO: Hack alert! This is slightly kludgey way to get the lens style code. And it doesn't even give the right text if it is a number.
        Cell cell = row.getCell(0, org.apache.poi.ss.usermodel.Row.CREATE_NULL_AS_BLANK);
        int cellType = cell.getCellType();
        this.finishing = finishing;
        this.styleCode = cellType == Cell.CELL_TYPE_STRING ? cell.getStringCellValue() : cellType == Cell.CELL_TYPE_NUMERIC ? Double.toString(cell.getNumericCellValue()) : "";
        //if its parsed as a double the string will probably have a decimal place so lets remove that.
        if (this.styleCode.indexOf('.') != -1) {
            this.styleCode = this.styleCode.substring(0, this.styleCode.indexOf('.'));
        }
        this.description = row.getCell((7), org.apache.poi.ss.usermodel.Row.CREATE_NULL_AS_BLANK).getStringCellValue().trim() + " - " + row.getCell((10), org.apache.poi.ss.usermodel.Row.CREATE_NULL_AS_BLANK).getStringCellValue().trim();
        this.arDescription = row.getCell((7), org.apache.poi.ss.usermodel.Row.CREATE_NULL_AS_BLANK).getStringCellValue().trim();
        //apparently sometimes the xls sheet will have a ':' in there and that should get removed
        this.description = this.description.replace(":", "");
        this.material = row.getCell((8), org.apache.poi.ss.usermodel.Row.CREATE_NULL_AS_BLANK).getStringCellValue().trim();
        this.visionType = row.getCell((9), org.apache.poi.ss.usermodel.Row.CREATE_NULL_AS_BLANK).getStringCellValue().trim();
        //sometimes the vision type has weird verbiage so this mapper can catch some of them and fix them.
        this.visionType = remap(this.visionType);
        this.optionCodesList = new ArrayList<String>(Arrays.asList(row.getCell((11), org.apache.poi.ss.usermodel.Row.CREATE_NULL_AS_BLANK).getStringCellValue().split(",")));
        this.optionCodes = new HashMap<String, Boolean>();
        for (String keyString : optionCodesList)
            optionCodes.put(keyString, false);
        this.custom = row.getCell((4), Row.CREATE_NULL_AS_BLANK).getStringCellValue().trim();
    }

    public Row getRow() {
        return row;
    }

    public String getCustom(){
        return custom;
    }

    public String getFinishing() {
        return finishing;
    }

    public String getStyleCode() {
        return styleCode;
    }

    public String getVisionType() {
        return visionType;
    }

    public String getMaterial() {
        return material;
    }

    public String getLensStyle() {
        return description;
    }

    public String getARDescription() {
        return arDescription;
    }

    public Map<String, Boolean> getOptionCodes() {
        return optionCodes;
    }

    @Override
    public String toString() {
        return
                styleCode + "," +
                        finishing + ", " +
                        visionType + "," +
                        material + "," +
                        description + "," +
                        optionCodesList.toString().replaceAll("\\s*,\\s*", " | ");
    }


    //##############################################################################
    // Combined VisionTypeMapper.class below with TestRow.class.
    // START VisionTypeMapper.class
    //#############################################################################

    public static String remap(String str) {

        if (str.contains("Single Vision")) {
            return "Single Vision";
        } else if (str.contains("Bifocal")) {
            return "Bifocal";
        } else if (str.contains("Trifocal")) {
            return "Trifocal";
        } else if (str.contains("Double")) {
            return "Double";
        } else if (str.contains("Progressive")) {
            return "Progressive";
        } else if (str.contains("Lenticular Single Vision") || str.contains("Lenticular SV")) {
            return "Lenticular Single Vision";
        } else if (str.contains("Lenticular Bifocal") || str.contains("Lenticular BF")) {
            return "Lenticular Bifocal";
        } else if (str.contains("Lenticular Trifocal")) {
            return "Lenticular Trifocal";
        } else if (str.contains("Quad")) {
            return "Quad";
        } else if (str.contains("Near Variable Focus")) {
            return "Near Variable Focus";
        }

        return str;
    }

//##############################################################################
// END VisionTypeMapper.class
//##############################################################################
}