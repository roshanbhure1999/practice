package com.user.service.service.impl;

import com.user.service.dto.Hotel;
import com.user.service.dto.UserDto;
import com.user.service.entity.User;
import com.user.service.exception.ResourceNotFoundException;
import com.user.service.external.HotelService;
import com.user.service.repository.UserRepository;
import com.user.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RestTemplate  restTemplate;

    private final HotelService hotelService;
    private final Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public UserDto addUser(UserDto userDto) {

        User user = new User();
        user.setID(UUID.randomUUID().toString());
        BeanUtils.copyProperties(userDto, user);

        User save = userRepository.save(user);
        UserDto userDtoResponse = new UserDto();
        BeanUtils.copyProperties(save, user);
        return userDtoResponse;
    }

    @Override
    public UserDto findById(Long id) {
        User user = userRepository.findById(id.toString()).orElseThrow(ResourceNotFoundException::new);
        Hotel.Rating[] listOfRating = restTemplate.getForObject("rating/getById/"+id, Hotel.Rating[].class);
        logger.info("{}", (Object) listOfRating);
        List<Hotel.Rating> stream = Arrays.stream(Objects.requireNonNull(listOfRating)).toList();
        List<Hotel.Rating> collect = stream.stream().map(rating -> {
           // ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("hote/getby id", Hotel.class);
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        userDto.setRatings(collect);
        return userDto;
    }



    @Override
    public List<UserDto> findAll() {
        List<User> allUser = userRepository.findAll();
        return allUser.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public String deleteById(long id) {
        userRepository.deleteById(String.valueOf(id));
        return "user delete successfully";
    }

    public UserDto entityToDto(User user) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user,userDto);

        return userDto;
    }
}
