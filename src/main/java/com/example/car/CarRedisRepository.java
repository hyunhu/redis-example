package com.example.car;

import com.example.configration.ObjectMapperUtils;
import com.example.configration.ReactiveRedisComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.example.configration.ObjectMapperUtils.CAR_KEY;

@Repository
@RequiredArgsConstructor
public class CarRedisRepository implements CarRepository {

    private final ReactiveRedisComponent reactiveRedisComponent;

    @Override
    public Mono<Car> save(Car car) {
        return reactiveRedisComponent.set(CAR_KEY, car.getId(), car).map(d -> car);
    }

    @Override
    public Mono<Car> get(String key) {
        return reactiveRedisComponent.get(CAR_KEY, key).flatMap(d -> Mono.just(ObjectMapperUtils.objectMapper(d, Car.class)));
    }

    @Override
    public Flux<Car> getAll() {
        return reactiveRedisComponent.get(CAR_KEY).map(d -> ObjectMapperUtils.objectMapper(d, Car.class))
                .collectList().flatMapMany(Flux::fromIterable);
    }

    @Override
    public Mono<Long> delete(String id) {
        return reactiveRedisComponent.remove(CAR_KEY, id);
    }

}
