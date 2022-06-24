package Week6.Day1;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	 public static String[][] readData(String filename)throws IOException {
		//step1; Setup the path for the workbook
				XSSFWorkbook wb=new XSSFWorkbook("./data/Book1.xlsx");
				//step2:Get into the respective sheet
				XSSFSheet ws=wb.getSheet("CREATELEAD");
				//to get no of rows (exclude header)
				int rowcount=ws.getLastRowNum();
				System.out.println(rowcount);
		        // To get no of Cells
				int cellCount=ws.getRow(0).getLastCellNum();
				String[][] data=new String[rowcount][cellCount];
				for(int i=1; i<=rowcount; i++)
				{
					for(int j=0;j<cellCount;j++) {
						data[i-1][j]=ws.getRow(i).getCell(j).getStringCellValue();
						System.out.println(data);
					}
			
					}
	      	
	      	return data;
	      	
	}
	
	 public static String[][] readData1()throws IOException {
		//step1; Setup the path for the workbook
				XSSFWorkbook wb=new XSSFWorkbook("./data/Book1.xlsx");
				//step2:Get into the respective sheet
				XSSFSheet ws=wb.getSheet("EDITLEAD");
				//to get no of rows (exclude header)
				int rowcount=ws.getLastRowNum();
				System.out.println(rowcount);
		        // To get no of Cells
				int cellCount=ws.getRow(0).getLastCellNum();
				String[][] data=new String[rowcount][cellCount];
				for(int i=1; i<=rowcount; i++)
				{
					for(int j=0;j<cellCount;j++) {
						data[i-1][j]=ws.getRow(i).getCell(j).getStringCellValue();
						System.out.println(data);
					}
			
					}
	      	
	      	return data;
		
	}
	public static String[][] readData2()throws IOException {
		//step1; Setup the path for the workbook
				XSSFWorkbook wb=new XSSFWorkbook("./data/Book1.xlsx");
				//step2:Get into the respective sheet
				XSSFSheet ws=wb.getSheet("DELETELEAD");
				//to get no of rows (exclude header)
				int rowcount=ws.getLastRowNum();
				System.out.println(rowcount);
		        // To get no of Cells
				int cellCount=ws.getRow(0).getLastCellNum();
				String[][] data=new String[rowcount][cellCount];
				for(int i=1; i<=rowcount; i++)
				{
					for(int j=0;j<cellCount;j++) {
						data[i-1][j]=ws.getRow(i).getCell(j).getStringCellValue();
						System.out.println(data);
					}
			
					}
	      	
	      	return data;
}		
	public static String[][] readData4()throws IOException {
		//step1; Setup the path for the workbook
				XSSFWorkbook wb=new XSSFWorkbook("./data/Book1.xlsx");
				//step2:Get into the respective sheet
				XSSFSheet ws=wb.getSheet("DUPLICATELEAD");
				//to get no of rows (exclude header)
				int rowcount=ws.getLastRowNum();
				System.out.println(rowcount);
		        // To get no of Cells
				int cellCount=ws.getRow(0).getLastCellNum();
				String[][] data=new String[rowcount][cellCount];
				for(int i=1; i<=rowcount; i++)
				{
					for(int j=0;j<cellCount;j++) {
						data[i-1][j]=ws.getRow(i).getCell(j).getStringCellValue();
						System.out.println(data);
					}
			
					}
	      	
	      	return data;
}	
}