package wan.sdu.sp.api.book.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import wan.sdu.sp.api.book.mybatis.entity.Book;

@Mapper
public interface BookDao extends BaseMapper<Book> {

}
