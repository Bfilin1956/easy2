package mctech.config.utils;

import java.util.Objects;
import java.util.function.Function;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/utils/ParseResult.class */
public class ParseResult<T> {
    private final T value;
    private final ParseExpection error;

    private ParseResult(T t, ParseExpection parseExpection) {
        this.value = t;
        this.error = parseExpection;
    }

    public static ParseResult<Boolean> result(boolean z, Function<String, Exception> function, String str) {
        return new ParseResult<>(Boolean.valueOf(z), z ? null : new ParseExpection(null, function.apply(str), str));
    }

    public static <T> ParseResult<T> successOrError(T t, boolean z, Function<String, Exception> function, String str) {
        return new ParseResult<>(t, z ? null : new ParseExpection(null, function.apply(str), str));
    }

    public static <T> ParseResult<T> success(T t) {
        return new ParseResult<>(t, null);
    }

    public static <T> ParseResult<T> partial(T t, Exception exc) {
        return new ParseResult<>(t, new ParseExpection(null, exc, null));
    }

    public static <T> ParseResult<T> partial(T t, Function<String, Exception> function, String str) {
        return new ParseResult<>(t, new ParseExpection(null, function.apply(str), str));
    }

    public static <T> ParseResult<T> partial(T t, ParseExpection parseExpection) {
        return new ParseResult<>(t, parseExpection);
    }

    public static <T> ParseResult<T> error(String str, Exception exc) {
        return new ParseResult<>(null, new ParseExpection(str, exc, null));
    }

    public static <T> ParseResult<T> error(String str, String str2) {
        return new ParseResult<>(null, new ParseExpection(str, null, str2));
    }

    public static <T> ParseResult<T> error(String str, Exception exc, String str2) {
        return new ParseResult<>(null, new ParseExpection(str, exc, str2));
    }

    public static <T> ParseResult<T> error(ParseExpection parseExpection) {
        return new ParseResult<>(null, parseExpection);
    }

    public T getValue() {
        return this.value;
    }

    public ParseExpection getError() {
        return this.error;
    }

    public boolean isValid() {
        return this.error == null;
    }

    public boolean hasError() {
        return this.error != null;
    }

    public <S> ParseResult<S> onlyError() {
        return new ParseResult<>(null, this.error);
    }

    public <S> ParseResult<S> withDefault(S s) {
        return new ParseResult<>(s, this.error);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ParseResult parseResult = (ParseResult) obj;
        return Objects.equals(this.value, parseResult.value) && Objects.equals(this.error, parseResult.error);
    }

    public int hashCode() {
        return Objects.hash(this.value, this.error);
    }

    public String toString() {
        return "ParseResult{value=" + String.valueOf(this.value) + ", error=" + String.valueOf(this.error);
    }
}
