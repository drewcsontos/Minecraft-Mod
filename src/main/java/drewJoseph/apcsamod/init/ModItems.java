package drewJoseph.apcsamod.init;

import java.util.ArrayList;
import java.util.List;

import drewJoseph.apcsamod.Wand;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {
	public static final List<Item> ITEMS = new ArrayList<Item>();
	public static final ItemSword Wand = new Wand(ToolMaterial.IRON, "wand");
	public static final CreativeTabs modItems = new CreativeTabs("ModItems") {

		@Override
		public ItemStack getTabIconItem() {
			// TODO Auto-generated method stub
			return Items.BOOK.getDefaultInstance();
		}
		@SideOnly(Side.CLIENT)
		  @Override
		  public void displayAllRelevantItems(NonNullList<ItemStack> itemsToShowOnTab)
		  {
		    for (Item item : Item.REGISTRY) {
		      if (item != null) {
		        if (item.getUnlocalizedName().contains(".apcsamod")) {
		          item.getSubItems(CreativeTabs.SEARCH, itemsToShowOnTab);  // CreativeTabs.SEARCH will find all items even if they belong to another tab
		                                                                    //   except if the item has no tab (item.getCreativeTab() == NULL)
		        }
		      }
		    }
	}
	
};
}
