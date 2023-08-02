package com.user.service.contrller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public abstract class AbstractTest  {

    public static final String POST = "post";
    public static final String GET = "get";
    public static final String DELETE = "delete";
    public static final String PUT = "put";
    protected MockMvc mockMvc ;
    protected ObjectMapper objectMapper = new ObjectMapper();

    public MvcResult prePerformCheck(String methodName, String url, Object body, String content, HttpHeaders  httpHeaders, ResultMatcher resultMatcher) throws Exception {
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = null;

        switch (methodName.toLowerCase()) {
            case GET -> mockHttpServletRequestBuilder = MockMvcRequestBuilders.get(url);
            case PUT -> mockHttpServletRequestBuilder = MockMvcRequestBuilders.post(url);
            case POST -> mockHttpServletRequestBuilder = MockMvcRequestBuilders.put(url);
            case DELETE -> mockHttpServletRequestBuilder = MockMvcRequestBuilders.delete(url);
        }
//        if (Objects.nonNull(content)){
//            mockHttpServletRequestBuilder=MockMvcRequestBuilders.
//        }
//        if (Objects.nonNull())
//        if (Objects.nonNull())
//        if (Objects.nonNull())
//            MvcResult mvcResult=httpHeaders

            return  mockMvc.perform(mockHttpServletRequestBuilder).andExpect(resultMatcher).andReturn();

    }

}
