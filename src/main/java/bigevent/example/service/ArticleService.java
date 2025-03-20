package bigevent.example.service;

import bigevent.example.pojo.Article;
import bigevent.example.pojo.PageBean;

public interface ArticleService {
    // 新增文章
    void add(Article article);

    // 条件分类列表查询
    PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state);
}
