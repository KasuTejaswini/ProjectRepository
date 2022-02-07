package MavenProject.Supporters;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import MavenProject.CustomizedExceptions.CustomException;

public class TextReader {

	private String Filepath;
	private File file;
	private FileWriter fileWriter;
	private BufferedWriter bufferedWriter;
	private FileReader fileReader;
	private BufferedReader bufferedReader;
	private String value;
	
	public TextReader(String Filepath) throws IOException 
	{
		File file=new File(Filepath);
		if(file.createNewFile())
		{
			System.out.println("file already exists");
		}
		else
		{
			System.out.println("file is created");
		}
		fileWriter = new FileWriter(file);
	    bufferedWriter=new BufferedWriter(fileWriter);
	    
	    fileReader=new FileReader(file);
	    bufferedReader=new BufferedReader(fileReader);	         
	}
	
	public String readData() throws IOException, CustomException {
		if(bufferedReader!=null)
		{
			value=bufferedReader.readLine();
		}
		else
		{
			CustomException cust=new CustomException("BufferedReader is pointing to null");
			throw cust;
		}
		return value;
	}
	
	public List<String> getTotalData() throws CustomException, IOException {
		List<String> filedata=new ArrayList<String>();
	  if(bufferedReader!=null)
	  {
		  value=bufferedReader.readLine();
		  filedata.add(value);
	  }
	  else
	  {
		  CustomException cust=new CustomException("BufferedReader is pointing to null");
		  throw cust;  
	  }
    return filedata;
	}
	
	private void writeData(String data) throws CustomException, IOException {
		if(bufferedWriter!=null)
		{
			bufferedWriter.write(data);
		}
		else
		{
			CustomException cust=new CustomException("BufferedWriter is pointing to null");
			throw cust;
		}

	}
}
