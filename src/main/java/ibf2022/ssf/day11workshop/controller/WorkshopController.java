package ibf2022.ssf.day11workshop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path="/workshop")
public class WorkshopController {

    @GetMapping
    public String workshop() {
        return "workshop";
    }

    @PostMapping("/processNumber")  //very important as links to processNumber action in html file
    public String processNumber(@RequestParam(name="inputNumber", defaultValue="1") Integer unit, Model model) {

        //need list to keep track of generated numbers
        List<Integer> listIntegers = new ArrayList<Integer>();
        
        Integer loopValue = unit;
        Integer currentValue = 1;

        while(currentValue <= loopValue) {
            int result = (int) (Math.random() * loopValue) + 1;  //plus one because we do not want value to be zero, generate results between 1-20

            if (!listIntegers.contains(Integer.valueOf(result))) {
                listIntegers.add(Integer.valueOf(result)); //if list d/n contain this random value then add it
                currentValue++; 
            }
        }

        model.addAttribute("numbers", listIntegers);

        return "workshopresult";
    }
    
}
