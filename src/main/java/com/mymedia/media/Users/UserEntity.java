package com.mymedia.media.Users;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ManyToAny;

import com.mymedia.media.Articles.ArticleEntity;
import com.mymedia.media.common.BaseEntity;

public class UserEntity extends BaseEntity {

    String userName;

    String password;

    String email;

    String bio;

    String image;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<ArticleEntity> authoredArticles;
    
    @ManyToMany(mappedBy = "likers", fetch = FetchType.LAZY)
    Set<ArticleEntity> likedArticles;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "follow", joinColumns = @JoinColumn(name = "following_id"),
            inverseJoinColumns = @JoinColumn(name = "follower_id"))
    Set<UserEntity> followers;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "followers")
    Set<UserEntity> following;
}
