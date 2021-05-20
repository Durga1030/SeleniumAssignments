package week5.day2.assignments;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelForData {

	@Test
	public static String[][] readExcel(String sheetName) throws InvalidFormatException, IOException {

		File excelFileName = new File("./data/Leads.xlsx"); // Excel File path

		XSSFWorkbook workbook = new XSSFWorkbook(excelFileName); // Get Work book

		// XSSFSheet sheet = workbook.getSheet("CreateLead");
		XSSFSheet sheet = workbook.getSheet(sheetName);// Get Work Sheet

		int rCount = sheet.getLastRowNum(); // Get Row Count

		int cCount = sheet.getRow(0).getLastCellNum(); // Get Column Count

		String[][] data = new String[rCount][cCount];

		for (int i = 1; i <= rCount; i++) { // Row iteration to get all the values

			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < cCount; j++) { // Column iteration to get all the values

				XSSFCell cell = row.getCell(j);
				// System.out.println(cell.getStringCellValue()); // Print the values

				data[i - 1][j] = cell.getStringCellValue();
			}
		}

		workbook.close(); // Close work book
		return data;
	}

}
