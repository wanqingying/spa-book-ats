package wan.sdu.sp.api.uk.mybatis;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import wan.sdu.sp.api.uk.mybatis.entity.Uk;

@Mapper
public interface UkDao extends BaseMapper<Uk> {
    public void sayHi();
}
