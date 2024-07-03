package data;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelReader {
    private String fileName;

    public ExcelReader(String fileName) {
        this.fileName = fileName;
    }

    public Map<String,String> readExcelFile(String id) {
        Map<String,String> map = new HashMap<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0); // gets first sheet
            for (Row row : sheet) {
                for (Cell cell : row) {
                    if (cell.getRowIndex() > 0 && cell.getColumnIndex() > 0 && sheet.getRow(cell.getRowIndex()).getCell(0).toString().equals(id)){
                        map.put(sheet.getRow(0).getCell(cell.getColumnIndex()).getStringCellValue(), cell.getStringCellValue());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
