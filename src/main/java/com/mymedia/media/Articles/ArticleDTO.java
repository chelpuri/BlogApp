package com.mymedia.media.Articles;

import org.springframework.lang.Nullable;

import com.mymedia.media.Users.UserEntity;

import lombok.Data;

@Data
public class ArticleDTO {
 
    @Nullable
    String title;

    @Nullable
    String slug;

    @Nullable
    String subTitle;

    String body;

    UserEntity author;
}
