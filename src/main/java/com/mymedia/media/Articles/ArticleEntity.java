package com.mymedia.media.Articles;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.print.DocFlavor.STRING;
import javax.websocket.Decoder.Text;

import org.apache.catalina.User;

import com.mymedia.media.Users.UserEntity;
import com.mymedia.media.comments.CommentEntity;
import com.mymedia.media.common.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Articles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleEntity extends BaseEntity {
    
    @Column(length = 100, nullable = false)
    String title;

    @Column(length = 100, nullable = false, unique = true)
    String slug;

    @Column(length = 150)
    String subTitle;

    @Column(columnDefinition = "Text")
    String body;

    @ManyToOne
    @JoinColumn(name = "author_id")
    UserEntity author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "likes",
        joinColumns = @JoinColumn(name = "article_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id"))
    Set<UserEntity> likers;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    Set<CommentEntity> comments;
}
