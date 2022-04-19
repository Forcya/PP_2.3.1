package web.service;

import org.springframework.stereotype.Service;
import web.entity.Car;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {


    @Override
    public List<Car> getNumberOfCars(List<Car> cars, int a) {
        cars = cars.stream().limit(a).collect(Collectors.toList());
        return cars;
    }
}
