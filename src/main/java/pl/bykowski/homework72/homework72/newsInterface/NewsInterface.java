package pl.bykowski.homework72.homework72.newsInterface;

import pl.bykowski.homework72.homework72.model.Article;

import java.util.List;

public interface NewsInterface {
    List<Article> findAll();

    void saveArticleFromApi();

    void  updateArticle(Article newArticle);

}
