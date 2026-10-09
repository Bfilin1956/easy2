package mctech.config;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import mctech.api.ConfigType;
import mctech.api.IConfigProxy;
import mctech.api.ILogger;
import mctech.api.SimpleConfigProxy;
import mctech.config.utils.AutomationType;
import mctech.config.utils.MultilinePolicy;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/ConfigSettings.class */
public class ConfigSettings {
    AutomationType[] auto;
    MultilinePolicy policy;
    ConfigType type;
    ILogger logger;
    IConfigProxy proxy;
    String subFolder;

    public static ConfigSettings of() {
        return new ConfigSettings();
    }

    public static ConfigSettings withPath(Path path) {
        return new ConfigSettings().withBaseFolder(path);
    }

    public static ConfigSettings withFolderProxy(IConfigProxy iConfigProxy) {
        return new ConfigSettings().withProxy(iConfigProxy);
    }

    public static ConfigSettings withConfigType(ConfigType configType) {
        return new ConfigSettings().withType(configType);
    }

    public static ConfigSettings withoutSettings() {
        return new ConfigSettings().noAutomations();
    }

    public static ConfigSettings withSettings(AutomationType automationType) {
        return new ConfigSettings().withAutomations(automationType);
    }

    public static ConfigSettings withLog(ILogger iLogger) {
        return new ConfigSettings().withLogger(iLogger);
    }

    public static ConfigSettings withFolder(String str) {
        return new ConfigSettings().withSubFolder(str);
    }

    public static ConfigSettings withLinePolicy(MultilinePolicy multilinePolicy) {
        return new ConfigSettings().withMultiline(multilinePolicy);
    }

    public ConfigSettings withBaseFolder(Path path) {
        return withProxy(new SimpleConfigProxy(path));
    }

    public ConfigSettings withProxy(IConfigProxy iConfigProxy) {
        if (this.proxy == null) {
            this.proxy = iConfigProxy;
        }
        return this;
    }

    public ConfigSettings noAutomations() {
        if (this.auto == null) {
            this.auto = new AutomationType[0];
        }
        return this;
    }

    public ConfigSettings withAutomations(AutomationType... automationTypeArr) {
        if (this.auto == null) {
            this.auto = automationTypeArr;
        }
        return this;
    }

    public ConfigSettings withMultiline(MultilinePolicy multilinePolicy) {
        if (this.policy == null) {
            this.policy = multilinePolicy;
        }
        return this;
    }

    public ConfigSettings withType(ConfigType configType) {
        if (this.type == null) {
            this.type = configType;
        }
        return this;
    }

    public ConfigSettings withLogger(ILogger iLogger) {
        if (this.logger == null) {
            this.logger = iLogger;
        }
        return this;
    }

    public ConfigSettings withSubFolder(String str) {
        if (this.subFolder == null) {
            this.subFolder = str;
        }
        return this;
    }

    public IConfigProxy getProxy() {
        return this.proxy;
    }

    public ILogger getLogger() {
        return this.logger;
    }

    public String getSubFolder() {
        return this.subFolder;
    }

    public ConfigType getType() {
        return this.type;
    }

    public EnumSet<AutomationType> getAutomationType() {
        return EnumSet.copyOf((Collection) Arrays.asList(this.auto));
    }

    public MultilinePolicy getMultilinePolicy() {
        return this.policy;
    }
}
