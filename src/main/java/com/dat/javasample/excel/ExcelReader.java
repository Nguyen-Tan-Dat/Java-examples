package com.dat.javasample.excel;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("20230804_Affected_Items_https_www_vinamilk_com_vn_.xlsx");
             Workbook workbook = WorkbookFactory.create(fis)) {
            int tt = 1;
            Sheet sheet = workbook.getSheetAt(0);
            List<Object[]> data = new ArrayList<>();
            int numRows = sheet.getLastRowNum() + 1;
            data.add(new Object[]{"I", "High"});
            for (int i = 0; i < numRows; i++) {
                Row row = sheet.getRow(i);
                Cell cell1 = row.getCell(0);
                if (cell1 != null) {
                    String Severity = "";
                    try {
                        Severity = sheet.getRow(i + 3).getCell(1).getStringCellValue();
                    } catch (Exception e) {
                    }
                    if (Severity.equals("High")) {
                        String url = sheet.getRow(i + 1).getCell(0).getStringCellValue();
                        String site = url;
                        try {
                            site = WebTitleFetcher.getTitleFromUrl("https://www.vinamilk.com.vn" + url);
                            url = "https://www.vinamilk.com.vn" + url;
                        } catch (Exception e) {
                        }
                        String alert_group_title = sheet.getRow(i + 2).getCell(0).getStringCellValue();
                        String alert_group = sheet.getRow(i + 2).getCell(1).getStringCellValue();
                        String description_title = sheet.getRow(i + 4).getCell(0).getStringCellValue();
                        String description = sheet.getRow(i + 4).getCell(1).getStringCellValue();
                        String recommendationTitle = sheet.getRow(i + 5).getCell(0).getStringCellValue();
                        String recommendation = sheet.getRow(i + 5).getCell(1).getStringCellValue();
                        if (alert_group_title.equals("Alert group")
                                && description_title.equals("Description")
                                && recommendationTitle.equals("Recommendations")) {
                            data.add(new Object[]{tt++, url, site, description, alert_group, recommendation});
                        }
                    }
                }
            }
            data.add(new Object[]{"II", "Medium"});
            for (int i = 0; i < numRows; i++) {
                Row row = sheet.getRow(i);
                Cell cell1 = row.getCell(0);
                if (cell1 != null) {
                    String Severity = "";
                    try {
                        Severity = sheet.getRow(i + 3).getCell(1).getStringCellValue();
                    } catch (Exception e) {
                    }
                    if (Severity.equals("Medium")) {
                        String url = sheet.getRow(i + 1).getCell(0).getStringCellValue();
                        String site = url;
                        try {
                            site = WebTitleFetcher.getTitleFromUrl("https://www.vinamilk.com.vn" + url);
                            url = "https://www.vinamilk.com.vn" + url;
                        } catch (Exception e) {
                        }
                        String alert_group_title = sheet.getRow(i + 2).getCell(0).getStringCellValue();
                        String alert_group = sheet.getRow(i + 2).getCell(1).getStringCellValue();
                        String description_title = sheet.getRow(i + 4).getCell(0).getStringCellValue();
                        String description = sheet.getRow(i + 4).getCell(1).getStringCellValue();
                        String recommendationTitle = sheet.getRow(i + 5).getCell(0).getStringCellValue();
                        String recommendation = sheet.getRow(i + 5).getCell(1).getStringCellValue();
                        if (alert_group_title.equals("Alert group")
                                && description_title.equals("Description")
                                && recommendationTitle.equals("Recommendations")) {
                            data.add(new Object[]{tt++, url, site, description, alert_group, recommendation});
                        }
                    }
                }
            }
            data.add(new Object[]{"III", "Low"});
            for (int i = 0; i < numRows; i++) {
                Row row = sheet.getRow(i);
                Cell cell1 = row.getCell(0);
                if (cell1 != null) {
                    String Severity = "";
                    try {
                        Severity = sheet.getRow(i + 3).getCell(1).getStringCellValue();
                    } catch (Exception e) {
                    }
                    if (Severity.equals("Low")) {
                        String url = sheet.getRow(i + 1).getCell(0).getStringCellValue();
                        String site = url;
                        try {
                            site = WebTitleFetcher.getTitleFromUrl("https://www.vinamilk.com.vn" + url);
                            url = "https://www.vinamilk.com.vn" + url;
                        } catch (Exception e) {
                        }
                        String alert_group_title = sheet.getRow(i + 2).getCell(0).getStringCellValue();
                        String alert_group = sheet.getRow(i + 2).getCell(1).getStringCellValue();
                        String description_title = sheet.getRow(i + 4).getCell(0).getStringCellValue();
                        String description = sheet.getRow(i + 4).getCell(1).getStringCellValue();
                        String recommendationTitle = sheet.getRow(i + 5).getCell(0).getStringCellValue();
                        String recommendation = sheet.getRow(i + 5).getCell(1).getStringCellValue();
                        if (alert_group_title.equals("Alert group")
                                && description_title.equals("Description")
                                && recommendationTitle.equals("Recommendations")) {
                            data.add(new Object[]{tt++, url, site, description, alert_group, recommendation});
                        }
                    }
                }
            }
            exportToExcel(data, "data.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void exportToExcel(List<Object[]> dataToExport, String filePath) {
        try (Workbook workbook = WorkbookFactory.create(true);
             FileOutputStream fos = new FileOutputStream(filePath)) {
            // Tạo một bảng mới trong workbook
            Sheet sheet = workbook.createSheet("Data");

            // Tạo một cell style cho header (dòng tiêu đề)
            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
            headerStyle.setWrapText(true);
            int rowIndex = 0;
            for (Object[] rowData : dataToExport) {
                Row row = sheet.createRow(rowIndex++);
                int cellIndex = 0;
                for (Object cellValue : rowData) {
                    Cell cell = row.createCell(cellIndex++);
                    if (cellValue instanceof Number) {
                        // Nếu giá trị là số, ghi giá trị số vào ô
                        cell.setCellValue(((Number) cellValue).doubleValue());
                    } else {
                        // Nếu giá trị không phải là số, ghi giá trị dưới dạng chuỗi vào ô
                        cell.setCellValue(String.valueOf(cellValue));
                    }
                    // Áp dụng cell style cho dòng tiêu đề
                    if (rowIndex == 1) {
                        cell.setCellStyle(headerStyle);
                    }
                }
                // Định dạng chiều rộng của các ô cho vừa với nội dung

            }
            // Ghi dữ liệu vào file Excel
            workbook.write(fos);

            System.out.println("Dữ liệu đã được xuất ra file Excel thành công!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
