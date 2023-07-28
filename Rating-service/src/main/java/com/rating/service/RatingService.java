package com.rating.service;

import com.rating.entity.Rating;

import java.util.List;

public interface RatingService {

    Rating createRating(Rating rating);
    List<Rating> getRating();
    List<Rating> getByUserId(String id);
    List<Rating> getRatingByHotel(String userId);

}
