package com.user.service.contrller;

import com.user.service.controller.UserController;
import com.user.service.dto.UserDto;
import com.user.service.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

public class UserControllerTest extends AbstractTest {


    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    void findAllTest() throws Exception {
        UserDto userDto=new UserDto();
        Mockito.when(userService.findAll()).thenReturn(List.of(userDto));

        prePerformCheck(GET, "/user", null, null, null, MockMvcResultMatchers.status().isOk());


    }

    @Test
    void deleteByIdTest() throws Exception {

        Mockito.when(userService.deleteById(1)).thenReturn("user delete successfully");

        prePerformCheck(DELETE, "/user/delete/1", null, null, null, MockMvcResultMatchers.status().isOk());


    }
}
