package wan.sdu.sp.base;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler
    public Ping doException(Exception e){
        return Ping.fail(e.getMessage());
    }

}
