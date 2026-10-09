package mctech.config.impl.internal;

import java.util.Objects;
import mctech.api.ILogger;
import org.apache.logging.log4j.Logger;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/impl/internal/ConfigLogger.class */
public class ConfigLogger implements ILogger {
    Logger logger;

    public ConfigLogger(Logger logger) {
        this.logger = logger;
    }

    @Override // mctech.api.ILogger
    public void debug(String str) {
        this.logger.debug(str);
    }

    @Override // mctech.api.ILogger
    public void debug(String str, Object obj) {
        this.logger.debug(str, obj);
    }

    @Override // mctech.api.ILogger
    public void debug(Object obj) {
        this.logger.debug(Objects.toString(obj));
    }

    @Override // mctech.api.ILogger
    public void info(String str) {
        this.logger.info(str);
    }

    @Override // mctech.api.ILogger
    public void info(String str, Object obj) {
        this.logger.info(str, obj);
    }

    @Override // mctech.api.ILogger
    public void info(Object obj) {
        this.logger.info(Objects.toString(obj));
    }

    @Override // mctech.api.ILogger
    public void warn(String str) {
        this.logger.warn(str);
    }

    @Override // mctech.api.ILogger
    public void warn(String str, Object obj) {
        this.logger.warn(str, obj);
    }

    @Override // mctech.api.ILogger
    public void warn(Object obj) {
        this.logger.warn(Objects.toString(obj));
    }

    @Override // mctech.api.ILogger
    public void error(String str) {
        this.logger.error(str);
    }

    @Override // mctech.api.ILogger
    public void error(String str, Object obj) {
        this.logger.error(str, obj);
    }

    @Override // mctech.api.ILogger
    public void error(Object obj) {
        this.logger.error(Objects.toString(obj));
    }
}
