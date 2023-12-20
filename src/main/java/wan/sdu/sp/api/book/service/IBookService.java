package wan.sdu.sp.api.book.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import wan.sdu.sp.api.book.mybatis.entity.Book;

public interface IBookService extends IService<Book> {
    public Page<Book> getPage(Integer cur,Integer size);
}
