package i190655;

import java.time.LocalDate;
import i190655.Flight;
import i190655.Passenger;

public class Reservation {
	
	private LocalDate departure;
	private Flight flight;
	protected Passenger P;
	
	Reservation()
	{
		departure= LocalDate.now();
		
	}
	
	public Reservation(Passenger pass,Flight f){
		
		this.P=pass;
		this.flight=f;
	}
	
		//getters and setters
	public LocalDate getdeparture() {
		
		return departure;
	}
	
	public void setdeparture(LocalDate departure) {
		
		this.departure = departure;
	}
	
	public Flight getFlight() {
		
		return flight;
	}
	
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	public Passenger getP() {
		return P;
	}
	
	public void setP(Passenger Pass) {
		
		this.P = Pass;
	}
	
	public void PrintReservationDetails() {
		
		System.out.println( "Ticket: " + P.getId() + " departing on flight from" + this.getFlight().getDeparture() + " to " + this.getFlight().getDestination() + " on " + this.getdeparture());
	}

}
