package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFile {

	public String getDataFromExcel(String sheetName, int rowCount, int cellCount) throws Throwable {

		FileInputStream fis = new FileInputStream("./testdata/Org.xlsx");

		Workbook wb = WorkbookFactory.create(fis);

		String data = wb.getSheet(sheetName).getRow(rowCount).getCell(cellCount).getStringCellValue();
		wb.close();
		return data;
	}

	public int getRowCount(String sheetName) throws Throwable {

		FileInputStream fis = new FileInputStream("./testdata/Org.xlsx");

		Workbook wb = WorkbookFactory.create(fis);
		int rowNumber = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowNumber;
	}

	public void setDataIntoExcel(String sheetName, int rowCount, int cellCount, String data) throws Throwable {

		FileInputStream fis = new FileInputStream("./testdata/Org.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowCount).getLastCellNum();
		wb.close();

		FileOutputStream fos = new FileOutputStream("./testdata/Org.xlsx");
		wb.write(fos);
		wb.close();

	}
}