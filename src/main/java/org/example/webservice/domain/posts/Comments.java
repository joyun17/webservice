package org.example.webservice.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.webservice.domain.BaseTimeEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Comments extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Long parentId;

    private String author;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String text;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Posts post;

    @ManyToOne
    @JoinColumn(name = "parent_comment_id")
    private Comments parentComment; // 대댓글 부모

    @OneToMany(mappedBy = "parentComment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comments> replies = new ArrayList<>(); // 대댓글 리스트
    @Builder
    public Comments(Long parentId, String author, String text, Posts post, Comments parentComment){
        this.parentId = parentId;
        this.author = author;
        this.text = text;
        this.post = post;
        this.parentComment = parentComment;
    }
}
