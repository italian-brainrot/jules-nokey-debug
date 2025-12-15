package com.example.examplemod.mixin;

import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public class PlayerMixin {

    @Inject(method = "tick", at = @At("HEAD"))
    private void onPlayerTick(CallbackInfo ci) {
        // This gets called every tick for every player
        Player player = (Player)(Object)this;
        if (!player.level().isClientSide() && player.tickCount % 100 == 0) {
            System.out.println("Hello from Mixin! Player " + player.getName().getString() + " is alive!");
        }
    }
}