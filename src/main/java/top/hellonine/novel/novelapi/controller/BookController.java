package top.hellonine.novel.novelapi.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.hellonine.novel.novelapi.annotation.LoginRequired;
import top.hellonine.novel.novelapi.entity.BookEntity;
import top.hellonine.novel.novelapi.entity.UserEntity;
import top.hellonine.novel.novelapi.service.BookService;
import top.hellonine.novel.novelapi.util.Response;


/**
 * User: Nine
 * Date: 2018/12/22
 * Time: 上午10:38
 */


@RestController
@RequestMapping("/books")
public class BookController {


    @Autowired
    private BookService bookService;

    @LoginRequired
    @GetMapping("{id}")
    public Object detail(@PathVariable int id, @RequestAttribute(name = "currentUser") UserEntity currentUser) {

        BookEntity bookEntity = bookService.getById(id);
        return Response.factory().set("book", bookEntity).succeed();
    }


}
