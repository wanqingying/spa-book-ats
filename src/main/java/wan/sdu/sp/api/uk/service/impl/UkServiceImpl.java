package wan.sdu.sp.api.uk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wan.sdu.sp.api.uk.mybatis.UkDao;
import wan.sdu.sp.api.uk.mybatis.entity.Uk;
import wan.sdu.sp.api.uk.service.IUkService;

@Service
public class UkServiceImpl extends ServiceImpl<UkDao, Uk> implements IUkService  {
}
