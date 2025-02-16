package com.khan.instaspawn;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.class_124;
import net.minecraft.class_2168;
import net.minecraft.class_2170;
import net.minecraft.class_2561;
import net.minecraft.class_2583;
import net.minecraft.class_3218;
import net.minecraft.class_2338.class_2339;

public class Instaspawn implements ModInitializer {
   public void onInitialize() {
      this.registerSpawnCommand();
   }

   private void registerSpawnCommand() {
      CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
         dispatcher.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)class_2170.method_9247("spawn").requires((source) -> {
            return source.method_9259(0);
         })).executes((context) -> {
            class_2168 source = (class_2168)context.getSource();
            if (source.method_44023() != null) {
               class_3218 world = source.method_9225();
               int highestY = world.method_31600();
               class_2339 pos = new class_2339(0, highestY, 0);

               while(pos.method_10264() > world.method_31607() && world.method_8320(pos).method_26215() && world.method_8316(pos).method_15769()) {
                  pos.method_10100(0, -1, 0);
               }

               source.method_44023().method_14251(world, 0.0D, (double)pos.method_10264() + 1.0D, 0.0D, source.method_44023().method_36454(), source.method_44023().method_36455());
               class_2561 coloredText = class_2561.method_43470("Teleported to spawn!").method_10862(class_2583.field_24360.method_10977(class_124.field_1060));
               source.method_9226(() -> {
                  return coloredText;
               }, false);
            }

            return 1;
         }));
      });
   }
}
