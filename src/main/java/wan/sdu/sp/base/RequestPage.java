package wan.sdu.sp.base;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

public class RequestPage extends Page {
    public RequestPage(long current, long size) {
        super(current, size);
    }

}
