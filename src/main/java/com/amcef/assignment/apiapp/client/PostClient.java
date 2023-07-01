package com.amcef.assignment.apiapp.client;


import com.amcef.assignment.apiapp.dto.PostDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://jsonplaceholder.typicode.com/posts", name = "POST-CLIENT")
public interface PostClient {

    @GetMapping("/{id}")
    PostDTO getPost(@PathVariable Integer id);
}
