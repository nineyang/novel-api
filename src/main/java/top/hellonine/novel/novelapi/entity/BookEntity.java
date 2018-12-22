package top.hellonine.novel.novelapi.entity;

import org.apache.ibatis.annotations.Mapper;

/**
 * User: Nine
 * Date: 2018/12/21
 * Time: 下午5:24
 */

public class BookEntity {


    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
