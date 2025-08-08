package io.github.meatwo310.silents.mixin.minecraft;

import net.minecraft.client.KeyboardHandler;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.function.Consumer;

@Mixin(value = KeyboardHandler.class)
public class KeyboardHandlerMixin {
    @ModifyArg(
            method = "keyPress",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/Screenshot;grab(" +
                            "Ljava/io/File;" +
                            "Lcom/mojang/blaze3d/pipeline/RenderTarget;" +
                            "Ljava/util/function/Consumer;" +
                            ")V"
            ),
            index = 2
    )
    private Consumer<Component> injected(Consumer<Component> consumer) {
        return component -> {};
    }
}
