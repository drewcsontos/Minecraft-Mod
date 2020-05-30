package drewJoseph.apcsamod.init;

import java.util.ArrayList;
import java.util.List;

import drewJoseph.apcsamod.ChessBlock;
import drewJoseph.apcsamod.ChessPieceBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	public static final ChessBlock modBlock = new ChessBlock(Material.IRON,"chessblock");
	public static final ChessPieceBlock Pawn = new ChessPieceBlock(Material.IRON,"pawn");
	public static final ChessPieceBlock Rook= new ChessPieceBlock(Material.IRON,"rook");
	public static final ChessPieceBlock Knight = new ChessPieceBlock(Material.IRON,"knight");
	public static final ChessPieceBlock Bishop = new ChessPieceBlock(Material.IRON,"bishop");
	public static final ChessPieceBlock Queen = new ChessPieceBlock(Material.IRON,"queen");
	public static final ChessPieceBlock King = new ChessPieceBlock(Material.IRON,"king");
	public static final ChessPieceBlock Blank = new ChessPieceBlock(Material.IRON,"blank");
}
