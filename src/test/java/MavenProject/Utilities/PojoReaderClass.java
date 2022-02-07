package MavenProject.Utilities;

import java.io.IOException;

import MavenProject.Supporters.PropertiesReader;

public class PojoReaderClass {

	public static PropertiesReader getPrConfObj() throws IOException
	{
		PropertiesReader Prconf = new PropertiesReader(Filepaths.confFilepath);
		return Prconf;
	}
	
	public static PropertiesReader getPrOrObj() throws IOException
	{
		PropertiesReader PrOr = new PropertiesReader(Filepaths.orFilepath);
		return PrOr;
	}

	public static PropertiesReader getPrExcelObj() throws IOException
	{
		PropertiesReader Prexcel = new PropertiesReader(Filepaths.excelFilepath);
		return Prexcel;
	}

	public static PropertiesReader getPrXmlObj() throws IOException
	{
		PropertiesReader PrXml = new PropertiesReader(Filepaths.xmlFilepath);
		return PrXml;
	}

	public static PropertiesReader getPrTextObj() throws IOException
	{
		PropertiesReader PrTxt = new PropertiesReader(Filepaths.txtFilepath);
		return PrTxt;
	}

}
  