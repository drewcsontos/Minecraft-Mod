package drewJoseph.apcsamod.init;

import java.util.ArrayList;
import java.util.List;

import drewJoseph.apcsamod.ModAxe;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemAxe;

public class ModItems {
	public static final List<Item> ITEMS = new ArrayList<Item>();
	public static final ItemAxe Mod_Axe = new ModAxe(ToolMaterial.STONE, "ModAxe");	
	
	
}
