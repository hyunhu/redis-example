package com.example.car;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class CarServiceImpl implements CarService {

    private final CarRedisRepository carRedisRepository;

    @Override
    public Mono<Car> create(Car car) {
        return carRedisRepository.save(car);
    }

    @Override
    public Flux<Car> getAll() {
        return carRedisRepository.getAll();
    }

    @Override
    public Mono<Car> getOne(String id) {
        return carRedisRepository.get(id);
    }

    @Override
    public Mono<Long> deleteById(String id) {
        return carRedisRepository.delete(id);
    }
}
