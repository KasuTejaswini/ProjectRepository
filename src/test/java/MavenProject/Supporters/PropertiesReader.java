package MavenProject.Supporters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import MavenProject.CustomizedExceptions.CustomException;

public class PropertiesReader {
   private String Filepath;
   private FileInputStream fis;
   private Properties properties;
   public String value;
    
    public PropertiesReader(String Filepath) throws IOException 
    {
    	this.Filepath=Filepath;
	    fis=new FileInputStream(Filepath);
	    properties = new Properties();
		properties.load(fis);
	}
    
    public String getPropertyValue(String key) throws CustomException {
		if(properties!=null)
		{
			 value=properties.getProperty(key);
		}
		else
		{
			System.out.println("properties is pointing to null");
			CustomException exec=new CustomException("properties is pointing to null");
			throw exec;
		}
		return value;
	}
    
    public String getPropertyValue(String key,String defaultvalue) throws CustomException {
		if(properties!=null)
		{                           //if no value at specified key then it means value is null so default value
			 value=properties.getProperty(key,defaultvalue);
			 if(value==null)
			 {
				 value=defaultvalue;
			 }
		}
		else
		{
			System.out.println("properties is pointing to null");
			CustomException exec=new CustomException("properties is pointing to null");
			throw exec;
		}
		return value;
	}
    
    public String getPropertyValue(Object key) throws CustomException {
		if(properties!=null)
		{
			 value=(String) properties.get(key);
		}
		else
		{
			System.out.println("properties is pointing to null");
			CustomException exec=new CustomException("properties is pointing to null");
			throw exec;
		}
		return value;
	}
    
    public String getPropertyValue(Object key,Object defaultvalue) throws CustomException {
		if(properties!=null)
		{                           
			 value=(String) properties.getOrDefault(key, defaultvalue);
			 if(value==null)
			 {
				 value=(String) defaultvalue;
			 }
		}
		else
		{
			System.out.println("properties is pointing to null");
			CustomException exec=new CustomException("properties is pointing to null");
			throw exec;
		}
		return value;
	}
    
    public void setPropertyValue(String key,String value) throws FileNotFoundException, IOException, CustomException {
		if(properties!=null)
		{
			properties.setProperty(key,value);
			properties.store(new FileOutputStream(Filepath),"file saved");
		}
		else {
			CustomException cust= new CustomException("properties is pointing to null");
			throw cust;
		}
	}
    
    public void setPropertyValue(Object key,Object value) throws FileNotFoundException, IOException, CustomException {
		if(properties!=null)
		{
			properties.put(key,value);
			properties.store(new FileOutputStream(Filepath),"file saved");
		}
		else {
			CustomException cust= new CustomException("properties is pointing to null");
			throw cust;
		}
	}
    
    public void removePropertyValue(String key) throws FileNotFoundException, IOException, CustomException {
    	if(properties!=null)
		{
			properties.remove(key);
			properties.store(new FileOutputStream(Filepath),"file saved");
		}
		else {
			CustomException cust= new CustomException("properties is pointing to null");
			throw cust;
		}
	}
    
    public void removePropertyValue(String key,String value) throws FileNotFoundException, IOException, CustomException {
    	if(properties!=null)
		{
			properties.remove(key,value);
			properties.store(new FileOutputStream(Filepath),"file saved");
		}
		else {
			CustomException cust= new CustomException("properties is pointing to null");
			throw cust;
		}
	}
    
    public Map<String,String> getTotalData() throws CustomException {
    	Map<String,String> mapdata= new HashMap<String,String>();
    	if(properties!=null)
    	{
    		Set keyset=mapdata.keySet();
    		for(Object obj:keyset)
    		{
    		String key=(String) obj;
    		String value=properties.getProperty(key);
    		mapdata.put(key,value);
    		}
    	}
    	else {
    		CustomException cust= new CustomException("properties is pointing to null");
			throw cust;
    	}
    	return mapdata;
	}
}
