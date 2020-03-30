package drewJoseph.apcsamod;

import drewJoseph.apcsamod.init.ModItems;
import drewJoseph.apcsamod.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;

public class ModBlock extends Block{

	public ModBlock(Material material, String blockName) {
		super(material);
		setUnlocalizedName(Reference.MOD_ID + "." + blockName);
		setRegistryName(blockName);	
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
}
