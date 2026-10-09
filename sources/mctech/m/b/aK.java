package mctech.m.b;

import java.text.DecimalFormat;
import java.util.function.Consumer;
import java.util.function.Supplier;
import mctech.MCTech;
import mctech.components.ContainerComponent;
import mctech.components.a.C0101n;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.network.PacketDistributor;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/aK.class */
public class aK extends ContainerComponent<mctech.blockentities.c.ag> {
    public static final ResourceLocation a = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/gui/container/vending_machine/gui_vending_machine_owner.png");
    public static final ResourceLocation[] b = {ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/gui/container/vending_machine/gui_vending_machine_player_sale.png"), ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/gui/container/vending_machine/gui_vending_machine_player_trade.png"), ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/gui/container/vending_machine/gui_vending_machine_player_buy.png")};
    public static final ResourceLocation[] c = {ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/gui/container/vending_machine/gui_vending_machine_notification1.png"), ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/gui/container/vending_machine/gui_vending_machine_notification2.png"), null, ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/gui/container/vending_machine/gui_vending_machine_notification3.png"), ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/gui/container/vending_machine/gui_vending_machine_notification4.png"), ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/gui/container/vending_machine/gui_vending_machine_notification5.png"), ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/gui/container/vending_machine/gui_vending_machine_notification6.png")};
    public static final int d = 0;
    public static final int e = 1;
    public static final int f = 2;
    public static final int g = 0;
    public static final int h = 1;
    public static final int i = 2;
    public static final int j = 3;
    public static final int k = 4;
    public static final int l = 5;
    private static final int o = 0;
    private static final int p = 1;
    private static final int q = 2;
    private static final int r = 3;
    private static final int s = 6;
    private static final int t = 7;
    private final boolean u;
    public int m;
    public long n;
    private mctech.components.b.f<? extends Number> v;
    private mctech.components.b.f<? extends Number> w;
    private mctech.components.b.f<Integer> x;

    public aK(mctech.blockentities.c.ag agVar, Player player, int i2) {
        super(agVar, player, i2);
        this.m = -1;
        this.n = 0L;
        this.addedPreviewer = true;
        this.u = agVar.b(player);
        if (this.u && !agVar.e) {
            addSlot(new mctech.m.g.f(agVar.l, 0, 95, 55));
            addSlot(new mctech.m.g.f(agVar.l, 1, 136, 55));
            for (int i3 = 0; i3 < 40; i3++) {
                addSlot(new mctech.m.g.l(agVar, i3, 34 + (18 * (i3 % 10)), 5 + (18 * (i3 / 10))).a(!agVar.d));
            }
            addPlayerInventoryAt(player.getInventory(), 43, 108);
            addComponent(new mctech.components.a.w(new mctech.utils.math.geometry.b(123, 91, 0, 0), 0.85f, () -> {
                return "Сделок: " + agVar.j;
            }));
            addComponent(new mctech.components.a.R(C0101n.e, 43, 38, 51, 9, C0101n.b.w, C0101n.b.b, C0101n.b.a).c(false).a(r2 -> {
                agVar.sendToServer(0, 0);
            }).a(r3 -> {
                return agVar.c == 0;
            }));
            addComponent(new mctech.components.a.R(C0101n.e, 97, 38, 51, 9, C0101n.b.w, C0101n.b.d, C0101n.b.c).c(false).a(r4 -> {
                agVar.sendToServer(0, 1);
            }).a(r5 -> {
                return agVar.c == 1;
            }));
            addComponent(new mctech.components.a.R(C0101n.e, 151, 38, 51, 9, C0101n.b.w, C0101n.b.f, C0101n.b.e).c(false).a(r6 -> {
                agVar.sendToServer(0, 2);
            }).a(r7 -> {
                return agVar.c == 2;
            }));
            addComponent(new mctech.components.a.R(C0101n.e, 23, 80, 53, 13, C0101n.b.w, C0101n.b.n, C0101n.b.m).c(false).a(r8 -> {
                agVar.sendToServer(1, r8.p() ? 0 : 1);
            }).a(r9 -> {
                for (Slot slot : this.slots) {
                    if (slot instanceof mctech.m.g.f) {
                        ((mctech.m.g.f) slot).b(agVar.d);
                    }
                    if (slot instanceof mctech.m.g.l) {
                        ((mctech.m.g.l) slot).a(!agVar.d);
                    }
                }
                return agVar.d;
            }));
            addComponent(new mctech.components.a.R(C0101n.e, 196, 80, 13, 13, C0101n.b.w, C0101n.b.w, C0101n.b.o).c(false).a(r10 -> {
                if (!agVar.a()) {
                    return;
                }
                agVar.e = true;
                a();
                agVar.sendToServer(2, 1);
            }));
            addComponent(new mctech.components.a.R(C0101n.e, 210, 80, 13, 13, C0101n.b.w, C0101n.b.q, C0101n.b.w).c(false).a(r11 -> {
                agVar.sendToServer(7, agVar.g ? 0 : 1);
                agVar.g = !agVar.g;
            }).a(r12 -> {
                return !agVar.g;
            }));
            this.v = mctech.components.b.f.c(new mctech.utils.math.geometry.b(85, 82, 36, 7), (Supplier<Float>) () -> {
                return Float.valueOf(agVar.i[0]);
            }, (Consumer<Float>) f2 -> {
                agVar.sendToServer("price", new mctech.blockentities.c.ag.a(((mctech.blockentities.c.ag) this.gui).c == 0 ? f2.floatValue() : Math.max(1, f2.intValue()), ((mctech.blockentities.c.ag) this.gui).c == 2 ? this.w.a().floatValue() : Math.max(1, this.w.a().intValue())));
            });
            this.w = mctech.components.b.f.c(new mctech.utils.math.geometry.b(128, 82, 36, 7), (Supplier<Float>) () -> {
                return Float.valueOf(agVar.i[1]);
            }, (Consumer<Float>) f3 -> {
                agVar.sendToServer("price", new mctech.blockentities.c.ag.a(((mctech.blockentities.c.ag) this.gui).c == 0 ? this.v.a().floatValue() : Math.max(1, this.v.a().intValue()), ((mctech.blockentities.c.ag) this.gui).c == 2 ? f3.floatValue() : Math.max(1, f3.intValue())));
            });
            addComponent(this.v);
            addComponent(this.w);
            if (player.isCreative()) {
                addComponent(new mctech.components.a.R(C0101n.e, 196, 72, 26, 7, C0101n.b.t, C0101n.b.s, C0101n.b.w).c(false).a(r13 -> {
                    agVar.sendToServer(6, agVar.f ? 0 : 1);
                }).a(r14 -> {
                    return agVar.f;
                }));
            }
            addComponent(new mctech.m.d.a.d(() -> {
                return agVar.d;
            }, () -> {
                agVar.d = !agVar.d;
            }));
            return;
        }
        addSlot(new mctech.m.g.f(agVar.l, 0, 90, 54));
        addSlot(new mctech.m.g.f(agVar.l, 1, 140, 54));
        if (this.u) {
            for (int i4 = 0; i4 < 40; i4++) {
                addSlot(new mctech.m.g.l(agVar, i4, 34 + (18 * (i4 % 10)), 5 + (18 * (i4 / 10))).a(true));
            }
        }
        addPlayerInventoryAt(player.getInventory(), 43, 127);
        addComponent(new mctech.components.a.w(new mctech.utils.math.geometry.b(123, 35, 0, 0), 1.0f, () -> {
            return agVar.f ? "Админшоп" : agVar.b;
        }));
        addComponent(new mctech.components.a.T(this, new mctech.utils.math.geometry.b(35, -50, 0, 0)));
        switch (agVar.c) {
            case 0:
                addComponent(new mctech.components.a.R(C0101n.e, 125, 94, 51, 9, C0101n.b.w, C0101n.b.j, C0101n.b.i).c(false).a(r15 -> {
                    if (!getSlot(1).getItem().isEmpty()) {
                        agVar.sendToServer(3, b());
                    }
                }));
                addComponent(new mctech.components.a.R(C0101n.e, 72, 95, 7, 7, C0101n.b.w, C0101n.b.w, C0101n.b.v).c(false).a(r16 -> {
                    b(Math.max(1, b() - 1));
                }));
                addComponent(new mctech.components.a.R(C0101n.e, 114, 95, 7, 7, C0101n.b.w, C0101n.b.w, C0101n.b.u).c(false).a(r17 -> {
                    b(b() + 1);
                }));
                addComponent(new mctech.components.a.w(new mctech.utils.math.geometry.b(98, 81, 0, 0), 0.5f, () -> {
                    return a(b());
                }));
                addComponent(new mctech.components.a.w(new mctech.utils.math.geometry.b(148, 81, 0, 0), 0.5f, () -> {
                    return b(b());
                }));
                this.x = mctech.components.b.f.a(new mctech.utils.math.geometry.b(81, 97, 35, 7), (Supplier<Integer>) () -> {
                    return 1;
                }, (Consumer<Integer>) num -> {
                }).a("[0-9]{1,}");
                addComponent(this.x);
                break;
            case 1:
                addComponent(new mctech.components.a.R(C0101n.e, 122, 94, 56, 9, C0101n.b.w, C0101n.b.l, C0101n.b.k).c(false).a(r18 -> {
                    if (!agVar.g && !agVar.g && !getSlot(0).getItem().isEmpty() && !getSlot(1).getItem().isEmpty()) {
                        agVar.sendToServer(3, b());
                    }
                }));
                addComponent(new mctech.components.a.R(C0101n.e, 69, 95, 7, 7, C0101n.b.w, C0101n.b.w, C0101n.b.v).c(false).a(r19 -> {
                    b(Math.max(1, b() - 1));
                }));
                addComponent(new mctech.components.a.R(C0101n.e, 111, 95, 7, 7, C0101n.b.w, C0101n.b.w, C0101n.b.u).c(false).a(r20 -> {
                    b(b() + 1);
                }));
                addComponent(new mctech.components.a.w(new mctech.utils.math.geometry.b(98, 81, 0, 0), 0.5f, () -> {
                    return a(b());
                }));
                addComponent(new mctech.components.a.w(new mctech.utils.math.geometry.b(148, 81, 0, 0), 0.5f, () -> {
                    return b(b());
                }));
                this.x = mctech.components.b.f.a(new mctech.utils.math.geometry.b(81, 97, 35, 7), (Supplier<Integer>) () -> {
                    return 1;
                }, (Consumer<Integer>) num2 -> {
                }).a("[0-9]{1,}");
                addComponent(this.x);
                break;
            case 2:
                addComponent(new mctech.components.a.R(C0101n.e, 125, 94, 51, 9, C0101n.b.w, C0101n.b.h, C0101n.b.g).c(false).a(r21 -> {
                    if (!agVar.g && !getSlot(0).getItem().isEmpty()) {
                        agVar.sendToServer(3, b());
                    }
                }));
                addComponent(new mctech.components.a.R(C0101n.e, 72, 95, 7, 7, C0101n.b.w, C0101n.b.w, C0101n.b.v).c(false).a(r22 -> {
                    b(Math.max(1, b() - 1));
                }));
                addComponent(new mctech.components.a.R(C0101n.e, 114, 95, 7, 7, C0101n.b.w, C0101n.b.w, C0101n.b.u).c(false).a(r23 -> {
                    b(b() + 1);
                }));
                addComponent(new mctech.components.a.w(new mctech.utils.math.geometry.b(98, 81, 0, 0), 0.5f, () -> {
                    return a(b());
                }));
                addComponent(new mctech.components.a.w(new mctech.utils.math.geometry.b(148, 81, 0, 0), 0.5f, () -> {
                    return b(b());
                }));
                this.x = mctech.components.b.f.a(new mctech.utils.math.geometry.b(81, 97, 35, 7), (Supplier<Integer>) () -> {
                    return 1;
                }, (Consumer<Integer>) num3 -> {
                }).a("[0-9]{1,}");
                addComponent(this.x);
                break;
        }
        if (this.u && agVar.e) {
            addComponent(new mctech.components.a.R(C0101n.e, 196, 80, 13, 13, C0101n.b.o, C0101n.b.w, C0101n.b.p).c(false).a(r24 -> {
                if (!agVar.a()) {
                    return;
                }
                agVar.e = false;
                agVar.sendToServer(2, 0);
            }));
            addComponent(new mctech.components.a.R(C0101n.e, 210, 80, 13, 13, C0101n.b.q, C0101n.b.r, C0101n.b.w).c(false).a(r25 -> {
                agVar.sendToServer(7, agVar.g ? 0 : 1);
                agVar.g = !agVar.g;
            }).a(r26 -> {
                return agVar.g;
            }));
        }
    }

    private String a(double d2) {
        return new DecimalFormat("#.###").format(((double) ((mctech.blockentities.c.ag) this.gui).i[0]) * d2);
    }

    private String b(double d2) {
        return new DecimalFormat("#.###").format(((double) ((mctech.blockentities.c.ag) this.gui).i[1]) * d2);
    }

    @Override // mctech.m.b.S
    public void clicked(int i2, int i3, ClickType clickType, Player player) {
        if (this.u && !((mctech.blockentities.c.ag) this.gui).e && (i2 == 0 || i2 == 1)) {
            PacketDistributor.sendToServer(new mctech.q.d.c(i2, getCarried()), new CustomPacketPayload[0]);
        } else {
            super.clicked(i2, i3, clickType, player);
        }
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(246);
        bVar.f(mctech.g.c.a.d.e);
    }

    @Override // mctech.components.ContainerComponent, mctech.m.b.AbstractC0160t
    public void removed(Player player) {
        super.removed(player);
        ((mctech.blockentities.c.ag) this.gui).sendToServer(1, 0);
        a();
    }

    private void a() {
        float fMax;
        float fMax2;
        if (this.v == null || this.w == null) {
            return;
        }
        if (((mctech.blockentities.c.ag) this.gui).c == 0) {
            fMax = this.v.a().floatValue();
        } else {
            fMax = Math.max(1, this.v.a().intValue());
        }
        if (((mctech.blockentities.c.ag) this.gui).c == 2) {
            fMax2 = this.w.a().floatValue();
        } else {
            fMax2 = Math.max(1, this.w.a().intValue());
        }
        ((mctech.blockentities.c.ag) this.gui).sendToServer("price", new mctech.blockentities.c.ag.a(fMax, fMax2));
    }

    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return (!this.u || ((mctech.blockentities.c.ag) this.gui).e) ? b[((mctech.blockentities.c.ag) this.gui).c] : a;
    }

    public void a(int i2) {
        this.m = i2;
        this.n = System.currentTimeMillis() + 5000;
    }

    private int b() {
        try {
            return ((Integer) this.x.a()).intValue();
        } catch (Exception e2) {
            return 1;
        }
    }

    private void b(int i2) {
        this.x.a(Integer.valueOf(i2));
    }
}
