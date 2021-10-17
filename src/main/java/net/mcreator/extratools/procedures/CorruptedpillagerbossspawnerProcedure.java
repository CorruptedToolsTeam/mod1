package net.mcreator.extratools.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.extratools.entity.CorruptedpillagerEntity;
import net.mcreator.extratools.block.CorruptingtableBlock;
import net.mcreator.extratools.ExtraToolsMod;

import java.util.Map;

public class CorruptedpillagerbossspawnerProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ExtraToolsMod.LOGGER.warn("Failed to load dependency x for procedure Corruptedpillagerbossspawner!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ExtraToolsMod.LOGGER.warn("Failed to load dependency y for procedure Corruptedpillagerbossspawner!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ExtraToolsMod.LOGGER.warn("Failed to load dependency z for procedure Corruptedpillagerbossspawner!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ExtraToolsMod.LOGGER.warn("Failed to load dependency world for procedure Corruptedpillagerbossspawner!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == CorruptingtableBlock.block)) {
			if (((world.getBlockState(new BlockPos((int) x, (int) (y - 2), (int) z))).getBlock() == CorruptingtableBlock.block)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) (y - 2), (int) z), Blocks.AIR.getDefaultState(), 3);
				if (world instanceof ServerWorld) {
					Entity entityToSpawn = new CorruptedpillagerEntity.CustomEntity(CorruptedpillagerEntity.entity, (World) world);
					entityToSpawn.setLocationAndAngles(x, y, z, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof MobEntity)
						((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
								SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
					world.addEntity(entityToSpawn);
				}
				if (world instanceof ServerWorld) {
					LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
					_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) z)));
					_ent.setEffectOnly(false);
					((World) world).addEntity(_ent);
				}
			}
		}
	}
}
