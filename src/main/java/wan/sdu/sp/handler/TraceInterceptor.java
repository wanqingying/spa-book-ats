package wan.sdu.sp.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import wan.sdu.sp.base.BaseLog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TraceInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String traceId = request.getHeader("TraceId");
        if (traceId == null) {
            traceId = java.util.UUID.randomUUID().toString();
        }
        ThreadTraceId.set(traceId);
        response.setHeader("TraceId", traceId);
        System.out.println("preHandle TraceId: " + traceId);
        BaseLog.info(new BaseLog.LogObj("preHandle TraceId: " + traceId, null));
        return true;
    }

    @Override
    public void postHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler, org.springframework.web.servlet.ModelAndView modelAndView) throws Exception {
        String traceId = ThreadTraceId.get();
        System.out.println("postHandle TraceId: " + traceId);
    }

    @Override
    public void afterCompletion(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ThreadTraceId.remove();
        System.out.println("afterCompletion");
    }


}
