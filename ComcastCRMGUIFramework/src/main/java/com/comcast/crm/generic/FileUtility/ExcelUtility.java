package com.comcast.crm.generic.FileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public FileInputStream fis;
	public Workbook wb;
	public Sheet sh;
	public Row row;

	public String getDataFromExcelFile(String sheetName, int rowNum, int celNum)
			throws EncryptedDocumentException, IOException {

		fis = new FileInputStream("./TestData/testScriptData.xlsx");
		wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
		wb.close();
		return data;
	}

	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {

		fis = new FileInputStream("./TestData/testScriptData.xlsx");
		wb = WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowCount;
	}

	public void setDataIntoExcel(String sheetName, int rowNum, int celNum, String data)
			throws EncryptedDocumentException, IOException {

		fis = new FileInputStream("./TestData/testScriptData.xlsx");
		wb = WorkbookFactory.create(fis);
		Cell cel = wb.getSheet(sheetName).getRow(rowNum).createCell(celNum);
		cel.setCellType(CellType.STRING);
		cel.setCellValue(data);

		FileOutputStream fos = new FileOutputStream("./TestData/testScriptData.xlsx");
		wb.write(fos);
		wb.close();

	}

	public Object[][] getMultipleDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException {

		fis = new FileInputStream("./TestData/testScriptData.xlsx");
		wb = WorkbookFactory.create(fis);
		sh = wb.getSheet(sheetName);
		int row = sh.getLastRowNum();
		System.out.println(row);
		int cel = sh.getRow(0).getLastCellNum();
		System.out.println(cel);

		Object[][] objArr = new Object[row][cel];
		for (int i = 1; i <=row; i++) {

			for (int j = 0; j <cel; j++) {

				objArr[i - 1][j] = sh.getRow(i).getCell(j).toString();
			}
		}
		return objArr;

	}
}
