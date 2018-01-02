package romaninancoder.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    private BookingRepository bookingRepository;

    @Autowired
    public DatabaseSeeder(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;

    }

    @Override
    public void run(String... var1) throws Exception {
        List<HotelBooking> bookings = new ArrayList<>();

        bookings.add(new HotelBooking("Marriot", 200.99, 3));
        bookings.add(new HotelBooking("Ibis", 99, 4));
        bookings.add(new HotelBooking("Novotel", 144.79, 1));

        bookingRepository.save(bookings);
    }
}
