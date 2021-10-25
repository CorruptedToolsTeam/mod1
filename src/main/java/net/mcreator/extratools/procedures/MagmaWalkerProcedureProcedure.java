package net.mcreator.extratools.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.state.Property;
import net.minecraft.item.ItemStack;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.extratools.enchantment.MagmaWalkerEnchantment;
import net.mcreator.extratools.ExtraToolsMod;

import java.util.Map;

public class MagmaWalkerProcedureProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				ExtraToolsMod.LOGGER.warn("Failed to load dependency itemstack for procedure MagmaWalkerProcedure!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ExtraToolsMod.LOGGER.warn("Failed to load dependency x for procedure MagmaWalkerProcedure!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ExtraToolsMod.LOGGER.warn("Failed to load dependency y for procedure MagmaWalkerProcedure!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ExtraToolsMod.LOGGER.warn("Failed to load dependency z for procedure MagmaWalkerProcedure!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ExtraToolsMod.LOGGER.warn("Failed to load dependency world for procedure MagmaWalkerProcedure!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((EnchantmentHelper.getEnchantmentLevel(MagmaWalkerEnchantment.enchantment, (itemstack)) != 0))) {
			if ((Blocks.LAVA.getDefaultState().getFluidState().isSource())) {
				{
					BlockPos _bp = new BlockPos((int) x, (int) (y + (-1)), (int) z);
					BlockState _bs = Blocks.MAGMA_BLOCK.getDefaultState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
						if (_property != null && _bs.get(_property) != null)
							try {
								_bs = _bs.with(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlockState(_bp, _bs, 3);
				}
			} else if ((Blocks.LAVA.getDefaultState().getFluidState().isSource())) {
				{
					BlockPos _bp = new BlockPos((int) x, (int) (y + (-1)), (int) z);
					BlockState _bs = Blocks.MAGMA_BLOCK.getDefaultState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
						if (_property != null && _bs.get(_property) != null)
							try {
								_bs = _bs.with(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlockState(_bp, _bs, 3);
				}
			}
		}
	}
}
