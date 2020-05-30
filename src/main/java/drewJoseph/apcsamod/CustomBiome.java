package drewJoseph.apcsamod;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class CustomBiome extends Biome {

	public CustomBiome(BiomeProperties properties) {
		super(properties);
		this.setRegistryName("custom");
		ForgeRegistries.BIOMES.registerAll(this);
		BiomeDictionary.addTypes(this, Type.HILLS);
		BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(this,10));
		BiomeManager.addSpawnBiome(this);
		this.topBlock = Blocks.BEACON.getDefaultState();
	}

}
