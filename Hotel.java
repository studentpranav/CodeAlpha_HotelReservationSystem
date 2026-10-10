import java.io.FileWriter;
import java.io.IOException;

public class Hotel {

    Room[] rooms = {
        new Room(101, "Standard", 1500),
        new Room(102, "Standard", 1500),
        new Room(201, "Deluxe", 2500),
        new Room(301, "Suite", 4000)
    };

    Reservation reservation;

    // Search available rooms
    public void searchRooms() {
        System.out.println("\n--- Available Rooms ---");

        for (Room r : rooms) {
            if (r.available) {
                System.out.println(r.roomNumber + " - "
                        + r.category + " - Rs." + r.price);
            }
        }
    }

    // Book room
    public void bookRoom(String name, int roomNumber) {

        for (Room r : rooms) {

            if (r.roomNumber == roomNumber && r.available) {

                r.available = false;
                reservation = new Reservation(name, r);

                System.out.println("Room booked successfully!");

                saveBooking(name, r, "Booked");
                return;
            }
        }

        System.out.println("Room not available!");
    }

    // Save booking in file
    private void saveBooking(String name, Room r, String status) {

        try {
            FileWriter file = new FileWriter("bookings.txt");

            file.write("Customer: " + name + "\n");
            file.write("Room: " + r.roomNumber + "\n");
            file.write("Category: " + r.category + "\n");
            file.write("Price: Rs." + r.price + "\n");
            file.write("Availability: " + status + "\n");

            file.close();

        } catch (IOException e) {
            System.out.println("File error!");
        }
    }

    // Cancel reservation
    public void cancelReservation() {

        if (reservation != null) {

            reservation.room.available = true;

            saveBooking(
                reservation.customerName,
                reservation.room,
                "Available"
            );

            reservation = null;

            System.out.println("Reservation cancelled successfully!");

        } else {
            System.out.println("No reservation found!");
        }
    }
}