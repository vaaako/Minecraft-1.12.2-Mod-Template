package com.modid.items.armor;

import com.modid.ModName;
import com.modid.init.ItemInit;
import com.modid.interfaces.IRegisterable;

import net.minecraft.item.ItemArmor;
import net.minecraft.inventory.EntityEquipmentSlot;

public class ArmorBase extends ItemArmor implements IRegisterable {
	public ArmorBase(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);

		updateRegistryAndLocalizedName(name);
		setCreativeTab(ModName.CREATIVE_TAB);

		// Add this item to mod items
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
