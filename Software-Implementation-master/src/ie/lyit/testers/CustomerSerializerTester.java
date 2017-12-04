//Piotr Gora
//Games Development
//L00129471
package ie.lyit.testers;
import ie.lyit.serialize.*;
import javax.swing.*;
import java.io.*;


public class CustomerSerializerTester  {
 

	
  public static void main(String args[]) {
   CustomerSerializer customerSerializer = new CustomerSerializer();
    customerSerializer.readRecordsFromFile();
    Menu menuObj = new Menu();
    do {
    	menuObj.display();
    	menuObj.readOption();
    	switch(menuObj.getOption())
    	{
    	 case 1:customerSerializer.addCustomer();break;
    	 case 2:customerSerializer.list();break;
    	 case 3:customerSerializer.view();break;
    	 case 4:customerSerializer.edit();break;
    	 case 5:customerSerializer.delete();break;
    	 case 6:break;
    	 default:System.out.println("INVAILD OPTION!");
    	}
    }while(menuObj.getOption() !=6);
    
    customerSerializer.writeRecordsToFile();
	  
  }
  
}


  

