package com.hotel.Hotel.service.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hotel.Hotel.service.entity.Hotel;
import com.hotel.Hotel.service.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;
    @PostMapping
    public ResponseEntity<Hotel> addCustomer( @RequestBody Hotel hotel) throws JsonProcessingException {
        return new ResponseEntity<>(hotelService.createHotel(hotel), HttpStatus.CREATED);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Hotel> findCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(hotelService.getHotelById(id));
    }


    @GetMapping
    public ResponseEntity<List<Hotel>> findAll() {
        return ResponseEntity.ok(hotelService.getAllHotel());
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(hotelService.deleteHotelById(id));
    }
}
