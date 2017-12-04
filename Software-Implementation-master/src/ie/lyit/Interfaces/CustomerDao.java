//Piotr Gora
//Games Development
//L00129471

package ie.lyit.Interfaces;

public interface CustomerDao {
	 void addCustomer() ;
	public void list();
    public Object view() ;
     void delete();
	 void edit();
	 void writeRecordsToFile();
	 void readRecordsFromFile(); 
}
