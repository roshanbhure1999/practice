package com.hotel.Hotel.service.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hotel.Hotel.service.entity.Hotel;

import java.util.List;

public interface HotelService {
    Hotel createHotel(Hotel hotel) throws JsonProcessingException;
    List<Hotel>  getAllHotel();
    String deleteHotelById(Long  id);
    Hotel getHotelById(Long id);

}
