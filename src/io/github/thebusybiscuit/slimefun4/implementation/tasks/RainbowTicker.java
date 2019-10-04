package io.github.thebusybiscuit.slimefun4.implementation.tasks;

import org.bukkit.block.Block;
import org.bukkit.block.data.Waterlogged;

import io.github.thebusybiscuit.cscorelib2.materials.MaterialCollections;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockTicker;

public class RainbowTicker extends BlockTicker {
	
	private int meta;
	private int index;
	private int[] queue;

	public RainbowTicker() {
		this(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
	}

	public RainbowTicker(int... data) {
		this.queue = data;
		meta = data[0];
		index = 0;
	}

	@Override
	public void tick(Block b, SlimefunItem item, Config data) {
		if (MaterialCollections.getAllWools().contains(b.getType())) {
			b.setType(MaterialCollections.getAllWools().getAsArray()[meta], false);
		} 
		else if (MaterialCollections.getAllStainedGlassColors().contains(b.getType())) {
			b.setType(MaterialCollections.getAllStainedGlassColors().getAsArray()[meta], false);
		} 
		else if (MaterialCollections.getAllStainedGlassPaneColors().contains(b.getType())){
			boolean waterlogged = ((Waterlogged) b.getBlockData()).isWaterlogged();
			b.setType(MaterialCollections.getAllStainedGlassPaneColors().getAsArray()[meta], true);
			
			if (waterlogged) {
				Waterlogged block = (Waterlogged) b.getBlockData();
				block.setWaterlogged(true);
				b.setBlockData(block);
			}
		} 
		else if (MaterialCollections.getAllTerracottaColors().contains(b.getType())){
			b.setType(MaterialCollections.getAllTerracottaColors().getAsArray()[meta], false);
		}
	}

	@Override
	public void uniqueTick() {
		index = ((index >= queue.length - 1) ? 0: index + 1);
		meta = queue[index];
	}

	@Override
	public boolean isSynchronized() {
		return true;
	}

}
