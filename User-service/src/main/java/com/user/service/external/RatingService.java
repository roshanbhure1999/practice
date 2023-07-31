package com.user.service.external;

import com.user.service.dto.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Service
@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    @PostMapping("/ratings")
    public ResponseEntity<Hotel.Rating> createRating(Hotel.Rating values);


    //PUT
    @PutMapping("/ratings/{ratingId}")
    public ResponseEntity<Hotel.Rating> updateRating(@PathVariable("ratingId") String ratingId, Hotel.Rating rating);


    @DeleteMapping("/ratings/{ratingId}")
    public void deleteRating(@PathVariable String ratingId);
}
