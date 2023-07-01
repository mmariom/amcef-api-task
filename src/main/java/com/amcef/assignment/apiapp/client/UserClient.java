package com.amcef.assignment.apiapp.client;


import com.amcef.assignment.apiapp.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://jsonplaceholder.typicode.com/users", name = "USER-CLIENT")
public interface UserClient {

    @GetMapping("/{id}")
    UserDTO getUser(@PathVariable Integer id);
}
