package org.example.webservice.web;

import lombok.RequiredArgsConstructor;
import org.example.webservice.service.posts.PostsService;
import org.example.webservice.web.dto.PostsSaveRequestDto;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }
}
