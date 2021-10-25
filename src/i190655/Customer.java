package i190655;

import java.util.*;

public class Customer {

	 private int id;
	    private String name;
	    private String gender;
	    private int age;
	    private String address;
	    private int passport_num;
	    private String contact;
	    private String email, password;
	    private List<Reservation> reservations;
	    public static int currentid = 0;

	    public List<Reservation> getReservations() {
	        return this.reservations;
	    }

	    public void setReservations(List<Reservation> reservations) {
	        this.reservations = reservations;
	    }

	    public Customer() {
						
	        this.id = 0;
	        this.name ="\0";
	        this.gender = "\0";
	        this.age = 0;
	        this.address = "\0";
	        this.passport_num = 0;
	        this.contact="\0";
	        reservations = new ArrayList<Reservation>();
	        currentid++;
	        id=currentid;
	    }

	    public void cancelReservation(int r){
	    	
	        for(Reservation re:reservations){
	        	
				if(re.getP().getId()==r){
					
					reservations.remove(re);
					break;
				}
			}
	    }

	    public Customer(String n, String g, int a,String c, String add, int passport, String em, String pass) {
					
	        this.name = n;
	        this.gender = g;
	        this.age = a;
	        this.address = add;
	        this.passport_num = passport;
	        this.contact=c;
	        email = em;
	        password = pass;
	        reservations = new ArrayList<Reservation>();
	        currentid++;
	        id=currentid;
	        //this.typeofflight=f.getTypeofFlight();
	    
	    }

	    //setters & getters
	    
	    public void setId(int id) {
	        
	        if(id > 0)
	            this.id = id;
	    }

	    public int getId() {
	        return id;
	    }
	    
	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getName() {
	        return name;
	    }	

	    
	    public void setGender(String gender) {
	        this.gender = gender;
	    }

	    public String getGender() {
	        return gender;
	    }
	    
	    public void setAge(int age) {
	        this.age = age;
	    }

	    public int getAge() {
	        return age;
	    }
	    
	    public void setContact() {
	        this.contact=contact;
	    }
	    
	    public String getContact() {
	        return contact;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }

	    public int getPassport() {
	        return passport_num;
	    }

	    public void setPassport(int passport) {
	        this.passport_num = passport;
	    }
	    public void setEmail(String em){
	        email = em;
	    }

	    public String getEmail(){
	        return email;
	    }

	    public String getPassword(){
	        return password;
	    }
	    public void PrintPassngerData() {
	        
	        System.out.println("Id\tName\tGender\tAge\tContact\t\tAddrees\t\t\t\tPassport");
	        System.out.println(id+"\t"+name+"\t"+gender+"\t"+age+"\t"+contact+"\t"+address+"\t"+passport_num);
	        System.out.println("");
	    }

	    public void reserveFlight(Reservation r){
	        reservations.add(r);
	    }
}
