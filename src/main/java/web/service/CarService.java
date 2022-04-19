package web.service;

import web.entity.Car;

import java.util.List;

public interface CarService {
    public List<Car> getNumberOfCars(List<Car> cars, int a);
}