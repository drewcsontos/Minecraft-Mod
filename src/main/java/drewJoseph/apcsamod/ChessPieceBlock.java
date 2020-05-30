package drewJoseph.apcsamod;

import drewJoseph.apcsamod.chess.Board;
import drewJoseph.apcsamod.chess.ChessPiece;
import drewJoseph.apcsamod.init.ModBlocks;
import drewJoseph.apcsamod.init.ModItems;
import drewJoseph.apcsamod.util.IHasModel;
import drewJoseph.apcsamod.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ChessPieceBlock extends Block implements IHasModel {
	public int row = 0;
	public int col = 0;
	public String type = "";
	Board board;
	ChessBlock chessBlock;

	public ChessPieceBlock(Material material, String blockName) {
		super(material);
		setUnlocalizedName(Reference.MOD_ID + "." + blockName);
		setRegistryName(blockName);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setBlockUnbreakable();
		this.setLightLevel(1f);
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	public ChessPieceBlock(Material material, String blockName, Board board, int row, int col, ChessBlock chessBlock) {
		super(material);
		setUnlocalizedName(Reference.MOD_ID + "." + blockName);
		setRegistryName(blockName);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setBlockUnbreakable();
		this.setLightLevel(1f);
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		this.board = board;
		this.chessBlock = chessBlock;
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		System.out.println(board);
		// board.select(row, col);
		TileEntity tileEntity = worldIn.getTileEntity(pos);
		TileEntityData tileEntityData = (TileEntityData) tileEntity;
		System.out.println(tileEntityData.row + " " + tileEntityData.col);
		if (!worldIn.isRemote)
			board.select(tileEntityData.row, tileEntityData.col);
		chessBlock.update();
		return true;

	}
	
	public IBlockState getChessState() {
		ChessPieceBlock b = null;
		if(board.board[row][col]==null) {
			b = (ChessPieceBlock) (Block.getBlockById(Block.getIdFromBlock(ModBlocks.Blank)));
			return b.getDefaultState(row, col, board, chessBlock, "blank");
		}
		switch (board.board[row][col].getType()) {
		case ChessPiece.PAWN:
			b = (ChessPieceBlock) (Block.getBlockById(Block.getIdFromBlock(ModBlocks.Pawn)));
			break;
		case ChessPiece.KNIGHT:
			b = (ChessPieceBlock) (Block.getBlockById(Block.getIdFromBlock(ModBlocks.Knight)));
			break;
		case ChessPiece.BISHOP:
			b = (ChessPieceBlock) (Block.getBlockById(Block.getIdFromBlock(ModBlocks.Bishop)));
			break;
		case ChessPiece.ROOK:
			b = (ChessPieceBlock) (Block.getBlockById(Block.getIdFromBlock(ModBlocks.Rook)));
			break;
		case ChessPiece.KING:
			b = (ChessPieceBlock) (Block.getBlockById(Block.getIdFromBlock(ModBlocks.King)));
			break;
		case ChessPiece.QUEEN:
			b = (ChessPieceBlock) (Block.getBlockById(Block.getIdFromBlock(ModBlocks.Queen)));
			break;
		}
		return b.getDefaultState(row, col, board, chessBlock, "chesspiece");
	}

	public IBlockState getDefaultState(int row, int col, Board board, ChessBlock block) {
		this.row = row;
		this.col = col;
		this.board = board;
		this.chessBlock = block;
		return this.getChessState();

	}

	public IBlockState getDefaultState(int row, int col, Board board, ChessBlock block, String s) {
		this.row = row;
		this.col = col;
		this.board = board;
		this.chessBlock = block;
		this.type = s;
		return this.getDefaultState();
	}

	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState iBlockState) {
		return false;
	}
	@Override
	public boolean isFullCube(IBlockState iBlockState) {
		return false;
	}
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		if(type.equals("chesspiece"))
			return BlockRenderLayer.SOLID;
		return BlockRenderLayer.CUTOUT_MIPPED;
	}

	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileEntityData();
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		if (type.equals("chesspiece")) {
			return EnumBlockRenderType.MODEL;
		} else {
			return EnumBlockRenderType.INVISIBLE;
		}
	}
	

}