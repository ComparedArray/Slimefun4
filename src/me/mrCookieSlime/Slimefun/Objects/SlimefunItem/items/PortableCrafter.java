package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.items;

import org.bukkit.Sound;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Lists.SlimefunItems;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SimpleSlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.handlers.ItemInteractionHandler;
import me.mrCookieSlime.Slimefun.Setup.SlimefunManager;

public class PortableCrafter extends SimpleSlimefunItem<ItemInteractionHandler> {

	public PortableCrafter(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
		super(category, item, recipeType, recipe);
	}
	
	@Override
	public ItemInteractionHandler getItemHandler() {
		return (e, p, item) -> {
			if (SlimefunManager.isItemSimiliar(item, SlimefunItems.PORTABLE_CRAFTER, true)) {
				p.openWorkbench(p.getLocation(), true);
				p.getWorld().playSound(p.getLocation(), Sound.BLOCK_WOODEN_BUTTON_CLICK_ON, 1, 1);
				return true;
			}
			else return false;
		};
	}
}
