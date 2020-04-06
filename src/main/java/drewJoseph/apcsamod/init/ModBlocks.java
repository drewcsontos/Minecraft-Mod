package drewJoseph.apcsamod.init;

import java.util.ArrayList;
import java.util.List;

import drewJoseph.apcsamod.ChessBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	public static final ChessBlock modBlock = new ChessBlock(Material.IRON,"chessblock");
}
