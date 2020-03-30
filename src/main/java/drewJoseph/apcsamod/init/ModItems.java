package drewJoseph.apcsamod.init;

import java.util.ArrayList;
import java.util.List;

import drewJoseph.apcsamod.Wand;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSword;

public class ModItems {
	public static final List<Item> ITEMS = new ArrayList<Item>();
	public static final ItemSword Wand = new Wand(ToolMaterial.IRON, "wand");	
	
	
}
