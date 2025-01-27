package org.example.webservice.service.posts;


import lombok.RequiredArgsConstructor;
import org.example.webservice.domain.posts.CommentsRepository;
import org.example.webservice.domain.posts.Posts;
import org.example.webservice.domain.posts.PostsRepository;
import org.example.webservice.web.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CommentsService {

    private final CommentsRepository commentsRepository;

    @Transactional
    public Long save(CommentsSaveRequestDto requestDto){
        return commentsRepository.save(requestDto.toEntity()).getId();
    }

//    @Transactional
//    public Long update(Long id, PostsUpdateRequestDto requestDto){
//        Posts posts = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id = "+id));
//        posts.update(requestDto.getTitle(), requestDto.getContent());
//
//        return id;
//    }

//    @Transactional(readOnly = true)
//    public List<PostsListResponseDto> findAllDesc(){
//        return commentsRepository.findAllDesc().stream()
//                .map(PostsListResponseDto::new)
//                .collect(Collectors.toList());
//    }

//    @Transactional
//    public void delete(Long id){
//        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " +id));
//        postsRepository.delete(posts);
//    }
}
