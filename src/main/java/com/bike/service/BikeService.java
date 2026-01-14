package com.bike.service;


import com.bike.entity.Bike;

import java.util.List;

public interface BikeService {

    Bike createBike(Bike bike);

    Bike updateBike(Long id, Bike bike);

    void deleteBike(Long id);

    Bike getBikeById(Long id);

    List<Bike> getAllBikes();
}
