
package net.mcreator.extratools.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

import net.mcreator.extratools.procedures.CorruptedAppleFoodEatenProcedure;
import net.mcreator.extratools.itemgroup.ExtraStuffItemGroup;
import net.mcreator.extratools.ExtraToolsModElements;

import java.util.Map;
import java.util.HashMap;

@ExtraToolsModElements.ModElement.Tag
public class CorruptedAppleItem extends ExtraToolsModElements.ModElement {
	@ObjectHolder("extra_tools:corrupted_apple")
	public static final Item block = null;
	public CorruptedAppleItem(ExtraToolsModElements instance) {
		super(instance, 76);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ExtraStuffItemGroup.tab).maxStackSize(64).rarity(Rarity.EPIC)
					.food((new Food.Builder()).hunger(20).saturation(0.3f).setAlwaysEdible().build()));
			setRegistryName("corrupted_apple");
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				CorruptedAppleFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
