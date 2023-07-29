package com.rating.contrller;

import com.rating.entity.Rating;
import com.rating.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/rating")
@RequiredArgsConstructor
public class RatingController {

    private final RatingService ratingService;

    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping
    public ResponseEntity<Rating> addCustomer(@Valid @RequestBody Rating rating) {
        return new ResponseEntity<>(ratingService.createRating(rating), HttpStatus.CREATED);
    }

    @GetMapping

    public ResponseEntity<List<Rating>> findCustomerById() {
        return ResponseEntity.ok(ratingService.getRating());
    }

    @GetMapping("/getById/{id}")
    @PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
    public ResponseEntity<List<Rating>> getByUserId(String s) {
        return ResponseEntity.ok(ratingService.getByUserId(s));
    }

    //get all of hotels
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId) {
        return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
    }

}
