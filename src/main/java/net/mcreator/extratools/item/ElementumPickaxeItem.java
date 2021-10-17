
package net.mcreator.extratools.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.extratools.itemgroup.ExtraStuffItemGroup;
import net.mcreator.extratools.ExtraToolsModElements;

@ExtraToolsModElements.ModElement.Tag
public class ElementumPickaxeItem extends ExtraToolsModElements.ModElement {
	@ObjectHolder("extra_tools:elementum_pickaxe")
	public static final Item block = null;
	public ElementumPickaxeItem(ExtraToolsModElements instance) {
		super(instance, 42);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 800;
			}

			public float getEfficiency() {
				return 50f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 70;
			}

			public int getEnchantability() {
				return 50;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -3f, new Item.Properties().group(ExtraStuffItemGroup.tab).isImmuneToFire()) {
		}.setRegistryName("elementum_pickaxe"));
	}
}
