package tr.com.id3.news.newsapi.model;

import lombok.Data;

@Data
public class ArticleInDTO{
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;
    private String content;
}
