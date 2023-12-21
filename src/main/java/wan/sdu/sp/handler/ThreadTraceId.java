package wan.sdu.sp.handler;

public class ThreadTraceId {
    private static final InheritableThreadLocal<String> trace = new InheritableThreadLocal<>();

    public static void set(String traceId) {
        trace.set(traceId);
    }

    public static String get() {
        return trace.get();
    }

    public static void remove() {
        trace.remove();
    }
}
