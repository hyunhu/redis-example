package com.example.car;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CarRepository {

    Mono<Car> save(Car car);

    Mono<Car> get(String key);

    Flux<Car> getAll();

    Mono<Long> delete(String id);
}
