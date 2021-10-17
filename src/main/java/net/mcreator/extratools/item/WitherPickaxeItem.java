
package net.mcreator.extratools.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.block.Blocks;

import net.mcreator.extratools.itemgroup.ExtraStuffItemGroup;
import net.mcreator.extratools.ExtraToolsModElements;

@ExtraToolsModElements.ModElement.Tag
public class WitherPickaxeItem extends ExtraToolsModElements.ModElement {
	@ObjectHolder("extra_tools:wither_pickaxe")
	public static final Item block = null;
	public WitherPickaxeItem(ExtraToolsModElements instance) {
		super(instance, 37);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 700;
			}

			public float getEfficiency() {
				return 40f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 50;
			}

			public int getEnchantability() {
				return 40;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Blocks.WITHER_ROSE), new ItemStack(Items.WITHER_SKELETON_SKULL),
						new ItemStack(Items.NETHER_STAR));
			}
		}, 1, -3f, new Item.Properties().group(ExtraStuffItemGroup.tab).isImmuneToFire()) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public boolean hasEffect(ItemStack itemstack) {
				return true;
			}
		}.setRegistryName("wither_pickaxe"));
	}
}
