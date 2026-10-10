 import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Hotel hotel = new Hotel();

        while (true) {

            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
            System.out.println("1. Search Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. View Booking");
            System.out.println("4. Cancel Reservation");
            System.out.println("5. Payment");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                hotel.searchRooms();

            } else if (choice == 2) {

                System.out.print("Enter customer name: ");
                String name = sc.nextLine();

                System.out.print("Enter room number: ");
                int room = sc.nextInt();

                hotel.bookRoom(name, room);

            } else if (choice == 3) {

                if (hotel.reservation != null) {
                    hotel.reservation.showDetails();
                } else {
                    System.out.println("No booking found!");
                }

            } else if (choice == 4) {

                hotel.cancelReservation();

            } else if (choice == 5) {

                System.out.print("Enter payment amount: ");
                double payment = sc.nextDouble();

                if (payment > 0) {
                    System.out.println("Payment successful!");
                } else {
                    System.out.println("Payment failed!");
                }

            } else if (choice == 6) {

                System.out.println("Thank you!");
                break;

            } else {

                System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}