package org.example.webservice.web.dto;

import lombok.Getter;
import org.example.webservice.domain.posts.Comments;
import org.example.webservice.domain.posts.Posts;

import java.time.LocalDateTime;

@Getter
public class CommentsListResponseDto {
    private Long id;
    private Long parentId;
    private String text;
    private String author;
    private LocalDateTime modifiedDate;

    public CommentsListResponseDto(Comments entity){
        this.id = entity.getId();
        this.text = entity.getText();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }
}
