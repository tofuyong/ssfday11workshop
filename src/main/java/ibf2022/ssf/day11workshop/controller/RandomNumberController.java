package ibf2022.ssf.day11workshop.controller;

import java.security.SecureRandom;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path={"/" , "index.html"}, produces = MediaType.TEXT_HTML_VALUE)  
public class RandomNumberController {

    private Logger logger = Logger.getLogger(RandomNumberController.class.getName()); 

    @GetMapping("/")
    public String getNumber(Model model) {
        Random random = new SecureRandom();
        int number = random.nextInt(31);

        // Chuk's method
        String imgURL = "/images/number%d.jpg".formatted(number);
        logger.log(Level.INFO, "imgIndex = %d".formatted(number));
        model.addAttribute("imgUrl", imgURL);
        
        //My method
        model.addAttribute("number", number); // Bind value to model
        return "index"; // Render the template with model
    }

}
