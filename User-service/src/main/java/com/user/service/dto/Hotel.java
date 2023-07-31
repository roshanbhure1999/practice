package com.user.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    private String id;
    private String name;
    private String location;
    private String about;

    @Getter
    @Setter
    @AllArgsConstructor
    @RequiredArgsConstructor
    @Builder
    public static class Rating {

        private String ratingId;
        private String userId;
        private String hotelId;
        private int rating;
        private String feedback;
        private Hotel hotel;
    }
}
