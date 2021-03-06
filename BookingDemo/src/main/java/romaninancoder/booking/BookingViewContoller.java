package romaninancoder.booking;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class BookingViewContoller {

    /*
    @Value("${app-mode}")
    private String appMode;
    */
    private String appMode;


    @Autowired
    BookingViewContoller(Environment environment) {
        appMode = environment.getProperty("app-mode");
    }

    @RequestMapping("/")
    public String booking(Model model) {
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "Marko Ziza");
        model.addAttribute("mode", appMode);
        return "booking";
    }

}
