package mctech.api.network.buffer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/network/buffer/GuiField.class */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface GuiField {
    String fieldName();

    int networkSyncRate() default 0;
}
