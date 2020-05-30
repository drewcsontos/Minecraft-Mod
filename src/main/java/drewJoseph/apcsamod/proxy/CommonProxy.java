package drewJoseph.apcsamod.proxy;import javax.annotation.Nonnull;

import drewJoseph.apcsamod.CustomBiome;
import drewJoseph.apcsamod.TileEntityData;
import drewJoseph.apcsamod.init.ModBlocks;
import drewJoseph.apcsamod.init.ModItems;
import drewJoseph.apcsamod.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber
public class CommonProxy {
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
        GameRegistry.registerTileEntity(TileEntityData.class, new ResourceLocation("apcsamod:tileEntity"));
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
        
    }
    @SubscribeEvent
    public static void registerBiomes(RegistryEvent.Register<Biome> event) {
    	event.getRegistry().register(new CustomBiome((new Biome.BiomeProperties("Plains")).setBaseHeight(0.125F).setHeightVariation(0.05F).setTemperature(0.8F).setRainfall(0.4F)));
    }
    @SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event)
	{
		for(Item item : ModItems.ITEMS)
		{
			if(item instanceof IHasModel)
			{
				((IHasModel)item).registerModels();
			}
		}
		
		for(Block block : ModBlocks.BLOCKS)
		{
			if(block instanceof IHasModel)
			{
				((IHasModel)block).registerModels();
			}
		}
	}
    public void registerItemRenderer(Item item, int meta, String id) {}
}
