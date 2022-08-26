package com.example.car;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class CarController {

    private final CarServiceImpl carService;

    @PostMapping("/car")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Car> addCar(@RequestBody @Valid Car car) {
        return carService.create(car);
    }

    @GetMapping("/car")
    public Flux<Car> getAllCar() {
        return carService.getAll();
    }

    @GetMapping("/car/{id}")
    public Mono<Car> getCar(@PathVariable String id) {
        return carService.getOne(id);
    }

    @DeleteMapping("/car/{id}")
    public Mono<Long> deleteCar(@PathVariable String id) {
        return carService.deleteById(id);
    }

}
