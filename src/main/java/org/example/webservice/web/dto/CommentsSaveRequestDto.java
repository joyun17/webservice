package org.example.webservice.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.webservice.domain.posts.Comments;
import org.example.webservice.domain.posts.Posts;

@Getter
@NoArgsConstructor
public class CommentsSaveRequestDto {
    private Long parentId;
    private String text;
    private String author;

    @Builder
    public CommentsSaveRequestDto(Long parentId, String text, String author){
        this.parentId = parentId;
        this.text = text;
        this.author = author;
    }
    public Comments toEntity(){
        return Comments.builder()
                .text(text)
                .parentId(parentId)
                .author(author)
                .build();
    }

}
