package mctech.api.buffer;

import java.util.UUID;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/buffer/IWriteBuffer.class */
public interface IWriteBuffer {
    void writeBoolean(boolean z);

    void writeByte(byte b);

    void writeShort(short s);

    void writeMedium(int i);

    void writeInt(int i);

    void writeVarInt(int i);

    void writeFloat(float f);

    void writeDouble(double d);

    void writeLong(long j);

    void writeChar(char c);

    void writeEnum(Enum<?> r1);

    void writeString(String str);

    void writeBytes(byte[] bArr);

    void writeUUID(UUID uuid);
}
