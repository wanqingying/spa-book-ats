package wan.sdu.sp.api.book.mybatis.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Book {
    private String bookName;
    private String bookDesc;
    private Integer bookType;
    private String bookAuthor;

    @TableId
    private Integer bookId;

    public Book() {
    }

    public Book(String bookName, String bookDesc, Integer bookType, String bookAuthor, Integer bookId) {
        this.bookName = bookName;
        this.bookDesc = bookDesc;
        this.bookType = bookType;
        this.bookAuthor = bookAuthor;
        this.bookId = bookId;
    }
}
