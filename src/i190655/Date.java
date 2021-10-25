package i190655;

public class Date {

	 int month;
	    int year;
	    int date;

	    public Date(int d, int m, int y){
	        date = d;
	        year = y;
	        month = m;
	    }


	    public String printDate(){
	        String temp = date+ "/" +month+"/"+year;
	        return temp;
	    }

	    public int getMonth() {
	        return this.month;
	    }

	    public void setMonth(int month) {
	        this.month = month;
	    }

	    public int getYear() {
	        return this.year;
	    }

	    public void setYear(int year) {
	        this.year = year;
	    }

	    public int getDate() {
	        return this.date;
	    }

	    public void setDate(int date) {
	        this.date = date;
	    }

	    
}
