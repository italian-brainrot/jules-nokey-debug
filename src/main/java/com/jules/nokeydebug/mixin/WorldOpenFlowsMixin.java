package com.jules.nokeydebug.mixin;

import com.jules.nokeydebug.JulesNoKeyDebug;
import net.minecraft.client.gui.screens.worldselection.WorldOpenFlows;
import net.minecraft.world.level.storage.LevelStorageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WorldOpenFlows.class)
public class WorldOpenFlowsMixin {
    @Inject(method = "loadLevelData", at = @At("HEAD"))
    private static void beforeLoadLevelData(LevelStorageSource.LevelStorageAccess pLevelStorage, CallbackInfoReturnable<?> cir) {
        JulesNoKeyDebug.LOGGER.info("Attempting to load world data from folder: " + pLevelStorage.getLevelId());
    }
}
