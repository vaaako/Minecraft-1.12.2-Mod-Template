package com.modid.init;

import com.modid.ModName;
import com.modid.init.ItemInit;
import com.modid.items.ItemBase;
import com.modid.items.armor.ArmorBase;

import com.modid.items.tools.ToolSword;
import com.modid.items.tools.ToolAxe;
import com.modid.items.tools.ToolPickaxe;
import com.modid.items.tools.ToolShovel;
import com.modid.items.tools.ToolHoe;
import com.modid.items.tools.ToolItem;

import com.modid.interfaces.IRegisterable;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.inventory.EntityEquipmentSlot;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.init.SoundEvents;
import net.minecraftforge.common.util.EnumHelper;

public class ItemInit {
	// All items
	public static final List<Item> ITEMS = new ArrayList<Item>();

	/**
	 * MATERIAL */
	public static final ToolMaterial TOOL_EXAMPLE = EnumHelper.addToolMaterial("tool_palladium",
		3,        // Harvest Level
		2031,     // Durability
		12.0f,    // Efficiency (not used for swords)
		9.0f - 4, // Damage (It sums base damage (e.g. sword base damage is +4))
		12        // Enchantability
	);

	/**
	 * AMOR */
	public static final ArmorMaterial AMOR_EXAMPLE = EnumHelper.addArmorMaterial("armor_palladium", ModName.MODID + ":palladium",
		400 / 5,                           // Durability (mutiplied by base 5 for some reason)
		new int[]{ 5, 10, 12, 5 },         // Damage Reduction (HEAD, LEG, CHEST, BOOT)
		12,                                // Enchantability
		SoundEvents.ITEM_ARMOR_EQUIP_IRON, // Sound on equip
		2.5f                               // Toughness
	); 



	/**
	 * ITEMS */
	public static final Item AMBER = new ItemBase("amber");


	/**
	 * TOOLS */ 
	// Remember you also need to make a Item json file for these items below

	// PALADDIUM //
	public static final Item EXAMPLE_SWORD = new ToolSword("example_sword", TOOL_EXAMPLE);
	public static final Item EXAMPLE_AXE = new ToolAxe("example_axe", TOOL_EXAMPLE, 12.0f, 1.0f);
	public static final Item EXAMPLE_PICKAXE = new ToolPickaxe("example_pickaxe", TOOL_EXAMPLE);
	public static final Item EXAMPLE_SHOVEL = new ToolShovel("example_shovel", TOOL_EXAMPLE);
	public static final Item EXAMPLE_HOE = new ToolHoe("example_hoe", TOOL_EXAMPLE);

	/**
	 * ARMOR */
	public static final Item EXAMPLE_HELMET = new ArmorBase("example_helmet", AMOR_EXAMPLE, 0, EntityEquipmentSlot.HEAD);
	public static final Item EXAMPLE_CHESTPLATE = new ArmorBase("example_chestplate", AMOR_EXAMPLE, 1, EntityEquipmentSlot.CHEST);
	public static final Item EXAMPLE_LEGGINS = new ArmorBase("example_leggins", AMOR_EXAMPLE, 2, EntityEquipmentSlot.LEGS);
	public static final Item EXAMPLE_BOOTS = new ArmorBase("example_boots", AMOR_EXAMPLE, 3, EntityEquipmentSlot.FEET);



	// If create an item that is not IRegisterable, make a intanceof check before registerItemModel
	public static void registerModels() {
		for(Item item : ItemInit.ITEMS) {
			if(item instanceof IRegisterable) {
				((IRegisterable)item).registerItemModel();
			}
		}
	}
}



/*
- HARVEST LEVEL -
0 = WOOD/GOLD
1 = STONE
2 = IRON
3 = DIAMOND

- DURABILITY -
32    = GOLD
59    = WOOD
131   = STONE
250   = IRON
1561  = DIAMOND
2031  = DIAMOND

- EFFICIENCY -
2  = WOOD
4  = STONE
6  = IRON
8  = DIAMOND
12 = GOLD
*/




/*
- ARMOR STATS MEANING -
DURABILITY     = How many damage can the armor take before break
REDUCTION      = Damage absorved by the armor (e.g. 3 = Damage - 3)
ENCHANTABILITY = How often will receive good enchantment
SOUND          = What sound play on equip
TOUGHNESS      = Resistance for certain types of damage (explosion for example)

- DURABILITY -
LOW    = 1 - 50
MEDIUM = 51 - 100
HIGH   = 101 - 200

- DAMAGE REDUCTION -
LOW    = 1 - 5
MEDIUM = 6 - 10
HIGH   = 11 - 20

- TOUGHNESS -
LOW    = 0.5 - 1.5
MEDIUM = 1.6 - 2.5
HIGH   = 2.6 - 3.0
*/




/*
- ENCHANTABILITY -
LOW    = 1 - 10
MEDIUM = 11 - 20
HIGH   = 21 - 30


- BASE DAMAGE -
SWORD = 4
AXE = 7
PICKAXE = 2
SHOVEl = 2.5
HOE = 1

*/