package romaninancoder.booking;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

//  to get jsonDoc  http://localhost:8090/jsondoc-ui.html


@RestController
@RequestMapping(value = "bookings")
@Api(name = "Hotel Booking API", description = "Application for booking hotels", stage= ApiStage.PRE_ALPHA)
public class BookingController {

    private BookingRepository bookingRepository;


    @Autowired
    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ApiMethod(description = "Gets the list of all booking")
    public List<HotelBooking> getAll() {
        return bookingRepository.findAll();
    }


    @RequestMapping(value = "/affordable/{price}", method = RequestMethod.GET)
    @ApiMethod(description = "Gets affortable hotels where price is less then provided value")
    public List<HotelBooking> getAffordable(@ApiPathParam(name="price") @PathVariable double price) {
        return bookingRepository.findByPricePerNightLessThanEqual(price);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ApiMethod(description = "Creates a new booking")
    public List<HotelBooking> create(@RequestBody HotelBooking hotelBooking) {
        bookingRepository.save(hotelBooking);
        return bookingRepository.findAll();
    }


    @RequestMapping(value="/delete/{id}", method = RequestMethod.POST)
    @ApiMethod(description = "Removes a booking")
    public List<HotelBooking> remove(@ApiPathParam(name="id") @PathVariable Long id) {
        bookingRepository.delete(id);
        return bookingRepository.findAll();
    }


}
