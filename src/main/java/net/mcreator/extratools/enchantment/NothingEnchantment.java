
package net.mcreator.extratools.enchantment;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantment;

import net.mcreator.extratools.ExtraToolsModElements;

@ExtraToolsModElements.ModElement.Tag
public class NothingEnchantment extends ExtraToolsModElements.ModElement {
	@ObjectHolder("extra_tools:nothing")
	public static final Enchantment enchantment = null;
	public NothingEnchantment(ExtraToolsModElements instance) {
		super(instance, 7);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("nothing"));
	}
	public static class CustomEnchantment extends Enchantment {
		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.COMMON, EnchantmentType.WEAPON, slots);
		}

		@Override
		public int getMinLevel() {
			return 1;
		}

		@Override
		public int getMaxLevel() {
			return 1;
		}

		@Override
		protected boolean canApplyTogether(Enchantment ench) {
			if (ench == Enchantments.VANISHING_CURSE)
				return true;
			return false;
		}

		@Override
		public boolean canApplyAtEnchantingTable(ItemStack stack) {
			if (stack.getItem() == Items.WOODEN_SWORD)
				return true;
			if (stack.getItem() == Items.STONE_SWORD)
				return true;
			if (stack.getItem() == Items.IRON_SWORD)
				return true;
			if (stack.getItem() == Items.GOLDEN_SWORD)
				return true;
			if (stack.getItem() == Items.DIAMOND_SWORD)
				return true;
			if (stack.getItem() == Items.DIAMOND_SWORD)
				return true;
			if (stack.getItem() == Items.NETHERITE_SWORD)
				return true;
			return false;
		}

		@Override
		public boolean isTreasureEnchantment() {
			return true;
		}

		@Override
		public boolean isCurse() {
			return true;
		}

		@Override
		public boolean isAllowedOnBooks() {
			return true;
		}

		@Override
		public boolean canGenerateInLoot() {
			return true;
		}

		@Override
		public boolean canVillagerTrade() {
			return true;
		}
	}
}
