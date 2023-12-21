package wan.sdu.sp.base;

import org.slf4j.Logger;
import wan.sdu.sp.handler.ThreadTraceId;

public class BaseLog {
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(BaseLog.class);

    public static void error(LogObj obj) {
        logger.error(obj.toString());
    }

    public static void info(LogObj obj) {
        logger.info(obj.toString());
    }

    public static void debug(LogObj obj) {
        logger.debug(obj.toString());
    }

    public static void warn(LogObj obj) {
        logger.warn(obj.toString());
    }

    public static void trace(LogObj obj) {
        logger.trace(obj.toString());
    }


    public static final class LogObj {
        private String msg;
        private Throwable e;

        private String traceId;

        public LogObj(String msg, Throwable e) {
            this.msg = msg;
            this.e = e;
            this.traceId = ThreadTraceId.get();
        }

        public LogObj(String msg) {
            this.msg = msg;
            this.traceId = ThreadTraceId.get();
        }

        public LogObj(Throwable e) {
            this.msg = e.getMessage();
            this.e = e;
            this.traceId = ThreadTraceId.get();
        }

        public String getMsg() {
            return msg;
        }

        public Throwable getE() {
            return e;
        }


        // toString with json format
        public String toString() {
            return "{msg: " + msg + ", traceId: " + traceId + ", e: " + e + "}";
        }
    }
}
