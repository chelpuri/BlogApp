package com.mymedia.media.comments;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.mymedia.media.Articles.ArticleEntity;

public class CommentEntity {
    

    @ManyToOne
    @JoinColumn(name = "article_id", nullable = false)
    ArticleEntity article;
}
