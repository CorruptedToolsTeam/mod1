
package net.mcreator.extratools.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

import net.mcreator.extratools.itemgroup.ExtraStuffItemGroup;
import net.mcreator.extratools.ExtraToolsModElements;

@ExtraToolsModElements.ModElement.Tag
public class CheesefoodItem extends ExtraToolsModElements.ModElement {
	@ObjectHolder("extra_tools:cheesefood")
	public static final Item block = null;
	public CheesefoodItem(ExtraToolsModElements instance) {
		super(instance, 13);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ExtraStuffItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(4).saturation(0.3f).setAlwaysEdible().build()));
			setRegistryName("cheesefood");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}
	}
}
