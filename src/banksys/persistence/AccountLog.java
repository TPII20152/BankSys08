package banksys.persistence;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

public class AccountLog {
	
	//Method for operation that dont need value
	public static void logRecord(String accountN, String operation)
	{
		String log;
		log = "Account nº " + accountN + " " + operation + " at " + getTime();
		write(log);
	}
	
	//Method for operation with one account
	public static void logRecord(String accountN, String operation, Double ammount)
	{		
		String log;
		String value = String.valueOf(ammount);
		log = "Account nº " + accountN + " " + operation + " R$" + value + " at " + getTime();
		write(log);
	}
	
	//Method for operation with two accounts
	public static void logRecord(String accountN1, String accountN2, String operation, Double ammount)
	{
		String log;
		String value = String.valueOf(ammount);
		log = "Account nº " + accountN1 + " " + operation + " to Account nº " + accountN2 + " R$" + value + " at " + getTime();
		write(log);
	}

	public static void write(String text)
	{	
		FileWriter file = null;
		try {
			//The second parameter tells to write at end of the file
			file = new FileWriter("AccountLog.txt", true);
		} catch (IOException e1) {
			e1.printStackTrace();
		} 
		PrintWriter writeFile = new PrintWriter(file); 
		
		//Writing on file
		writeFile.println(text);
		
		try {
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 	
	}
	
	static String getTime()
	{
		SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		java.util.Date date=new java.util.Date(); 
		String time = sdf1.format(date);

		return time;
	}
}
