package io.github.meatwo310.silents.mixin.minecraft;

import net.minecraft.client.KeyboardHandler;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(KeyboardHandler.class)
public class KeyboardHandlerMixin {
    @Inject(method = "lambda$keyPress$3", at = @At("HEAD"), cancellable = true)
    private void executeInjected(Component p_90917_, CallbackInfo ci) {
        ci.cancel();
    }
}
