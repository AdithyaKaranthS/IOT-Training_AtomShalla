import java.util.*;

class InvalidSeatException extends Exception {
    public InvalidSeatException(String message) {
        super(message);
    }
}

class SeatAlreadyBookedException extends Exception {
    public SeatAlreadyBookedException(String message) {
        super(message);
    }
}

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

class BookingNotFoundException extends Exception {
    public BookingNotFoundException(String message) {
        super(message);
    }
}

class InvalidFareException extends Exception {
    public InvalidFareException(String message) {
        super(message);
    }
}

abstract class Bus {
    protected String busNumber;
    protected String route;
    protected int seats;
    protected double fare;
    protected boolean[] bookedSeats;

    Bus(String busNumber, String route, int seats, double fare) {
        this.busNumber = busNumber;
        this.route = route;
        this.seats = seats;
        this.fare = fare;
        this.bookedSeats = new boolean[seats + 1];
    }

    abstract double calculateFare();

    abstract void showBusDetails();

    public boolean isValidSeat(int seatNumber) {
        return seatNumber >= 1 && seatNumber <= seats;
    }

    public boolean isBooked(int seatNumber) {
        return bookedSeats[seatNumber];
    }

    public void bookSeat(int seatNumber) {
        bookedSeats[seatNumber] = true;
    }

    public void cancelSeat(int seatNumber) {
        bookedSeats[seatNumber] = false;
    }
}

class ACBus extends Bus {

    ACBus(String busNumber, String route, int seats, double fare) {
        super(busNumber, route, seats, fare);
    }

    @Override
    double calculateFare() {
        return fare + 100;
    }

    @Override
    void showBusDetails() {
        System.out.println("AC Bus: " + busNumber);
        System.out.println("Route: " + route);
        System.out.println("Fare: " + calculateFare());
    }
}

class NonACBus extends Bus {

    NonACBus(String busNumber, String route, int seats, double fare) {
        super(busNumber, route, seats, fare);
    }

    @Override
    double calculateFare() {
        return fare;
    }

    @Override
    void showBusDetails() {
        System.out.println("Non-AC Bus: " + busNumber);
        System.out.println("Route: " + route);
        System.out.println("Fare: " + calculateFare());
    }
}

class Booking {
    private static int totalBookings = 0;

    private int bookingId;
    private String passengerName;
    private int age;
    private int seatNumber;
    private boolean windowSeat;
    private Bus bus;

    Booking(String passengerName, int age, int seatNumber,
            boolean windowSeat, Bus bus) throws InvalidAgeException {

        if (age < 5 || age > 100) {
            throw new InvalidAgeException("Invalid age");
        }

        totalBookings++;
        bookingId = totalBookings;

        this.passengerName = passengerName;
        this.age = age;
        this.seatNumber = seatNumber;
        this.windowSeat = windowSeat;
        this.bus = bus;
    }

    public int getBookingId() {
        return bookingId;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public Bus getBus() {
        return bus;
    }

    public void showBooking() {
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Passenger: " + passengerName);
        System.out.println("Age: " + age);
        System.out.println("Seat: " + seatNumber);
        System.out.println("Window Seat: " + windowSeat);
        System.out.println("Bus: " + bus.busNumber);
    }
}

class TicketBookingSystem {
    private ArrayList<Booking> bookings = new ArrayList<>();

    public Booking bookTicket(String name, int age, int seat, Bus bus)
            throws InvalidSeatException,
            SeatAlreadyBookedException,
            InvalidAgeException,
            InvalidFareException {

        return bookTicket(name, age, seat, false, bus);
    }

    public Booking bookTicket(String name, int age, int seat,
                               boolean window, Bus bus)
            throws InvalidSeatException,
            SeatAlreadyBookedException,
            InvalidAgeException,
            InvalidFareException {

        if (!bus.isValidSeat(seat)) {
            throw new InvalidSeatException("Invalid seat number");
        }

        if (bus.isBooked(seat)) {
            throw new SeatAlreadyBookedException("Seat already booked");
        }

        if (bus.calculateFare() <= 0) {
            throw new InvalidFareException("Invalid fare");
        }

        Booking booking =
                new Booking(name, age, seat, window, bus);

        bus.bookSeat(seat);
        bookings.add(booking);

        return booking;
    }

    public Booking bookTicket(String name, int seat, Bus bus)
            throws InvalidSeatException,
            SeatAlreadyBookedException,
            InvalidAgeException,
            InvalidFareException {

        return bookTicket(name, 18, seat, false, bus);
    }

    public void cancelTicket(int bookingId)
            throws BookingNotFoundException {

        Booking found = null;

        for (Booking booking : bookings) {
            if (booking.getBookingId() == bookingId) {
                found = booking;
                break;
            }
        }

        if (found == null) {
            throw new BookingNotFoundException(
                    "Booking not found");
        }

        found.getBus().cancelSeat(found.getSeatNumber());
        bookings.remove(found);

        System.out.println("Ticket cancelled");
    }
}

public class BookingSystem {

    public static void main(String[] args) {

        Bus acBus = new ACBus(
                "AC101", "Bangalore - Mysore", 10, 500);

        Bus nonAcBus = new NonACBus(
                "NAC201", "Bangalore - Chennai", 10, 300);

        TicketBookingSystem system =
                new TicketBookingSystem();

        acBus.showBusDetails();
        nonAcBus.showBusDetails();

        try {
            Booking b1 = system.bookTicket(
                    "Adithya", 20, 1, true, acBus);

            b1.showBooking();

            Booking b2 = system.bookTicket(
                    "Rahul", 22, 2, nonAcBus);

            b2.showBooking();

            system.cancelTicket(b1.getBookingId());

            try {
                system.bookTicket(
                        "John", 25, 1, true, acBus);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            try {
                system.bookTicket(
                        "Kiran", 25, 50, acBus);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            try {
                system.bookTicket(
                        "Child", 2, 3, acBus);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            try {
                system.cancelTicket(999);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}