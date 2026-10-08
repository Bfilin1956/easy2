package net.mcskill.shop.client.screen.modal.cases.impl;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import net.mcskill.shop.common.network.packet.take.CheckCanOpenCasePacket;
import net.mcskill.shop.common.response.shop.CaseData;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.PacketDistributor;

/* JADX INFO: compiled from: PreviewCaseModal.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/modal/cases/impl/PreviewCaseModal$1$1.class */
@Metadata(mv = {2, 0, 0}, k = 3, xi = 48, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"})
@DebugMetadata(f = "PreviewCaseModal.kt", l = {58}, i = {}, s = {}, n = {}, m = "invokeSuspend", c = "net.mcskill.shop.client.screen.modal.cases.impl.PreviewCaseModal$1$1")
final class PreviewCaseModal$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CaseData $case;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PreviewCaseModal$1$1(CaseData $case, Continuation<? super PreviewCaseModal$1$1> continuation) {
        super(2, continuation);
        this.$case = $case;
    }

    public final Continuation<Unit> create(Object value, Continuation<?> continuation) {
        return new PreviewCaseModal$1$1(this.$case, continuation);
    }

    public final Object invoke(CoroutineScope p1, Continuation<? super Unit> continuation) {
        return create(p1, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (DelayKt.delay(250L, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        PacketDistributor.sendToServer(new CheckCanOpenCasePacket(this.$case.getId(), 1), new CustomPacketPayload[0]);
        return Unit.INSTANCE;
    }
}
