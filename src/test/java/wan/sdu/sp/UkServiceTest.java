package wan.sdu.sp;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import wan.sdu.sp.api.uk.mybatis.entity.Uk;
import wan.sdu.sp.api.uk.service.impl.UkServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = JavaSduSpApplication.class)
public class UkServiceTest {
    @Autowired
    private UkServiceImpl ukService;

    @Test
    public void testUk(){
        Integer r=save(new Uk("uk1"));
        Uk u2=findById(r);
        String name=this.toString().substring(24);
        u2.setName(name);
        update(u2);
        Uk u3=findById(u2.getId());
        System.out.println("name="+u3.getName());
        assertEquals(u3,u2);
        remove(r);
        Uk u4=findById(r);
        assertNull(u4);
    }

    private Integer save(Uk uk){
       boolean b=  ukService.save(uk);
       assertTrue(b);
        return uk.getId();
    }
    private Uk findById(int id){
        return ukService.getById(id);
    }
    private void update(Uk uk){
         ukService.updateById(uk);
         Uk u2=ukService.getById(uk.getId());
         assertEquals(u2,uk);
    }
    private void remove(Integer id){
       boolean b= ukService.removeById(id);
       assertTrue(b);
    }

    @Test
    public void page(){
        Page<Uk> p = new Page<>(1, 4);
        Page<Uk> res = ukService.page(p, null);
        Long total=res.getTotal();
        if (total<=5){
            System.out.println("total less than 5");
        }
        List<Uk> data = res.getRecords();
        assertEquals(4,data.size());
        assertNotNull(data.get(0));
    }
}
