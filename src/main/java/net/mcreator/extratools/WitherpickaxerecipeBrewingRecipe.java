
package net.mcreator.extratools;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;

import net.mcreator.extratools.item.WitherPickaxeItem;
import net.mcreator.extratools.item.DragonPickaxeItem;

@ExtraToolsModElements.ModElement.Tag
public class WitherpickaxerecipeBrewingRecipe extends ExtraToolsModElements.ModElement {
	public WitherpickaxerecipeBrewingRecipe(ExtraToolsModElements instance) {
		super(instance, 38);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(new CustomBrewingRecipe());
	}
	public static class CustomBrewingRecipe implements IBrewingRecipe {
		@Override
		public boolean isInput(ItemStack input) {
			return input.getItem() == DragonPickaxeItem.block;
		}

		@Override
		public boolean isIngredient(ItemStack ingredient) {
			return ingredient.getItem() == Items.NETHER_STAR;
		}

		@Override
		public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
			if (isInput(input) && isIngredient(ingredient)) {
				return new ItemStack(WitherPickaxeItem.block);
			}
			return ItemStack.EMPTY;
		}
	}
}
