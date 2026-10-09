package mctech.api;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/ILogger.class */
public interface ILogger {
    void debug(String str);

    void debug(String str, Object obj);

    void debug(Object obj);

    void info(String str);

    void info(String str, Object obj);

    void info(Object obj);

    void warn(String str);

    void warn(String str, Object obj);

    void warn(Object obj);

    void error(String str);

    void error(String str, Object obj);

    void error(Object obj);
}
