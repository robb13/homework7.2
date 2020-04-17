package pl.bykowski.homework72.homework72.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.bykowski.homework72.homework72.dao.NewsDao;
import pl.bykowski.homework72.homework72.model.Article;

@Controller
public class NewsGui {

    private NewsDao newsDao;

    @Autowired
    public NewsGui(NewsDao newsDao) {
        this.newsDao = newsDao;

    }


    @GetMapping
    public String getNews(Model model) {
        model.addAttribute("articles", newsDao.findAll());
        model.addAttribute("update", new Article());
        return "index";
    }

    @PostMapping("/update-article")
    public String updateArticle(@RequestParam long articleId, String title, String description, String author) {
        newsDao.updateArticle(new Article(articleId, title, description, author));
        return "redirect:/";
    }


}
