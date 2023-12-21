package SeleniumHandsOn.Factories;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExcelReader {

    /**
     * prerequisite >> add apacha poi  and poi-ooxml  dependecies
     *
     */
    public static void main(String[] args) throws FileNotFoundException {
        excelUtils();
    }

    public static void excelUtils() throws FileNotFoundException {
        try (FileInputStream file = new FileInputStream("./test.xlsx")) {
            // Create Workbook instance for xlsx/xls file input stream
            Workbook workbook = new XSSFWorkbook(file);

            // Get the first sheet
            Sheet sheet = workbook.getSheetAt(0);

            // Iterate through each row
            for (Row row : sheet) {
                // Iterate through each cell in the row
                for (Cell cell : row) {
                    // Print the cell value
                    printCellvalue(cell);
//                    System.out.print(cell.toString() + "\t");
                }
                System.out.println(); // Move to the next line after each row
            }
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printCellvalue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING -> System.out.print(STR."\{cell.getStringCellValue()}\t");
            case NUMERIC -> System.out.print(STR."\{cell.getNumericCellValue()}\t");
            case BOOLEAN -> System.out.print(STR."\{cell.getBooleanCellValue()}\t");
            // Handle other cell types as needed
        }
    }
}
