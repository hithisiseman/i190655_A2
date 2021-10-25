package i190655;

import java.util.ArrayList;

public class Flight {
	
	private String TypeofFlight; 
	private String Departure;
	private String Destination;
	private Date date;
	private int totalSeats;
	private int occupiedSeats;
	protected ArrayList<Passenger> passengers;
	protected Passenger P;
	private int price;
	private static int currentid=0;
	private int id;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	public Flight(String Ftype, String dep, String dest, Date d, int pri) {
		
		this.TypeofFlight = Ftype;
		this.Departure = dep;
		this.Destination = dest;
		this.date = d;
		this.passengers = new ArrayList<Passenger>();
		totalSeats = 200;
		occupiedSeats=0;
		price = pri;
		currentid++;
		id = currentid;
		passengers = new ArrayList<Passenger>();
	}

	public boolean checkAvailibility(){
		return occupiedSeats<totalSeats;
	}

	public void removePassenger(int passengerId){
		for(Passenger p : passengers){
			if(p.getId()==passengerId){
				passengers.remove(p);
				occupiedSeats--;
				break;
			}
		}
	}

	

	public int getTotalSeats() {
		return this.totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public int getOccupiedSates() {
		return this.occupiedSeats;
	}

	public void setOccupiedSates(int occupiedSates) {
		this.occupiedSeats = occupiedSates;
	}

	public Flight(Flight f) {
		
		TypeofFlight = f.TypeofFlight;
		Departure = f.Departure;
		Destination = f.Destination;
	}
	
	public String getTypeofFlight() {
		return TypeofFlight;
	}

	public void setTypeofFlight(String Type_of_Flight) {
		TypeofFlight = Type_of_Flight;
	}

	public String getDeparture() {
		return Departure;
	}

	public void setDeparture(String dep) {
		Departure = dep;
	}

	public String getDestination() {
		return Destination;
	}
	
	// public String getDestinationAgainstID(int i) {
		
	// 	if(i==P.getId())
	// 		return Destination;
		
	// 	else
	// 		return "\0";
	// }
	

	public void setDestination(String destination) {
		Destination = destination;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	public void PrintFlightDetails() {
		System.out.println("\n"+"id: "+id+"\t"+ this.getTypeofFlight()+"\t"+this.getDeparture()+"\t"+this.getDestination()+"\t"+"Date: "+this.getDate().printDate()+ "\t"+ "Available seats: "+ (totalSeats-occupiedSeats)+"\n");
	}

	public void reserveFlight(Customer c, Reservation r){
        c.reserveFlight(r);
        occupiedSeats--;
		passengers.add(r.getP());
    }
	
	//public  void CancelFlight();

}
