package zybooks;

public class SeatInfo {
    private int    amtPaid;     // Amount paid
    private String firstName;   // First name
    private String lastName;    // Last name
    private final String EMPTY = "empty";

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAmountPaid() {
        return amtPaid;
    }

    // Method to check if Seat is empty
    public boolean isEmpty() {
        return firstName.equals(EMPTY);
    }

    // Method to empty a Seat
    public void makeEmpty() {
        firstName = EMPTY;
        lastName = EMPTY;
        amtPaid = 0;
    }

    // Method to print Seat fields
    public void printSeatInfo() {
        System.out.print(firstName + " ");
        System.out.print(lastName + " ");
        System.out.println("Paid: " + amtPaid);
    }

    // Method to initialize Seat fields
    public void reserveSeat(String inFirstName, String inLastName, int ticketCost) {
        firstName = inFirstName;
        lastName = inLastName;
        amtPaid = ticketCost;
    }
}
