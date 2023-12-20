package wan.sdu.sp;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import wan.sdu.sp.api.uk.mybatis.UkDao;
import wan.sdu.sp.api.uk.mybatis.entity.Uk;

@SpringBootTest
class JavaSduSpApplicationTests {

    @Autowired
    private UkDao ukDao;
    @Test
    void contextLoads() {
        Uk uk=ukDao.selectById(1);
        assertEquals(uk.getId(),1);
    }

}
