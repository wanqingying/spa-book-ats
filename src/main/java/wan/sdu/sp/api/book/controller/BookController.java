package wan.sdu.sp.api.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wan.sdu.sp.api.book.mybatis.entity.Book;
import wan.sdu.sp.api.book.service.impl.BookServiceImpl;
import wan.sdu.sp.base.Ping;

import java.util.Map;

@RestController
@RequestMapping("book")
public class BookController {
    private BookServiceImpl bookService;
    @Autowired
    public void bookService(BookServiceImpl bok){
        this.bookService=bok;
    }

    @PostMapping
    public Ping save(@RequestBody Book book){
        return Ping.koa(()->{
            return bookService.save(book);
        });
    }
    @DeleteMapping("{id}")
    public Ping remove(@PathVariable Integer id){
        return Ping.koa(()->{
            return bookService.removeById(id);
        });
    }
    @PutMapping
    public Ping update(@RequestBody Book book){
        return Ping.koa(()->{
           if (book.getBookId()==null){
               throw new Exception("book.id is null");
           }else{
               return bookService.updateById(book);
           }
        });
    }

    @GetMapping("{id}")
    public Ping getById(@PathVariable Integer id) throws Exception {
        if (id==1)throw new Exception("id不能为1");
        Book res = bookService.getById(id);
        return res==null?Ping.fail("not exist",2): Ping.suc(res);
    }

    @GetMapping("/{current}/{size}")
    public Ping getByPage(@PathVariable Integer current,@PathVariable Integer size){
        return Ping.koa(()-> bookService.getPage(current,size));
    }

    @GetMapping("/page")
    public Ping getSortPage(@RequestParam Map<String,Object> m){
        return Ping.koa(()-> bookService.getPage((String) m.get("current"), (String) m.get("size")));
    }
    @PostMapping("/filter")
    public Ping filterPage(@RequestBody Map<String,Object> m){
        Book book=new Book();
        book.setBookName((String) m.get("bookName"));
        book.setBookAuthor((String) m.get("bookAuthor"));
        return Ping.koa(()-> bookService.filter((Integer) m.get("current"), (Integer) m.get("size"),book));
    }



}
