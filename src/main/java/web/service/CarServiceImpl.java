package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class CarServiceImpl implements CarService {

    private List<Car> listCars;

    public CarServiceImpl(List<Car> listCars) {
        this.listCars = listCars;
        listCars.add(new Car(1, "Toyota", "Camry"));
        listCars.add(new Car(2, "Honda", "Civic"));
        listCars.add(new Car(3, "Ford", "Fusion"));
        listCars.add(new Car(4, "Chevrolet", "Malibu"));
        listCars.add(new Car(5, "Nissan", "Almeria"));
    }

    @Override
    public List<Car> getListCars() {
        return listCars;
    }

    @Override
    public List<Car> getLimitedCarsList(int count) {
        return listCars.stream().limit(count).collect(Collectors.toList());
    }


}

