package wan.sdu.sp.api.book.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wan.sdu.sp.api.book.mybatis.BookDao;
import wan.sdu.sp.api.book.mybatis.entity.Book;
import wan.sdu.sp.api.book.service.IBookService;

@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {
    private BookDao bookDao;
    @Autowired
    public void bookDao(BookDao bok){
        this.bookDao=bok;
    }
    @Override
    public Page<Book> getPage(Integer cur, Integer size) {
        return this.bookDao.selectPage(new Page<>(cur.longValue(),size.longValue()),null);
    }
    public Page<Book> getPage(String cur, String size) {
        return this.bookDao.selectPage(new Page<>(Long.parseLong(cur),Long.parseLong(size)),null);
    }
    public Page<Book> filter(Integer cur, Integer size,Book book) {
        LambdaQueryWrapper<Book> qw = new LambdaQueryWrapper<Book>();
        qw.like(Strings.isNotEmpty(book.getBookName()),Book::getBookName,book.getBookName());
        qw.like(Strings.isNotEmpty(book.getBookAuthor()), Book::getBookAuthor, book.getBookAuthor());
        return this.bookDao.selectPage(new Page<>(cur.longValue(),size.longValue()),qw);
    }
}
