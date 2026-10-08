package net.mcskill.shop.client.screen.modal.group;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.encoding.Base64;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.json.Json;
import net.mcskill.core.common.json.KsonKt;
import net.mcskill.shop.client.data.SectionDescription;
import net.mcskill.shop.common.response.shop.GroupData;

/* JADX INFO: compiled from: BaseGroupModal.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/modal/group/BaseGroupModal$parseDescriptionFuture$sections$1.class */
@Metadata(mv = {2, 0, 0}, k = 3, xi = 48, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lnet/mcskill/shop/client/data/SectionDescription;", "Lkotlinx/coroutines/CoroutineScope;"})
@DebugMetadata(f = "BaseGroupModal.kt", l = {}, i = {}, s = {}, n = {}, m = "invokeSuspend", c = "net.mcskill.shop.client.screen.modal.group.BaseGroupModal$parseDescriptionFuture$sections$1")
@SourceDebugExtension({"SMAP\nBaseGroupModal.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseGroupModal.kt\nnet/mcskill/shop/client/screen/modal/group/BaseGroupModal$parseDescriptionFuture$sections$1\n+ 2 Json.kt\nkotlinx/serialization/json/Json\n*L\n1#1,151:1\n147#2:152\n*S KotlinDebug\n*F\n+ 1 BaseGroupModal.kt\nnet/mcskill/shop/client/screen/modal/group/BaseGroupModal$parseDescriptionFuture$sections$1\n*L\n100#1:152\n*E\n"})
final class BaseGroupModal$parseDescriptionFuture$sections$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends SectionDescription>>, Object> {
    int label;
    final /* synthetic */ BaseGroupModal this$0;
    final /* synthetic */ GroupData $group;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseGroupModal$parseDescriptionFuture$sections$1(BaseGroupModal $receiver, GroupData $group, Continuation<? super BaseGroupModal$parseDescriptionFuture$sections$1> continuation) {
        super(2, continuation);
        this.this$0 = $receiver;
        this.$group = $group;
    }

    public final Continuation<Unit> create(Object value, Continuation<?> continuation) {
        return new BaseGroupModal$parseDescriptionFuture$sections$1(this.this$0, this.$group, continuation);
    }

    public final Object invoke(CoroutineScope p1, Continuation<? super List<SectionDescription>> continuation) {
        return create(p1, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                Json this_$iv = KsonKt.getKson();
                String string$iv = this.this$0.parsePrefix(new String(Base64.decode$default(Base64.Default, this.$group.getDesc(), 0, 0, 6, (Object) null), Charsets.UTF_8), this.$group);
                this_$iv.getSerializersModule();
                return this_$iv.decodeFromString(new ArrayListSerializer(SectionDescription.INSTANCE.serializer()), string$iv);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
