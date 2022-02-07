package MavenProject.Supporters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import MavenProject.CustomizedExceptions.CustomException;

public class ExcelReaderClass {

	private String Filepath;
	private FileInputStream  file;
	private Workbook workbook;
	private Sheet sheet;
	private Row row;
	private Cell cell;
	private String cellvalue;
	
	public ExcelReaderClass(String Filepath) throws EncryptedDocumentException, IOException {
		file=new FileInputStream(Filepath);
	    workbook=WorkbookFactory.create(file);		
	}
	
	public Sheet getSheetobj(String how,String howvalue) throws CustomException {
		if(workbook!=null)
		{
			if(how.equalsIgnoreCase("sheetname"))
			{
			 sheet=workbook.getSheet(howvalue);
			}
			else if(how.equalsIgnoreCase("index"))
			{
				 int index=Integer.parseInt(howvalue);
				 sheet=workbook.getSheet(howvalue);
			}
		}
		else
		{
			CustomException cust = new CustomException("workbook is pointing to null");
			throw cust;
		}
     return sheet;
	}
	
	public String getCellData(String how,String howvalue,int rownum,int cellnum) throws CustomException {
		sheet=getSheetobj(how, howvalue);
        if(sheet!=null)
        {
          row=sheet.getRow(rownum);
          if(row!=null) 
          {
        	cell=row.getCell(cellnum);
        	if(cell!=null)
        	{
        		if(cell.getCellType()==CellType.STRING)
        		{
        			cellvalue=cell.getStringCellValue();
        		}
        		else if(cell.getCellType()==CellType.NUMERIC)
        		{
        			cellvalue=cell.getNumericCellValue()+"";
        		}
        		else if (cell.getCellType()==CellType.BOOLEAN)
        		{
        			cellvalue=cell.getBooleanCellValue()+"";
        		}
        	}
        	else
        	{
        		CustomException cust = new CustomException("cell is pointing to null");
    			throw cust;
        	}
          }
          else
          {
        	  CustomException cust = new CustomException("row is pointing to null");
  			 throw cust; 
          }
        }
        else
        {
        	CustomException cust = new CustomException("sheet is pointing to null");
			throw cust;
        }
        return cellvalue;
	}
	
	public List<String> getRowData(String how,String howvalue,int rownum) throws CustomException 
	{
		List<String> rowdata = new ArrayList<String>();
		sheet=getSheetobj(how, howvalue);
          if(sheet!=null) 
          {
        	row=sheet.getRow(rownum); 
        	if(row!=null)
        	{
        		for(int i=0;i<=row.getLastCellNum();i++)
        		{
        			cell=row.getCell(i);
        			if(cell!=null)
        			{
        				if(cell.getCellType()==CellType.STRING)
        				{
        					cellvalue=cell.getStringCellValue();
        					rowdata.add(cellvalue);
        				}
        				else if(cell.getCellType()==CellType.NUMERIC) 
        				{
        					cellvalue=cell.getNumericCellValue()+"";
        					rowdata.add(cellvalue);
        				}
        				else if(cell.getCellType()==CellType.BOOLEAN) 
        				{
        					cellvalue=cell.getBooleanCellValue()+"";
        					rowdata.add(cellvalue);
        				}				
        			}
        			else
        			{
        				CustomException cust = new CustomException("cell is pointing to null");
        				throw cust;
        			}
        		}
        	}
        	else
        	{
        		CustomException cust = new CustomException("row is pointing to null");
    			throw cust;
        	}
          }
          else
          {
        	CustomException cust = new CustomException("sheet is pointing to null");
  			throw cust;  
          }
		return rowdata;
	   }
	
	public List<String> getSheetData(String how,String howvalue) throws CustomException 
	{
		List<String> sheetdata =new ArrayList<String>();
		sheet=getSheetobj(how, howvalue);
		if(sheet!=null)
		{
		   for(int i=0;i<=sheet.getLastRowNum();i++ )
		   {
			   row=sheet.getRow(i);
			   if(row!=null)
			   {
				   for(int j=0;j<=row.getLastCellNum();j++)
				   {
					   cell=row.getCell(j);
					   if(cell!=null)
					   {
						   if(cell.getCellType()==CellType.STRING)
	        				{
	        					cellvalue=cell.getStringCellValue();
	        					sheetdata.add(cellvalue);
	        				}
	        				else if(cell.getCellType()==CellType.NUMERIC) 
	        				{
	        					cellvalue=cell.getNumericCellValue()+"";
	        					sheetdata.add(cellvalue);
	        				}
	        				else if(cell.getCellType()==CellType.BOOLEAN) 
	        				{
	        					cellvalue=cell.getBooleanCellValue()+"";
	        					sheetdata.add(cellvalue);
	        				}				
					   }
					   else
					   {
						   CustomException cust = new CustomException("cell is pointing to null");
				  		   throw cust; 
					   }
				   }
			   }
			   else
			   {
				   CustomException cust = new CustomException("row is pointing to null");
		  		   throw cust; 
			   }
		   }
		}
		else
		{
			CustomException cust = new CustomException("sheet is pointing to null");
  			throw cust; 
		}
		return sheetdata;
	}
}
