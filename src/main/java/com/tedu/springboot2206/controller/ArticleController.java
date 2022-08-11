package com.tedu.springboot2206.controller;

import com.tedu.springboot2206.entity.Article;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

@Controller
public class ArticleController {
    private static File articleDir;
    static {
        articleDir = new File("articles");
        if(!articleDir.exists()){
            articleDir.mkdirs();
        }
    }

    @RequestMapping("/writeArticle")
    public void writeArticle(HttpServletRequest request, HttpServletResponse response){
        System.out.println("处理发表文章!!!!!!!!!!!");
        //获取表单数据
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String content = request.getParameter("content");
        System.out.println(title+","+author+","+content);

        //数据验证
        if(title==null||title.trim().isEmpty()||
           author==null||author.trim().isEmpty()||
           content==null||content.trim().isEmpty()){
            try {
                response.sendRedirect("/article_fail.html");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }

        Article article = new Article(title,author,content);

        File file = new File(articleDir,title+".obj");
        try (
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ){
           oos.writeObject(article);
           response.sendRedirect("/article_success.html");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
