package net.mcreator.extratools.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.extratools.potion.MidastoucheffectPotionEffect;
import net.mcreator.extratools.ExtraToolsMod;

import java.util.Map;
import java.util.Collection;

public class MidastouchprocedureProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ExtraToolsMod.LOGGER.warn("Failed to load dependency entity for procedure Midastouchprocedure!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ExtraToolsMod.LOGGER.warn("Failed to load dependency x for procedure Midastouchprocedure!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ExtraToolsMod.LOGGER.warn("Failed to load dependency y for procedure Midastouchprocedure!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ExtraToolsMod.LOGGER.warn("Failed to load dependency z for procedure Midastouchprocedure!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ExtraToolsMod.LOGGER.warn("Failed to load dependency world for procedure Midastouchprocedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == MidastoucheffectPotionEffect.potion)
							return true;
					}
				}
				return false;
			}
		}.check(entity))) {
			{
				BlockPos _bp = new BlockPos((int) x, (int) (y + (-1)), (int) z);
				BlockState _bs = Blocks.GOLD_BLOCK.getDefaultState();
				world.setBlockState(_bp, _bs, 3);
			}
		}
	}
}
