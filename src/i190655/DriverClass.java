package i190655;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DriverClass {
	
	private static boolean loggedIn=false;
	private static List <Flight> flights;
	private static List <Customer> customers;
	private static Customer currentCustomer;

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);

		customers = new ArrayList<Customer>();
		
		Customer p1 = new Customer("Maryam", "Female", 21,"0333-5678976", "Block D, Ptcl colony,G-8", 123456,"maryam@hotmail.com","password");
		Customer p2 = new Customer("Maaz", "Male", 20,"0331-534568", "Block D, Ptcl colony,G-8", 789654,"123","password");

		Flight f = new Flight("direct","lahore","karachi",new Date(23,2,2021), 25000);
		Flight f1 = new Flight("direct","karachi","lahore",new Date(23,2,2021), 25000);
		flights = new ArrayList<Flight>();

		flights.add(f);
		flights.add(f1);


		customers.add(p1);
		customers.add(p2);
		while(true){
			drawMenu();
			if(!loggedIn){
				int choice = sc.nextInt();
				
				switch(choice){
					case 1:
						Register();
						break;
					case 2:
						Login();
						break;
					default:
						System.out.println("Enter a correct command");
						break;
				}
			}

			else{
				int choice = sc.nextInt();

				switch(choice){
					case 1:
						searchFlight();
						break;
					case 2:
					try{
						cancelFlight();
					}catch(FlightNotFoundException e){
						System.out.println("Exception: "+e);
					}
						break;
					
					case 3:
						viewCalender();
						break;
					case 4:
					try{
						printTicket();
					}catch(ReservationNotFoundException e){
						System.out.println("Exception "+e);
					}
						break;


				}
			}

		}
		
	}


	public static void drawMenu(){

		if(!loggedIn){
			System.out.println("\nWhat would you like to do:");
			System.out.println("1) Register");
			System.out.println("2) Login");
		}
		else{
			System.out.println("\nWhat would you like to do:");
			System.out.println("1) Search Flights");
			System.out.println("2) Cancel Flight");
			System.out.println("3) View Flight Calender");
			System.out.println("4) Print Ticket");
		}

	}
	public static void searchFlight(){
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter destination: ");
		String dest = sc.nextLine();

		System.out.println("Enter departure: ");
		String dep = sc.nextLine();

		List<Flight> searchedFlights = new ArrayList<Flight>();


		boolean found = false;
		for(Flight f : flights){
			if(f.getDeparture().equals(dep)){
				if(f.getDestination().equals(dest)){
					f.PrintFlightDetails();
					searchedFlights.add(f);
					found = true;
				}
			}
		}

		if(!found){
			System.out.println("No flights available for this destination and departure");
		}
		if(found){
			try{
				reserveFlight(searchedFlights);
			}catch(FlightNotFoundException e){
				System.out.println("Exception "+e);
			}catch(FlightOverbookedException e){
				System.out.println("Exception "+e);
			}
		}

	}

	public static void Login(){
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter email: ");
		String em = sc.nextLine();

		System.out.println("Enter Pasword: ");
		

		String password = sc.nextLine();

		for(Customer c : customers){
			if(c.getEmail().equals(em)){
				if(c.getPassword().equals(password)){
					System.out.println("\nSuccessfully logged in");
					currentCustomer = c;
					loggedIn = true;
				}
			}
		}
	}

	public static void cancelFlight() throws FlightNotFoundException{
		List<Reservation> r = currentCustomer.getReservations();
		List<Flight> fe = new ArrayList<Flight>();
		for(Reservation re: r){
			fe.add(re.getFlight());
		}


		System.out.println("Booked flights: ");
		for(Flight f: fe){
			f.PrintFlightDetails();
		}

		System.out.println("Enter the id of the Flight you want to cancel: ");
		Scanner sc = new Scanner(System.in);

		int id = sc.nextInt();
		
		boolean found = false;

		for(int i=0;i<fe.size();i++){
			found = true;
			if(fe.get(i).getId()==id){
				fe.get(i).removePassenger(r.get(i).getP().getId());
				currentCustomer.cancelReservation(r.get(i).getP().getId());
			}
		}
		if(!found){
			throw new FlightNotFoundException("Flight id does not exist");
		}
		System.out.println("\nBooking successfull cancelled\n");

	}

	public static void viewCalender(){
		for(Flight f: flights){
			f.PrintFlightDetails();
		}
		try{
			reserveFlight(flights);
		}catch(FlightNotFoundException e){
			System.out.println("Exception "+e);
			
		}catch(FlightOverbookedException e){
			System.out.println("Exception "+e);
		}
		

	}

	public static void reserveFlight(List<Flight> fl) throws FlightNotFoundException, FlightOverbookedException{
		System.out.println("Book a flight: ");
		System.out.println("1) Yes");
		System.out.println("2) No");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();

		switch(choice){
			case 1:
				System.out.println("Enter id of the flight: ");
				int id = sc.nextInt();
				boolean found = false;
				for(Flight f: fl){
					if(f.getId()==id){
						if(!f.checkAvailibility()){
							throw new FlightOverbookedException("Flight is overbooked");
						}
						found = true;						
						System.out.println("Enter Credit Card no: ");
						String meow = sc.nextLine();
						meow = sc.nextLine();
						System.out.println("Enter Pin: ");
						meow = sc.nextLine();	

						Passenger p = new Passenger(currentCustomer, f);
						Reservation r = new Reservation(p,f);
						System.out.println("\nFlight successfully reserved\n");
						System.out.println("booking detail:");
						r.PrintReservationDetails();
						f.reserveFlight(currentCustomer, r);
							
						
					}
				}

				if(!found){
					throw new FlightNotFoundException("Flight does ont exist");
				}

		}
		
	}

	public static void printTicket() throws ReservationNotFoundException{

		// for(Reservation r: currentCustomer.getReservations()){
		// 	r.PrintReservationDetails();
		// }

		System.out.println("Enter id of the booking you want to print the ticket of: ");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		boolean found = false;
		
		for(Reservation r: currentCustomer.getReservations()){
			
			if(r.getP().getId() == id){
				found = true;
				r.PrintReservationDetails();
			}
		}
		
		if(!found){
			throw new ReservationNotFoundException("Booking id does not exist");
		}

	}
	public static void Register(){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name: ");
		String name = sc.nextLine();
		System.out.println("Enter your gender: ");
		String gender = sc.nextLine();
		System.out.println("Enter your age: ");
		int age = sc.nextInt();
		//sc.nextLine();
		System.out.println("Enter your phone no: ");
		String phone = sc.nextLine();
		System.out.println("Enter your address: ");
		String add = sc.nextLine();
		System.out.println("Enter your passport no: ");
		int pass = sc.nextInt();
		//sc.nextLine();
		System.out.println("Enter your  email: ");
		String em = sc.nextLine();
		System.out.println("Enter your password: ");
		String password = sc.nextLine();

		customers.add(new Customer(name, gender, age, phone, add, pass, em, password));

		System.out.println("Successfully registers \n");

	}
}
