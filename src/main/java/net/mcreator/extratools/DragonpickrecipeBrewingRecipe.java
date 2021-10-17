
package net.mcreator.extratools;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;

import net.mcreator.extratools.item.ObsidianPickaxeItem;
import net.mcreator.extratools.item.DragonPickaxeItem;

@ExtraToolsModElements.ModElement.Tag
public class DragonpickrecipeBrewingRecipe extends ExtraToolsModElements.ModElement {
	public DragonpickrecipeBrewingRecipe(ExtraToolsModElements instance) {
		super(instance, 36);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(new CustomBrewingRecipe());
	}
	public static class CustomBrewingRecipe implements IBrewingRecipe {
		@Override
		public boolean isInput(ItemStack input) {
			return input.getItem() == ObsidianPickaxeItem.block;
		}

		@Override
		public boolean isIngredient(ItemStack ingredient) {
			return ingredient.getItem() == Items.DRAGON_BREATH;
		}

		@Override
		public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
			if (isInput(input) && isIngredient(ingredient)) {
				return new ItemStack(DragonPickaxeItem.block);
			}
			return ItemStack.EMPTY;
		}
	}
}
