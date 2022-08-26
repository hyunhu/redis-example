package com.example.car;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CarService {

    Mono<Car> create(Car car);

    Flux<Car> getAll();

    Mono<Car> getOne(String id);

    Mono<Long> deleteById(String id);
}
