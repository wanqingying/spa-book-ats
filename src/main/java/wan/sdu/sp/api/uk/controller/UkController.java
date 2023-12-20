package wan.sdu.sp.api.uk.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wan.sdu.sp.base.BaseResponse;
import wan.sdu.sp.base.Ping;
import wan.sdu.sp.api.uk.mybatis.entity.Uk;
import wan.sdu.sp.api.uk.service.impl.UkServiceImpl;

@RestController
@RequestMapping(path = "uk")
public class UkController {

    private UkServiceImpl ukService;
    @Autowired
    public void ukService(UkServiceImpl ukService){
        this.ukService=ukService;
    };

    @PostMapping
    public BaseResponse<Boolean> save(@RequestBody Uk uk){
       boolean ok = ukService.save(uk);
       return new Ping(ok);
    }

    @GetMapping("page")
    public Ping<Page<Uk>> getUkPage(@RequestParam Integer current,@RequestParam Integer size){
        Page p=new Page<Uk>(current,size);
        ukService.page(p);
        return new Ping<>(p);
    }

    @DeleteMapping("{id}")
    public Ping<Object> remove(@PathVariable Integer id){
        boolean res = ukService.removeById(id);
        return res?Ping.suc(true):Ping.fail("not exist");
    }

    @PutMapping
    public Ping<Boolean> update(@RequestBody Uk uk){
        boolean res = ukService.updateById(uk);
        return new Ping(res);
    }

    @GetMapping("{id}")
    public Ping getById(@PathVariable Integer id){
        return Ping.koa(()->ukService.getById(id));
    }


}
