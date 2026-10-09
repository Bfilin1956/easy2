package mctech.api.buffer;

import java.util.UUID;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/buffer/IReadBuffer.class */
public interface IReadBuffer {
    boolean readBoolean();

    byte readByte();

    short readShort();

    int readMedium();

    int readInt();

    int readVarInt();

    float readFloat();

    double readDouble();

    long readLong();

    char readChar();

    <T extends Enum<T>> T readEnum(Class<T> cls);

    byte[] readBytes();

    String readString();

    UUID readUUID();
}
