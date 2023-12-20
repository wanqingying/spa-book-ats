package wan.sdu.sp.base;

public class Ping<T> extends BaseResponse<T> {
    public Ping(T data) {
        super(data);
    }
    public Ping(T data,Integer code,String msg) {
        super(data);
        this.setCode(code);
        this.setMessage(msg);
    }

    public  static <T>
    Ping<T> suc(T data){
        return new Ping<>(data,0,"ok");
    }
    public  static <T>
    Ping<T> fail(String msg,Integer code,T data){
        return new Ping<>(data,code,msg);
    }
    public  static Ping<Object> fail(String msg){
        return new Ping<Object>(null,-1,msg);
    }
    public  static Ping<Object> koa(PingKoa koa){
        try {
            Object obj=koa.exec();
            return Ping.suc(obj);
        }catch (Exception e){
            return Ping.fail(e.getMessage());
        }
    }

    public static Ping fail(String msg, int i) {
        return new Ping<Object>(null,i,msg);
    }
}


