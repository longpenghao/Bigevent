package bigevent.example.mapper;

import bigevent.example.pojo.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import bigevent.example.mapper.ArticleMapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@Mapper
//@MapperScan("bigevent.example.mapper.ArticleMapper.xml") // 这会自动扫描并注册映射接口
public interface ArticleMapper {
    // 新增文章
    @Insert("insert into article(title,content,cover_img,state,category_id,create_user,create_time,update_time) " +
            "values(#{title},#{content},#{coverImg},#{state},#{categoryId},#{createUser},#{createTime},#{updateTime})")
    void add(Article article);

    // 条件分类列表查询
    List<Article> list(Integer userId, Integer categoryId, String state);

}
