package com.vsp.Mix.Tests.EInsurance.LensOptions;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: scotli
 * Date: 6/13/13
 * Time: 2:29 PM
 *
 * This class is responsible for parsing the excel file that contains the lens style update
 * This class takes in a File representing the excel file to parse. It then opens the file
 * and finds the relevant sections saving each to an ArrayList of TestRows.
 */
public class XLSParser {

    private static Log log = LogFactory.getLog(LensOptionsTests.class);

    private Workbook book;
    private File excelFile;
    private List<TestRow> additions;
    private List<TestRow> deactivations;
    private List<TestRow> changes;
    private List<TestRow> iofAdditions;
    private List<TestRow> iofDeactivations;
    private List<TestRow> iofChanges;
    private List<TestRow> arAdditions;
    private List<TestRow> arDeactivations;
    private List<TestRow> arChanges;
    private List<TestRow> optionServiceDeactivations;
    private List<TestRow> scratchCoatingActivations;

    public XLSParser(String filename, int sheetNum) {

        this.additions = new ArrayList<TestRow>();
        this.deactivations = new ArrayList<TestRow>();
        this.changes = new ArrayList<TestRow>();
        this.iofAdditions = new ArrayList<TestRow>();
        this.iofDeactivations = new ArrayList<TestRow>();
        this.iofChanges = new ArrayList<TestRow>();
        this.arAdditions = new ArrayList<TestRow>();
        this.arDeactivations = new ArrayList<TestRow>();
        this.arChanges = new ArrayList<TestRow>();
        this.optionServiceDeactivations = new ArrayList<TestRow>();
        this.scratchCoatingActivations = new ArrayList<TestRow>();


        excelFile = new File(filename);
       // excelFile = new File("C:\\Carls Documents\\eclipse_workspace\\iDrTestFW\\LSUOneRow.xlsx");
        String ext = FilenameUtils.getExtension(filename);
        if (ext.equals("xlsx")) {
            xlsx(sheetNum);
        } else {
            xls(sheetNum);
        }
    }

    private void xlsx(int sheetNum) {

        try {
            FileInputStream file = new FileInputStream(excelFile);
            book = new XSSFWorkbook(file);
            file.close();
            Sheet sheet = book.getSheetAt(sheetNum);

            parse(sheet);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void xls(int sheetNum) {

        try {
            FileInputStream file = new FileInputStream(excelFile);
            book = new HSSFWorkbook(file);
            Sheet sheet = book.getSheetAt(sheetNum);

            parse(sheet);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parse(Sheet sheet) {
        //        for (Row row : sheet) {
        String finishing = "Lab Finishing";
        List<TestRow> currentSection = this.additions;
        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next();
        rowIterator.next();
        rowIterator.next();
        rowIterator.next();
        while (rowIterator.hasNext()) {

            Row row = rowIterator.next();
            // check the first cell to see if its a new section.
            Cell firstCell = row.getCell(0, org.apache.poi.ss.usermodel.Row.CREATE_NULL_AS_BLANK);
            log.debug(String.format("%s %s", firstCell, firstCell.getCellType() == Cell.CELL_TYPE_STRING));
            if (firstCell.getCellType() == Cell.CELL_TYPE_STRING) {
                log.debug(String.format("%d : %s", firstCell.getStringCellValue().length(), firstCell.getStringCellValue()));
                if (firstCell.getStringCellValue().length() == 0) {
                    continue;
                } else if (firstCell.getStringCellValue().matches("(?i)Lens Additions:(?-i)")) {
                    currentSection = this.additions;
                    finishing = "Lab Finishing";
                    continue;
                } else if (firstCell.getStringCellValue().matches("(?i)Lens Deactivations:(?-i)")) {
                    currentSection = this.deactivations;
                    finishing = "Lab Finishing";
                    continue;
                } else if (firstCell.getStringCellValue().matches("(?i)Lens Changes:(?-i)")) {
                    currentSection = this.changes;
                    finishing = "Lab Finishing";
                    continue;
                } else if (firstCell.getStringCellValue().matches("(?i)Stock Lens Additions:(?-i)")) {
                    currentSection = this.iofAdditions;
                    finishing = "In-Office Stock Lenses";
                    continue;
                } else if (firstCell.getStringCellValue().matches("(?i)Stock Lens Deactivations:(?-i)")) {
                    currentSection = this.iofDeactivations;
                    finishing = "In-Office Stock Lenses";
                    continue;
                } else if (firstCell.getStringCellValue().matches("(?i)Stock Lens Changes:(?-i)")) {
                    currentSection = this.iofChanges;
                    finishing = "In-Office Stock Lenses";
                    continue;
                } else if (firstCell.getStringCellValue().matches("(?i)AR Coating Additions:(?-i)")) {
                    currentSection = this.arAdditions;
                    finishing = "Lab Finishing";
                    continue;
                } else if (firstCell.getStringCellValue().matches("(?i)AR Coating Deactivations:(?-i)")) {
                    currentSection = this.arDeactivations;
                    finishing = "Lab Finishing";
                    continue;
                } else if (firstCell.getStringCellValue().matches("(?i)AR Coating Changes:(?-i)")) {
                    currentSection = this.arChanges;
                    finishing = "Lab Finishing";
                    continue;
                } else if (firstCell.getStringCellValue().matches("(?i)Option Service Deactivations:(?-i)")) {
                    currentSection = this.optionServiceDeactivations;
                    continue;
                } else if (firstCell.getStringCellValue().matches("(?i)Scratch Coating Additions:(?-i)")) {
                    currentSection = this.scratchCoatingActivations;
                    if (rowIterator.next().getCell(0, org.apache.poi.ss.usermodel.Row.CREATE_NULL_AS_BLANK).getStringCellValue().length() == 0 ||
                            rowIterator.next().getCell(0, org.apache.poi.ss.usermodel.Row.CREATE_NULL_AS_BLANK).getStringCellValue().matches("(?i)N/A(?-i)")) {
                        break;
                    } else {
                        continue;
                    }
                }

                if (row.getCell(0).getStringCellValue().matches("(?i)N/A(?-i)") ||
                        row.getCell(0).getStringCellValue().matches("\\s*") ||
                        row.getCell(1) == null) {
                    continue;
                }
            }

            log.debug("New Row: ");
            if (currentSection != null && row.getLastCellNum() >= 14) {
                TestRow newTestRow = new TestRow(row, finishing);
                if (!newTestRow.getStyleCode().equals("")) {
                    currentSection.add(newTestRow);
                }
            }
        }
    }

    public List<TestRow> getAdditions() {
        return additions;
    }

    public List<TestRow> getDeactivations() {
        return deactivations;
    }

    public List<TestRow> getChanges() {
        return changes;
    }

    public List<TestRow> getIofAdditions() {
        return iofAdditions;
    }

    public List<TestRow> getIofDeactivations() {
        return iofDeactivations;
    }

    public List<TestRow> getIofChanges() {
        return iofChanges;
    }

    public List<TestRow> getArAdditions() {
        return arAdditions;
    }

    public List<TestRow> getArDeactivations() {
        return arDeactivations;
    }

    public List<TestRow> getArChanges() {
        return arChanges;
    }

    public List<TestRow> getOptionServiceDeactivations() {
        return optionServiceDeactivations;
    }
}