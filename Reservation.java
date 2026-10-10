public class Reservation {
    String customerName;
    Room room;

    Reservation(String customerName, Room room) {
        this.customerName = customerName;
        this.room = room;
    }

    void showDetails() {
        System.out.println("\n--- Booking Details ---");
        System.out.println("Customer: " + customerName);
        System.out.println("Room: " + room.roomNumber);
        System.out.println("Category: " + room.category);
        System.out.println("Price: Rs." + room.price);
    }
}