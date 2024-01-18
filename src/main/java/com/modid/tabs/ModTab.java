package com.modid.tabs;

import com.modid.init.ItemInit;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ModTab extends CreativeTabs {
	public ModTab(String label) {
		super(label);

		// If you want image put on assets/minecraft/textures/gui/container/creative_inventory/
		// this.setBackgroundImageName("tab_wingedhoof.png");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ItemInit.AMBER);
	}
}