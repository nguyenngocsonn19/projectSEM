import java.util.PriorityQueue;
import java.util.Scanner;

public class Main  {
    private static final PriorityQueue<Passenger> passengerQueue = new PriorityQueue<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addReservation();
                    break;
                case 2:
                    modifyPassengerRecords();
                    break;
                case 3:
                    displayPassengerRecords();
                    break;
                case 4:
                    System.out.println("Exiting application...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
        System.out.println("Invalid choice. Please try again.");

    }

    private static void displayMenu() {
        System.out.println("----- Airline Reservation System Menu -----");
        System.out.println("1. Add reservation.");
        System.out.println("2. Modify passenger records");
        System.out.println("3. Display passenger records");
        System.out.println("4. Exit");
    }

    private static void addReservation() {
        System.out.println("Enter reservation details:");

        // Initialize variables to store user input
        int reservationId = 0;
        String passengerName = null;
        String address = null;
        String phone = null;
        String departureDate = null;
        String returnDate = null;

        boolean validInput;
        boolean idExists;
        do {
            validInput = true; // Assume input is valid initially
            idExists = false; // Assume ID doesn't exist initially

            System.out.print("Reservation ID: ");
            try {
                reservationId = Integer.parseInt(scanner.nextLine());
                if (reservationId == 0) {
                    System.out.println("Reservation ID cannot be 0. Please enter a valid ID.");
                    validInput = false;
                    continue; // Skip to the next iteration of the loop
                }

                // Check if the ID already exists
                for (Passenger passenger : passengerQueue) {
                    if (passenger.getReservationId() == reservationId) {
                        idExists = true;
                        break;
                    }
                }

                if (idExists) {
                    System.out.println("Reservation ID already exists. Please enter a different ID.");
                    validInput = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid reservation ID.");
                validInput = false;
            }

            if (validInput && !idExists) {
                System.out.print("Passenger Name: ");
                passengerName = scanner.nextLine();
                if (passengerName.isEmpty()) {
                    System.out.println("Passenger Name cannot be empty. Please enter a valid name.");
                    validInput = false;
                    continue;
                }

                System.out.print("Address: ");
                address = scanner.nextLine();
                if (address.isEmpty()) {
                    System.out.println("Address cannot be empty. Please enter a valid address.");
                    validInput = false;
                    continue;
                }

                System.out.print("Phone: ");
                phone = scanner.nextLine();
                if (phone.isEmpty()) {
                    System.out.println("Phone cannot be empty. Please enter a valid phone number.");
                    validInput = false;
                    continue;
                }

                System.out.print("Date of departure: ");
                departureDate = scanner.nextLine();
                if (departureDate.isEmpty()) {
                    System.out.println("Departure date cannot be empty. Please enter a valid date.");
                    validInput = false;
                    continue;
                }

                System.out.print("Date of return: ");
                returnDate = scanner.nextLine();
                if (returnDate.isEmpty()) {
                    System.out.println("Return date cannot be empty. Please enter a valid date.");
                    validInput = false;
                }
            }
        } while (!validInput || idExists);

        // Create Passenger object and add to PriorityQueue
        Passenger passenger = new Passenger(reservationId, passengerName, address, phone, departureDate, returnDate);
        passengerQueue.add(passenger);
        System.out.println("Reservation added successfully.");
    }



    private static void modifyPassengerRecords() {
        System.out.println("Enter the reservation ID to modify:");
        int modifyReservationId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        boolean found = false;
        for (Passenger passenger : passengerQueue) {
            if (passenger.getReservationId() == modifyReservationId) {
                found = true;
                System.out.println("Enter new details:");

                System.out.print("Passenger Name: ");
                String passengerName = scanner.nextLine();
                System.out.print("Address: ");
                String address = scanner.nextLine();
                System.out.print("Phone: ");
                String phone = scanner.nextLine();
                System.out.print("Date of departure: ");
                String departureDate = scanner.nextLine();
                System.out.print("Date of return: ");
                String returnDate = scanner.nextLine();

                passenger.setPassengerName(passengerName);
                passenger.setAddress(address);
                passenger.setPhone(phone);
                passenger.setDepartureDate(departureDate);
                passenger.setReturnDate(returnDate);

                System.out.println("Passenger details updated successfully.");
                break;
            }
        }

        if (!found) {
            System.out.println("No passenger found with the specified reservation ID.");
        }
    }


    private static void displayPassengerRecords() {
        System.out.println("----- Passenger Records -----");
        if (passengerQueue.isEmpty()) {
            System.out.println("No passengers in the records.");
        } else {
            for (Passenger passenger : passengerQueue) {
                System.out.println("Reservation ID: " + passenger.getReservationId());
                System.out.println("Passenger Name: " + passenger.getPassengerName());
                System.out.println("Address: " + passenger.getAddress());
                System.out.println("Phone: " + passenger.getPhone());
                System.out.println("Date of departure: " + passenger.getDepartureDate());
                System.out.println("Date of return: " + passenger.getReturnDate());
                System.out.println();
            }
        }
    }

}
