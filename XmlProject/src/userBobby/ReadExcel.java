package userBobby;




import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class ReadExcel
{

	public static void main( String [] args )
	{
		try 
		{

			InputStream input=new BufferedInputStream(new FileInputStream("sample.xls"));
			POIFSFileSystem fs=new POIFSFileSystem(input);
			HSSFWorkbook wb =new HSSFWorkbook(fs);
			HSSFSheet sheet =wb.getSheetAt(0);


			Iterator rows=sheet.rowIterator();
			while(rows.hasNext())
			{  
				HSSFRow row=(HSSFRow) rows.next();
				System.out.println("\n");
				Iterator cells = row.cellIterator();
				while(cells.hasNext()) 
				{

					Cell cell=(cell) cells.next();
					if(cell.CELL_TYPE_NUMERIC==cell.getCellType())
						System.out.print(cell.getNumericCellValue()+" ");
					else
						if(cell.CELL_TYPE_STRING==cell.getCellType())
							System.out.print(cell.getStringCellValue()+" ");
						else
							if(cell.CELL_TYPE_BOOLEAN==cell.getCellType())
								System.out.print(cell.getBooleanCellValue()+" ");
							else
								if(cell.CELL_TYPE_BLANK==cell.getCellType())
									System.out.print( "BLANK");
								else
									System.out.print("Unknown cell type");

				}


			}


		} 
		catch(IOException ex) 
		{

			ex.printStackTrace();
		}
	}
}


