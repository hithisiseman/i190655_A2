package i190655;

import i190655.Flight;

public class Passenger {
	
			//private String date;
			protected Flight flight;
			Customer customer;
			private static int currentid=0;
			private int id;
		
			public int getId() {
				return this.id;
			}
		
			public void setId(int id) {
				this.id = id;
			}
		
			public Passenger(Customer c, Flight f){
				
				currentid++;
				id=currentid;
				customer = c;
				flight = f;
			}
			
			//Constructor
			public void setCustomer(Customer c){
				customer = c;
		
			}
			
			public void setFlight(Flight f){
				flight = f;
		
			}
			
			public Customer getCustomer(){
				return customer;
			}
			
}
