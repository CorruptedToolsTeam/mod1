
package net.mcreator.extratools.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Item;

import net.mcreator.extratools.itemgroup.ExtraStuffItemGroup;
import net.mcreator.extratools.ExtraToolsModElements;

@ExtraToolsModElements.ModElement.Tag
public class PressStartItem extends ExtraToolsModElements.ModElement {
	@ObjectHolder("extra_tools:press_start")
	public static final Item block = null;
	public PressStartItem(ExtraToolsModElements instance) {
		super(instance, 28);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, ExtraToolsModElements.sounds.get(new ResourceLocation("extra_tools:press_start")),
					new Item.Properties().group(ExtraStuffItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("press_start");
		}
	}
}
