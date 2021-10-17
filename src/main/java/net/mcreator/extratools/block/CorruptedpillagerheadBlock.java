
package net.mcreator.extratools.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.extratools.procedures.CorruptedpillagerbossspawnerProcedure;
import net.mcreator.extratools.itemgroup.ExtraStuffItemGroup;
import net.mcreator.extratools.ExtraToolsModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;

@ExtraToolsModElements.ModElement.Tag
public class CorruptedpillagerheadBlock extends ExtraToolsModElements.ModElement {
	@ObjectHolder("extra_tools:corruptedpillagerhead")
	public static final Block block = null;
	public CorruptedpillagerheadBlock(ExtraToolsModElements instance) {
		super(instance, 56);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(ExtraStuffItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.NETHER_VINE_LOWER_PITCH).hardnessAndResistance(1f, 10f)
					.setLightLevel(s -> 0));
			setRegistryName("corruptedpillagerhead");
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 15;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

		@Override
		public void onBlockPlacedBy(World world, BlockPos pos, BlockState blockstate, LivingEntity entity, ItemStack itemstack) {
			super.onBlockPlacedBy(world, pos, blockstate, entity, itemstack);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				CorruptedpillagerbossspawnerProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
