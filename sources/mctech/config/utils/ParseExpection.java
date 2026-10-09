package mctech.config.utils;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/utils/ParseExpection.class */
public class ParseExpection {
    String value;
    Exception expection;
    String message;
    int index;

    public ParseExpection(String str, Exception exc, String str2) {
        this(str, exc, str2, -1);
    }

    public ParseExpection(String str, Exception exc, String str2, int i) {
        this.value = str;
        this.expection = exc;
        this.message = str2;
        this.index = i;
    }

    public String getValue() {
        return this.value;
    }

    public Exception getExpection() {
        return this.expection;
    }

    public String getMessage() {
        return this.message;
    }

    public int getIndex() {
        return this.index;
    }

    public ParseExpection withIndex(int i) {
        return new ParseExpection(this.value, this.expection, this.message, i);
    }
}
