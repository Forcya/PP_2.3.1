package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.entity.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {

    @Autowired
    private CarService carService;


    public List<Car> getCars () {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("BMW", "M5", "sedan"));
        cars.add(new Car("BMW", "X5M", "SUV"));
        cars.add(new Car("MB", "A-class", "hatchback"));
        cars.add(new Car("Skoda", "Octavia", "liftback"));
        cars.add(new Car("Audi", "RS5", "coupe"));
        return cars;
    }


    @RequestMapping(value = "/cars")
    public String deleteEmployee(@RequestParam(value = "count",defaultValue = "5") int carsNumber, Model model) {

        if (carsNumber == 0) {
            carsNumber = 5;
        }

        List<Car> upgradeCarsList = carService.getNumberOfCars(getCars(),carsNumber);
        model.addAttribute("listCars", upgradeCarsList);

        return "cars";
    }
}
