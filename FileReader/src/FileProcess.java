

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author xiaobozhang
 *
 */
public class FileProcess {
	

	//use arraylist to save all the numbers
	ArrayList<Float> numbers = new ArrayList<Float>();
	private int count;
	private double sum;
	
	public  boolean isFloat(String a)
	{
		if(a == null || "".equals(a)) return false;
		Pattern pattern = Pattern.compile("[0-9]*(\\.?)[0-9]*");  
        return pattern.matcher(a).matches(); 
	}
	
	
	public void processFile(String fileName)
	{
		// Create a file through
		File file = new File(fileName);
		BufferedReader reader = null;
		try {
				reader = new BufferedReader(new FileReader(file));
				String line = null;
				
				// Read until there is no line
				while ((line=reader.readLine()) != null){
					String[] words=line.split(" ");
				
				for(int i = 0;i < words.length;i++){
			    		String aword=words[i];
			    		
				  // Judge if it's a number
			    		
				   if( isFloat(aword))
				   {
					   System.out.println("test1="+aword);	 
					   // If it is a number, add it to the arraylist
					   numbers.add(Float.parseFloat(aword));  
				   }
	
			}
    }
		reader.close();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
			if (reader != null){
				try {
					reader.close();
				} catch (IOException e1) {
			}
		}
	}	
	
	count = numbers.size();
	for (int j=0;j < numbers.size();j++)
	{
		Float number = numbers.get(j);
		sum += number;
	}

	// Print out the count and sum
	System.out.println("count = "+ count);
	System.out.println("sum = "+ sum);
	
	}

}