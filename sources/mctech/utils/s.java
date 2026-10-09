package mctech.utils;

import it.unimi.dsi.fastutil.ints.IntList;
import it.unimi.dsi.fastutil.ints.IntListIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import mctech.api.network.buffer.INetworkDataBuffer;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/s.class */
public class s implements INetworkDataBuffer {
    public mctech.m.e.i a;
    protected boolean b;
    private int c = new Random().nextInt(20);

    public s(mctech.m.e.i iVar) {
        this.a = iVar;
    }

    public boolean a() {
        return this.b;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public void b() {
        this.b = !this.b;
    }

    public void c() {
        if (this.b) {
            int i = this.c;
            this.c = i + 1;
            if (i % 10 != 0) {
                return;
            }
            IntList intListA = this.a.a(mctech.m.e.k.g);
            if (intListA.size() > 1) {
                HashMap map = new HashMap();
                ArrayList arrayList = new ArrayList();
                IntListIterator it = intListA.iterator();
                while (it.hasNext()) {
                    int iIntValue = ((Integer) it.next()).intValue();
                    ItemStack stackInSlot = this.a.a().getStackInSlot(iIntValue);
                    if (stackInSlot.isEmpty()) {
                        arrayList.add(Integer.valueOf(iIntValue));
                    } else if (stackInSlot.getMaxStackSize() != 1) {
                        boolean z = false;
                        for (Map.Entry entry : map.entrySet()) {
                            if (ItemStack.isSameItemSameComponents(stackInSlot, (ItemStack) entry.getKey())) {
                                a aVar = (a) entry.getValue();
                                aVar.b(iIntValue);
                                aVar.a(stackInSlot.getCount());
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            map.put(stackInSlot.copy(), new a().a(stackInSlot.getCount()).b(iIntValue));
                        }
                    }
                }
                for (Map.Entry entry2 : map.entrySet()) {
                    a aVar2 = (a) entry2.getValue();
                    if (aVar2.a > 1 && (aVar2.b.size() != 1 || !arrayList.isEmpty())) {
                        int i2 = 0;
                        Iterator<Integer> it2 = aVar2.b.iterator();
                        while (it2.hasNext()) {
                            int iIntValue2 = it2.next().intValue();
                            int i3 = i2;
                            i2++;
                            int iCeil = (int) Math.ceil(aVar2.a / ((aVar2.b.size() + arrayList.size()) - i3));
                            ItemStack itemStackCopy = ((ItemStack) entry2.getKey()).copy();
                            itemStackCopy.setCount(iCeil);
                            aVar2.a -= iCeil;
                            this.a.a().setStackInSlot(iIntValue2, itemStackCopy);
                        }
                        ArrayList arrayList2 = new ArrayList();
                        Iterator it3 = arrayList.iterator();
                        while (it3.hasNext()) {
                            int iIntValue3 = ((Integer) it3.next()).intValue();
                            int i4 = i2;
                            i2++;
                            int iCeil2 = (int) Math.ceil(aVar2.a / ((aVar2.b.size() + arrayList.size()) - i4));
                            if (iCeil2 == 0) {
                                break;
                            }
                            arrayList2.add(Integer.valueOf(iIntValue3));
                            ItemStack itemStackCopy2 = ((ItemStack) entry2.getKey()).copy();
                            itemStackCopy2.setCount(iCeil2);
                            aVar2.a -= iCeil2;
                            this.a.a().setStackInSlot(iIntValue3, itemStackCopy2);
                        }
                        arrayList.removeAll(arrayList2);
                    }
                }
            }
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/s$a.class */
    public static class a {
        public int a = 0;
        public List<Integer> b = new ArrayList();

        public a a(int i) {
            this.a += i;
            return this;
        }

        public a b(int i) {
            if (!this.b.contains(Integer.valueOf(i))) {
                this.b.add(Integer.valueOf(i));
            }
            return this;
        }
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void write(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeBoolean(this.b);
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void read(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this.b = registryFriendlyByteBuf.readBoolean();
    }
}
