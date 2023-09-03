package test;

import java.util.ArrayList;
import java.util.List;

public class DatesBetween {
	
	private int firstDate;
	private int secondDate;
	private List<String> reversibleDates;
	
	public DatesBetween(int firstDate, int secondDate) {
	        if (firstDate > secondDate) {
	            throw new IllegalArgumentException("First date must be less than or equal to second date.");
	        }
	        
	        this.firstDate = firstDate;
	        this.secondDate = secondDate;
	        this.reversibleDates = findReversibleDates();
	    }

    private List<String> findReversibleDates() {
        List<String> reversibleDates = new ArrayList<>();
        for (int year = firstDate; year <= secondDate; year++) {
            for (int month = 1; month <= 12; month++) {
                for (int day = 1; day <= 31; day++) {
                    if (isValidDate(year, month, day)) {
                        String dateString = String.format("%04d-%02d%02d", year, month, day);
                        if (isReversibleDate(dateString)) {
                            reversibleDates.add(dateString);
                        }
                    }
                }
            }
        }
        return reversibleDates;
    }
    private boolean isReversibleDate(String dateString) {
        String reversedDateString = new StringBuilder(dateString).reverse().toString();
        return dateString.equals(reversedDateString);
    }
    
    private boolean isValidDate(int year, int month, int day) {
        try {
            java.time.LocalDate.of(year, month, day);
            return true;
        } catch (java.time.DateTimeException e) {
            return false;
        }
    }
    
    public void printDates() {
        for (String date : reversibleDates) {
            System.out.println(date);
        }
    }
}
