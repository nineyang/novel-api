package top.hellonine.novel.novelapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.hellonine.novel.novelapi.entity.BookEntity;
import top.hellonine.novel.novelapi.mapper.UserMapper;
import top.hellonine.novel.novelapi.service.BookService;

/**
 * User: Nine
 * Date: 2018/12/22
 * Time: 下午10:47
 */

@Service
public class BookServiceImpl implements BookService {

    @Override
    public BookEntity getById(int id) {
        return new BookEntity();
    }
}
