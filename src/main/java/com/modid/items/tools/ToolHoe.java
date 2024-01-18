package com.modid.items.tools;

import com.modid.ModName;
import com.modid.init.ItemInit;
import com.modid.interfaces.IRegisterable;

import net.minecraft.item.ItemHoe;


public class ToolHoe extends ItemHoe implements IRegisterable {
	public ToolHoe(String name, ToolMaterial material) {
		super(material);

		updateRegistryAndLocalizedName(name);
		setCreativeTab(ModName.CREATIVE_TAB);

		ItemInit.ITEMS.add(this);
	}


	@Override
	public void registerItemModel() {
		ModName.proxy.registerItemRenderer(this, 0);
	}
	
	@Override
	public void updateRegistryAndLocalizedName(String name) {
		setUnlocalizedName(name); // Used for language files
		setRegistryName(name); // USed for registering the item and it's models
	}
}