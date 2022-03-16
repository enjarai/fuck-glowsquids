package nl.enjarai.fuck_glowsquids.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.GlowSquidEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(GlowSquidEntity.class)
public class GlowSquidEntityMixin {
    @Inject(method = "canSpawn", at = @At(value = "HEAD"), cancellable = true)
    private static void modCanSpawn(EntityType<? extends LivingEntity> type, ServerWorldAccess world, SpawnReason reason, BlockPos pos, Random random, CallbackInfoReturnable<Boolean> cir) {
        if (world.getBaseLightLevel(pos, 0) != 0)
            cir.setReturnValue(false);
    }
}
