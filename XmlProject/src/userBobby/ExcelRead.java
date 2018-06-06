package userBobby;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class ExcelRead
{
	public static void main(String[] args) throws IOException
	{
		String excelFilePath="C:\\Users\\Vijayakanth Bayi\\Documents\\Tquanta Office\\Datails.xlsx";
		
		FileInputStream inputstream=new FileInputStream(new File(excelFilePath));
		
		Workbook workbook=new XSSFWorkBook(inputstream);
		Set firstSheet=workbook.getSheetAt(0);
		Iterator iterator=firstSheet.iterator();
		
		while(iterator.hasNext())
		{
			Row nextRow=iterator.next();
			Iterator cellIterator=newRow.cellIterator();
			
			while(cellIterator.hasNext())
			{
				cell cell=cellIterator.next();
				
				switch(cell.getCellType())
				{
				case cell.CELL_TYPE_STRING:
					System.out.print(cell.getStringCellValue());
					break;
				
				case cell.CELL_TYPE_BOOLEAN:
					System.out.print(cell.getBooleanCellValue());
					break;
					
				case cell.CELL_TYPE_NUMERIC:
					System.out.print(cell.getNumericCellValue());
					break;
				}
				System.out.print(" ");
			}
			System.out.println();
		}
		workbook.close();
		inputstream.close();
		
	}
}