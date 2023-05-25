package Genericlibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * this class contains all reusable method to perform actions
 * on properties file
 * @author Batheiah
 *
 */
public class PropertiesUtility 
{
	private Properties property;
	/**
	 * this method is used to initialize properties file
	 * @param FilePath
	 */
	public void propertesInit(String FilePath) {
		FileInputStream fis=null;
		try {
			 fis=new FileInputStream(FilePath);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		property=new Properties();
		
		try {
			property.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * this method is Used to fetch data From Properties File
	 * @param key
	 * @return
	 */
	public String readData(String key)
	{
		return property.getProperty(key);
	}
	/**
	 * this Method is used to write and Save Data to properties file
	 * @param key
	 * @param value
	 * @param FilePath
	 */
	public void WriteTopropertiies(String key, String value, String FilePath) 
	{
	property.put(key, value);
	FileOutputStream fos=null;
	try {
		fos=new FileOutputStream(FilePath);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	try {
		property.store(fos, "updated");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
		
		


