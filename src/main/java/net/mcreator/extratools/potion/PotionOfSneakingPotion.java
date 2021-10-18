
package net.mcreator.extratools.potion;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.potion.Potion;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PotionOfSneakingPotion {
	@ObjectHolder("extra_tools:potion_of_sneaking")
	public static final Potion potionType = null;
	@SubscribeEvent
	public static void registerPotion(RegistryEvent.Register<Potion> event) {
		event.getRegistry().register(new PotionCustom());
	}
	public static class PotionCustom extends Potion {
		public PotionCustom() {
			super(new EffectInstance(Effects.INVISIBILITY, 3600, 3, false, false), new EffectInstance(Effects.WEAKNESS, 3600, 1, false, false),
					new EffectInstance(Effects.SPEED, 3600, 2, false, false), new EffectInstance(Effects.NIGHT_VISION, 3600, 100, false, false),
					new EffectInstance(Effects.JUMP_BOOST, 3600, 2, false, false));
			setRegistryName("potion_of_sneaking");
		}
	}
}
