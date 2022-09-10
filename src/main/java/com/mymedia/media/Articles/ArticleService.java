package com.mymedia.media.Articles;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.ui.ModelMap;


public class ArticleService {
    
    private ArticleRepo articleRepo;
    private ModelMapper modelMapper;
    public ArticleService(ArticleRepo articleRepo){
        this.articleRepo = articleRepo;
    }

    List<ArticleEntity> getAllArticles(){
        return articleRepo.findAll();
    }

    public ArticleDTO findArticlebyId(Long id){
        var article = articleRepo.findById(id).orElseThrow(()-> new ArticleNotFoundException(id));
        
    } 


    static class ArticleNotFoundException extends IllegalArgumentException{
        public ArticleNotFoundException(long id){
            super("Task not Found");
        }
    }
}
