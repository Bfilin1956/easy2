package mctech.api;

import com.google.common.base.Function;
import java.util.function.BiConsumer;
import mctech.api.buffer.IReadBuffer;
import mctech.api.buffer.IWriteBuffer;
import mctech.config.utils.IEntryDataType;
import mctech.config.utils.ParseResult;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/IConfigSerializer.class */
public interface IConfigSerializer<T> {
    T getExample();

    IEntryDataType.CompoundDataType getFormat();

    ParseResult<Boolean> isValid(T t);

    ParseResult<T> deserialize(String[] strArr);

    String[] serialize(T t);

    T deserialize(IReadBuffer iReadBuffer);

    void serialize(IWriteBuffer iWriteBuffer, T t);

    static <T> IConfigSerializer<T> noSync(IEntryDataType.CompoundDataType compoundDataType, T t, Function<String[], ParseResult<T>> function, Function<T, String[]> function2) {
        return new FunctionWriter(compoundDataType, t, function, function2, null, null, null);
    }

    static <T> IConfigSerializer<T> noSync(IEntryDataType.CompoundDataType compoundDataType, T t, Function<String[], ParseResult<T>> function, Function<T, String[]> function2, Function<T, ParseResult<Boolean>> function3) {
        return new FunctionWriter(compoundDataType, t, function, function2, function3, null, null);
    }

    static <T> IConfigSerializer<T> withSync(IEntryDataType.CompoundDataType compoundDataType, T t, Function<String[], ParseResult<T>> function, Function<T, String[]> function2, Function<IReadBuffer, T> function3, BiConsumer<IWriteBuffer, T> biConsumer) {
        return new FunctionWriter(compoundDataType, t, function, function2, null, function3, biConsumer);
    }

    static <T> IConfigSerializer<T> withSync(IEntryDataType.CompoundDataType compoundDataType, T t, Function<String[], ParseResult<T>> function, Function<T, String[]> function2, Function<T, ParseResult<Boolean>> function3, Function<IReadBuffer, T> function4, BiConsumer<IWriteBuffer, T> biConsumer) {
        return new FunctionWriter(compoundDataType, t, function, function2, function3, function4, biConsumer);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/IConfigSerializer$FunctionWriter.class */
    public static class FunctionWriter<T> implements IConfigSerializer<T> {
        IEntryDataType.CompoundDataType format;
        T example;
        Function<String[], ParseResult<T>> reader;
        Function<T, String[]> writer;
        Function<T, ParseResult<Boolean>> filter;
        Function<IReadBuffer, T> readBuffer;
        BiConsumer<IWriteBuffer, T> writeBuffer;

        public FunctionWriter(IEntryDataType.CompoundDataType compoundDataType, T t, Function<String[], ParseResult<T>> function, Function<T, String[]> function2, Function<T, ParseResult<Boolean>> function3, Function<IReadBuffer, T> function4, BiConsumer<IWriteBuffer, T> biConsumer) {
            this.format = compoundDataType;
            this.example = t;
            this.reader = function;
            this.writer = function2;
            this.filter = function3;
            this.readBuffer = function4;
            this.writeBuffer = biConsumer;
        }

        @Override // mctech.api.IConfigSerializer
        public T getExample() {
            return this.example;
        }

        @Override // mctech.api.IConfigSerializer
        public IEntryDataType.CompoundDataType getFormat() {
            return this.format;
        }

        @Override // mctech.api.IConfigSerializer
        public ParseResult<Boolean> isValid(T t) {
            return this.filter == null ? ParseResult.success(true) : (ParseResult) this.filter.apply(t);
        }

        @Override // mctech.api.IConfigSerializer
        public ParseResult<T> deserialize(String[] strArr) {
            return (ParseResult) this.reader.apply(strArr);
        }

        @Override // mctech.api.IConfigSerializer
        public String[] serialize(T t) {
            return (String[]) this.writer.apply(t);
        }

        @Override // mctech.api.IConfigSerializer
        public T deserialize(IReadBuffer iReadBuffer) {
            if (this.readBuffer == null || this.writeBuffer == null) {
                throw new UnsupportedOperationException("No Read/Write Buffer Provided");
            }
            return (T) this.readBuffer.apply(iReadBuffer);
        }

        @Override // mctech.api.IConfigSerializer
        public void serialize(IWriteBuffer iWriteBuffer, T t) {
            if (this.readBuffer == null || this.writeBuffer == null) {
                throw new UnsupportedOperationException("No Read/Write Buffer Provided");
            }
            this.writeBuffer.accept(iWriteBuffer, t);
        }
    }
}
