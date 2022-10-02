package tr.com.id3.news.newsapi.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class ArticleDTO implements Serializable {
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;
    private String content;
}
