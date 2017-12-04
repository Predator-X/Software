//Piotr Gora
//Games Development
//L00129471
package ie.lyit.serialize;
import java.io.*;
import java.util.*;
import java.util.Scanner;

import ie.lyit.Interfaces.CustomerDao;
import ie.lyit.hotel.Customer;
import ie.lyit.hotel.Name;
import ie.lyit.hotel.Person;
public class CustomerSerializer implements CustomerDao{
//	public Name name; // COMPOSITION - Person HAS-A name
//	public String address;
//	public String phoneNumber;
//	 public String email ;
	 final String FILENAME ="ArrayCustomer.bin";
	 private ArrayList<Customer> customers;
	// private int arraySize=0;
	 
    public CustomerSerializer() 
   {
	 //super(t,  fN,  sn,  address, pNo,  email);
    	super();
	customers=new ArrayList<Customer>();
	 
   }
	//Create and initialise Customers
    @Override
    public void addCustomer() 
   {
    	  int highest =0;
		  
	  Customer cust = new Customer();
	  cust.read();
	  
	//Search for highest customer number this is preventing form incorrect customer numbering
	  if(customers.size()>0) 
	  { 
		   highest = customers.get(0).getNumber();
		  int highestIndex = 0;
		  for(int i = 1;i < customers.size();i++) 
		  {
			
			  int curValue = customers.get(i).getNumber();
			  if(curValue>highest) 
			  {
				  highest=curValue;
				
				  highestIndex = i;  
				//System.out.print("HighesteNumber"+ highest+1);
			  } 
		  }
	  }
 
	 //adding the customer 
	  customers.add(cust);
	  //setting next customer number 
	  cust.setNumber(highest+1);
	  
   }
    
    @Override
    public void list()
    {
    	for(Customer tmpCustomer:customers)
    		System.out.println("Customer Number: "+tmpCustomer.getNumber()+"\tName: "+tmpCustomer.getName()+"\tAddress: "
    	+tmpCustomer.getAddress()+"\tPhone Nr: "+tmpCustomer.getPhoneNumber()+"\tE-Mail: "+tmpCustomer.getEmailAddress());
//    	for(Customer tmpCustomer:customers)
//    		System.out.println(tmpCustomer);
    }
    @Override
    public Customer view() 
    {
    	Scanner kb = new Scanner(System.in);
    	
    	System.out.println("Enter Customer Number: ");
    	int customerToView=kb.nextInt();
    	
    	for(Customer tmpCustomer:customers) {
    		if(tmpCustomer.getNumber() == customerToView) {
    			//System.out.println(tmpCustomer);
    			System.out.println("Customer Number: "+tmpCustomer.getNumber()+"\tName: "+tmpCustomer.getName()+"\tAddress: "
    			    	+tmpCustomer.getAddress()+"\tPhone Nr: "+tmpCustomer.getPhoneNumber()+"\tE-Mail: "+tmpCustomer.getEmailAddress());
    			return tmpCustomer;
    		}
    	}
    	System.out.println("Customer Not found!!");
    	return null;
    }
    
    @Override
    public void delete() 
    {
    	Customer tempCustomer = view();
    	if(tempCustomer !=null) {
    		customers.remove(tempCustomer);
    	}
    }
    
    @Override
    public void edit() 
    {
    	Customer tempCustomer = view();
    	if(tempCustomer !=null) {
    		int index=customers.indexOf(tempCustomer);
    		tempCustomer.read();
    		customers.set(index, tempCustomer);
    	}
    }
    //Saving customer details to file method
    @Override
    public void writeRecordsToFile()
    {
    	try {
    		FileOutputStream fileStream = new FileOutputStream(FILENAME);
    		ObjectOutputStream os = new ObjectOutputStream(fileStream);
    		os.writeObject(customers);
    		os.close();
    	}
    	catch(FileNotFoundException fNFE) {
    		System.out.println("CANNOT CREATE FILE TO STORE CUSTOMERS!");
    	}
    	catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    }
    // read customer files from file method
    @Override
    public void readRecordsFromFile() 
    {
    	try {
    		FileInputStream fis = new FileInputStream(FILENAME);
    		ObjectInputStream is = new ObjectInputStream(fis);
    		//Object o = is.readObject();
    		//if(o instanceof ArrayList)
    			//customers = (ArrayList<Customer>)o;
    		customers = (ArrayList<Customer>)is.readObject();
    		is.close();
    	}
    	catch(FileNotFoundException fNFE) {
    		System.out.println("CANNOT FIND CUSTOMERS FILE!!");
    	}
    	catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    }
  // public Customer customer = new Customer(),customer2=new Customer();
	//Create ArrayList called customerlist
	//customer.read();
//	public void read() 
//	{
//		//public static void main(String args[]) {
//		Scanner kb = new Scanner(System.in);
//		System.out.println("Enter Customer Details ==> ");
//		System.out.print("\tName : ");
//		name=new Name("","",kb.nextLine());
//		//customer.setName(new Name("","",kb.nextLine()));
//		System.out.print("\tAddress: ");
//		 address=kb.nextLine(); 
//		//customer.setAddress(kb.nextLine());
//		System.out.print("\tPhone Number: ");
//	    phoneNumber=kb.nextLine();	
//		//customer.setPhoneNumber(kb.nextLine());
//		System.out.print("\tEmail: ");
//		  email = kb.nextLine();
//			//customer.setEmailAddress(kb.nextLine());
//	 }

	
	
 // public ArrayList<CustomerSerializer> custList = new ArrayList<CustomerSerializer>();
   //   custList.add(customer.read());




}
