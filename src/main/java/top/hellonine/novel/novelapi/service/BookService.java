package top.hellonine.novel.novelapi.service;

import org.springframework.stereotype.Service;
import top.hellonine.novel.novelapi.entity.BookEntity;

/**
 * User: Nine
 * Date: 2018/12/22
 * Time: 上午10:39
 */
@Service
public interface BookService {
    BookEntity getById(int id);

}
