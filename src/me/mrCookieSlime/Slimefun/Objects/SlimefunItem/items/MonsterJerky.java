package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.items;

import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.SlimefunPlugin;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SimpleSlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.handlers.ItemConsumptionHandler;
import me.mrCookieSlime.Slimefun.Setup.SlimefunManager;

public class MonsterJerky extends SimpleSlimefunItem<ItemConsumptionHandler> {

	public MonsterJerky(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
		super(category, item, recipeType, recipe);
	}
	
	@Override
	public ItemConsumptionHandler getItemHandler() {
		return (e, p, item) -> {
			if (SlimefunManager.isItemSimiliar(item, getItem(), true)) {
				SlimefunPlugin.instance.getServer().getScheduler().runTaskLater(SlimefunPlugin.instance, () -> {
					if (p.hasPotionEffect(PotionEffectType.HUNGER)) {
						p.removePotionEffect(PotionEffectType.HUNGER);
					}
					
					p.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 5, 0));
				}, 1L);
				return true;
			}
			else {
				return false;
			}
		};
	}

}
