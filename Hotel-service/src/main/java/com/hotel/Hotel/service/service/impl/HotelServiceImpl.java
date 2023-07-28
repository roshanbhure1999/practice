package com.hotel.Hotel.service.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotel.Hotel.service.entity.Hotel;
import com.hotel.Hotel.service.repository.HotelRepository;
import com.hotel.Hotel.service.service.HotelService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class HotelServiceImpl implements HotelService {

private final HotelRepository hotelRepository;



    @Autowired
    KafkaTemplate kafkaTemplate;
    @Override
    public Hotel createHotel(Hotel hotel) throws JsonProcessingException {
        Hotel save = hotelRepository.save(hotel);
        kafkaTemplate.send("MYtOPIC",save);
        return save;
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();
    }

    @Override
    public String deleteHotelById(Long id) {
         hotelRepository.deleteById(id);
        return "Hotel delete successfully....";
    }

    @Override
    public Hotel getHotelById(Long id) {
        return hotelRepository.getById(id);
    }
}
