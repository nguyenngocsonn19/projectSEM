public class Passenger implements Comparable<Passenger> {
    private int reservationId;
    private String passengerName;
    private String address;
    private String phone;
    private String departureDate;
    private String returnDate;

    // Constructors
    public Passenger(int reservationId, String passengerName, String address, String phone, String departureDate, String returnDate) {
        this.reservationId = reservationId;
        this.passengerName = passengerName;
        this.address = address;
        this.phone = phone;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
    }

    // Getters and setters
    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    // Override compareTo method for Comparable interface
    @Override
    public int compareTo(Passenger otherPassenger) {
        return Integer.compare(this.reservationId, otherPassenger.reservationId);
    }
}
