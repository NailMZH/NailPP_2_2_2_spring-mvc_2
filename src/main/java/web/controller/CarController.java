package web.controller;

import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.service.CarServiceImpl;

import java.util.List;

@Controller
public class CarController {
    @Autowired
    CarServiceImpl carService;

    @GetMapping(value = "/cars")
    public String getCars(@RequestParam(required = false) Integer count, ModelMap model) {

        List<Car> cars = null;
        if (count != null && count > 0 && count < 5) {
            cars = carService.getLimitedCarsList(count);
        } else {
            cars = carService.getListCars();
        }
        model.addAttribute("cars", cars);
        return "cars";
    }
}
