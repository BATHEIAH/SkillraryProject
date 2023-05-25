package Genericlibraries;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/**
 * this class containts reusable method to perform  java related action
 * @author Batheiah
 *
 */
public class javaUtility 
{
	/**
	 * this method generates random number within the limit specified
	 * @param limit
	 * @return
	 */
public int generateRandomnum(int limit) {
	Random random=new Random();
	return random.nextInt(limit);
}
/**
 * this method generates current time
 * @return
 */
public String getCurrentTime() {
	Date date=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("dd_mm_yy_hh_mm_ss");
	return sdf.format(date);
}
}
