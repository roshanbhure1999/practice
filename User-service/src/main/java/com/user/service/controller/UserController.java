package com.user.service.controller;

import com.user.service.dto.UserDto;
import com.user.service.service.UserService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    @PostMapping
    public ResponseEntity<UserDto> addCustomer(@Valid @RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.addUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping("/getById/{id}")
    @RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelFallback")
    //@Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallback")
   // @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<UserDto> findCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }



    public ResponseEntity<UserDto> ratingHotelFallback(String userId, Exception ex) {
//        logger.info("Fallback is executed because service is down : ", ex.getMessage());

        ex.printStackTrace();

        UserDto user = UserDto.builder().email("dummy@gmail.com").name("Dummy").about("This user is created dummy because some service is down").ID("141234").build();
        return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
    }


    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteById(@PathVariable long id) {
        return ResponseEntity.ok(userService.deleteById(id));
    }
}
