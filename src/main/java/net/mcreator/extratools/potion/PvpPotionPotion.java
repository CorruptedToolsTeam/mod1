
package net.mcreator.extratools.potion;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.potion.Potion;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PvpPotionPotion {
	@ObjectHolder("extra_tools:pvp_potion")
	public static final Potion potionType = null;
	@SubscribeEvent
	public static void registerPotion(RegistryEvent.Register<Potion> event) {
		event.getRegistry().register(new PotionCustom());
	}
	public static class PotionCustom extends Potion {
		public PotionCustom() {
			super(new EffectInstance(Effects.SPEED, 3600, 1, false, true), new EffectInstance(Effects.HASTE, 3600, 1, false, true),
					new EffectInstance(Effects.STRENGTH, 3600, 2, false, true), new EffectInstance(Effects.RESISTANCE, 3600, 1, false, true),
					new EffectInstance(Effects.JUMP_BOOST, 3600, 1, false, true), new EffectInstance(Effects.ABSORPTION, 3600, 4, false, true));
			setRegistryName("pvp_potion");
		}
	}
}
