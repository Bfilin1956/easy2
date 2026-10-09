package mctech.api.addons;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/addons/MCTechPlugin.class */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MCTechPlugin {
    String name();

    String id();

    String version();

    int requiredAPIVersion() default 0;
}
