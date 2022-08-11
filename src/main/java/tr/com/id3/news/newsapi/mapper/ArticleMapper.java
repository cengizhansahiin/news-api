package tr.com.id3.news.newsapi.mapper;

import org.springframework.stereotype.Component;
import tr.com.id3.news.newsapi.model.Article;
import tr.com.id3.news.newsapi.model.ArticleInDTO;

import java.sql.Date;

@Component
public class ArticleMapper {
    public Article dtoToArticle (ArticleInDTO articleInDTO){
        Article article = new Article();
        article.setAuthor(articleInDTO.getAuthor());
        article.setTitle(articleInDTO.getTitle());
        article.setDescription(articleInDTO.getDescription());
        article.setUrl(articleInDTO.getUrl());
        article.setUrlToImage(articleInDTO.getUrlToImage());
        article.setPublishedAt(articleInDTO.getPublishedAt());
        article.setContent(articleInDTO.getContent());
        Date date = new Date(System.currentTimeMillis());
        article.setCreate_date(date);
        article.setUpdate_date(date);
        return article;
    }
}
