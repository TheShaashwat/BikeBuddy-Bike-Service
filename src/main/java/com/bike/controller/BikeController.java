package com.bike.controller;

import com.bike.dto.ApiResponse;
import com.bike.entity.Bike;
import com.bike.service.BikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bikes")
@RequiredArgsConstructor
public class BikeController {

    private final BikeService bikeService;

    // INSERT
    @PostMapping
    public ResponseEntity<ApiResponse<Bike>> create(@RequestBody Bike bike) {
        return ResponseEntity.ok(
                ApiResponse.success(bikeService.createBike(bike))
        );
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Bike>> update(
            @PathVariable Long id,
            @RequestBody Bike bike) {

        return ResponseEntity.ok(
                ApiResponse.success(bikeService.updateBike(id, bike))
        );
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> delete(@PathVariable Long id) {
        bikeService.deleteBike(id);
        return ResponseEntity.ok(
                ApiResponse.success("Bike deleted successfully")
        );
    }

    // SELECT BY ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Bike>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(
                ApiResponse.success(bikeService.getBikeById(id))
        );
    }

    // SELECT ALL
    @GetMapping
    public ResponseEntity<ApiResponse<List<Bike>>> getAll() {
        return ResponseEntity.ok(
                ApiResponse.success(bikeService.getAllBikes())
        );
    }
}
