package ibf2022.ssf.day12workshop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/workshop")
public class WorkshopController {

    // HANDLER method for GET request
    // GET method is used for retrieving data from a server, it is a safe and
    // idempotent method,
    // meaning multiple requests for the same resource will return the same result,
    // without causing any side effects.
    @GetMapping
    public String workshop() {

        return "workshop";
    }

    // Handler Method for POST Requests
    // POST method is used for creating new resources on a server, or updating
    // existing ones, it is not safe and not idempotent.
    @PostMapping("/processNumber")
    // line below: @RequestParam means it is requesting a parameter with the name "num" that is 
    // from a GET request which is from the @Getmapping
    public String processNumber(@RequestParam(name = "num", defaultValue = "1") int num, Model model) {

        System.out.println("The number is: " + num); // Test is num is passed
        model.addAttribute("num", num);
        model.addAttribute("numbersList", getNumber(num));
        return "workshopResult";
    }

    // The getNumber method creates an ArrayList containing different numbers of
    // size num
    public List<Integer> getNumber(int num) {

        // Instantiate an ArrayList to store different random numbers of count num
        List<Integer> randomNum = new ArrayList<>();

        int maxCount = num; // maxIndex of the randomNum list
        int count = 1; // Create count with initial value of 1

        // Define the range of 1 - 20 inclusive
        int max = 20;
        int min = 1;
        int range = max - min + 1;

        while (count <= maxCount) {

            int rand = (int) (Math.random() * range) + min;

            if (!randomNum.contains(rand)) {
                randomNum.add(rand);
                count++;
            }

        }

        return randomNum;
    } // End of getNumber method
}
