package i190655;

public class FlightOverbookedException extends Exception{
	
    public FlightOverbookedException() {//Constructor
      
    }
    
    public FlightOverbookedException(String str){
         super(str);
    }
    
}