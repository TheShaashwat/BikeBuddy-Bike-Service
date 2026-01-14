package com.bike.service;

import com.bike.entity.Bike;
import com.bike.exception.BikeAlreadyExistsException;
import com.bike.exception.BikeNotFoundException;
import com.bike.repository.BikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BikeServiceImpl implements BikeService {

    private final BikeRepository bikeRepository;

    @Override
    public Bike createBike(Bike bike) {

        if (bikeRepository.existsByRegistrationNumber(
                bike.getRegistrationNumber())) {

            throw new BikeAlreadyExistsException(
                    "Bike already exists with registration number: "
                            + bike.getRegistrationNumber()
            );
        }

        if (bikeRepository.existsByRcNumber(bike.getRcNumber())) {

            throw new BikeAlreadyExistsException(
                    "Bike already exists with RC number: "
                            + bike.getRcNumber()
            );
        }

        return bikeRepository.save(bike);
    }


    @Override
    public Bike updateBike(Long id, Bike request) {

        Bike existing = bikeRepository.findById(id)
                .orElseThrow(() -> new BikeNotFoundException(
                        "Bike not found with id: " + id
                ));


        if (request.getUserId() != null)
            existing.setUserId(request.getUserId());

        if (request.getHourlyRate() != null)
            existing.setHourlyRate(request.getHourlyRate());

        if (request.getDailyRate() != null)
            existing.setDailyRate(request.getDailyRate());

        if (request.getWeeklyRate() != null)
            existing.setWeeklyRate(request.getWeeklyRate());

        if (request.getMonthlyRate() != null)
            existing.setMonthlyRate(request.getMonthlyRate());

        if (request.getSecurityDeposit() != null)
            existing.setSecurityDeposit(request.getSecurityDeposit());

        if (request.getStatus() != null)
            existing.setStatus(request.getStatus());

        if (request.getColor() != null)
            existing.setColor(request.getColor());

        if (request.getCity() != null)
            existing.setCity(request.getCity());

        if (request.getState() != null)
            existing.setState(request.getState());

        if (request.getIsActive() != null)
            existing.setIsActive(request.getIsActive());

        return bikeRepository.save(existing);
    }


    @Override
    public void deleteBike(Long id) {
        Bike bike = bikeRepository.findById(id)
                .orElseThrow(() ->
                        new BikeNotFoundException("Bike not found with id: " + id)
                );
        bikeRepository.delete(bike);
    }


    @Override
    public Bike getBikeById(Long id) {
        return bikeRepository.findById(id)
                .orElseThrow(() ->
                        new BikeNotFoundException("Bike not found with id: " + id)
                );
    }

    @Override
    public List<Bike> getAllBikes() {
        return bikeRepository.findAll();
    }
}
