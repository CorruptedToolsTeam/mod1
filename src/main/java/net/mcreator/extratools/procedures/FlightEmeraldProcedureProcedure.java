package net.mcreator.extratools.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.extratools.potion.FlightpotioneffectPotionEffect;
import net.mcreator.extratools.item.FlightEmeraldItem;
import net.mcreator.extratools.ExtraToolsMod;

import java.util.Map;

public class FlightEmeraldProcedureProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ExtraToolsMod.LOGGER.warn("Failed to load dependency entity for procedure FlightEmeraldProcedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(FlightEmeraldItem.block)) : false)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(FlightpotioneffectPotionEffect.potion, (int) 60, (int) 1));
		}
	}
}
