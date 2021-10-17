
package net.mcreator.extratools.enchantment;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantment;

import net.mcreator.extratools.ExtraToolsModElements;

@ExtraToolsModElements.ModElement.Tag
public class JumpinessenchantEnchantment extends ExtraToolsModElements.ModElement {
	@ObjectHolder("extra_tools:jumpinessenchant")
	public static final Enchantment enchantment = null;
	public JumpinessenchantEnchantment(ExtraToolsModElements instance) {
		super(instance, 54);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("jumpinessenchant"));
	}
	public static class CustomEnchantment extends Enchantment {
		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.VERY_RARE, EnchantmentType.ARMOR_CHEST, slots);
		}

		@Override
		public int getMinLevel() {
			return 1;
		}

		@Override
		public int getMaxLevel() {
			return 3;
		}

		@Override
		public boolean canApplyAtEnchantingTable(ItemStack stack) {
			if (stack.getItem() == Items.LEATHER_CHESTPLATE)
				return true;
			if (stack.getItem() == Items.CHAINMAIL_CHESTPLATE)
				return true;
			if (stack.getItem() == Items.GOLDEN_CHESTPLATE)
				return true;
			if (stack.getItem() == Items.IRON_CHESTPLATE)
				return true;
			if (stack.getItem() == Items.DIAMOND_CHESTPLATE)
				return true;
			if (stack.getItem() == Items.NETHERITE_CHESTPLATE)
				return true;
			return false;
		}

		@Override
		public boolean isTreasureEnchantment() {
			return true;
		}

		@Override
		public boolean isCurse() {
			return false;
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
