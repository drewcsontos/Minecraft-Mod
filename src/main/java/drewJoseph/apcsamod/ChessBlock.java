package drewJoseph.apcsamod;

import drewJoseph.apcsamod.chess.Board;
import drewJoseph.apcsamod.chess.ChessPiece;
import drewJoseph.apcsamod.init.ModBlocks;
import drewJoseph.apcsamod.init.ModItems;
import drewJoseph.apcsamod.util.IHasModel;
import drewJoseph.apcsamod.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ChessBlock extends Block implements IHasModel {
	Board board = new Board();
	World world;
	BlockPos blockPos;
	public ChessBlock(Material material, String blockName) {
		super(material);
		setUnlocalizedName(Reference.MOD_ID + "." + blockName);
		setRegistryName(blockName);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
			ItemStack stack) {

	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		board = new Board();
		world = worldIn;
		blockPos = pos;
		int x = pos.getX() + 1;
		int y = pos.getY();
		int z = pos.getZ() + 1;
		boolean white = false;
		for (int r = 0; r < 8; r++)
			for (int c = 0; c < 8; c++) {
				if (c == 0)
					white = !white;
				if (white)
					worldIn.setBlockState(new BlockPos(x + r, y, z + c), Blocks.QUARTZ_BLOCK.getDefaultState());
				else
					worldIn.setBlockState(new BlockPos(x + r, y, z + c), Blocks.OBSIDIAN.getDefaultState());
				white = !white;
			}
		for (int k = 1; k < 5; k++)
			for (int r = 0; r < 8; r++)
				for (int c = 0; c < 8; c++) {
					worldIn.setBlockToAir(new BlockPos(x + r, y + k, z + c));
				}
		update();
		/*
		 * ChessPieceBlock b = ModBlocks.Pawn; int row = 1; //needs to change (just for
		 * testing) //for(int col=0;col<8;col++) int col = 1; worldIn.setBlockState(new
		 * BlockPos(pos.getX()+1,pos.getY()+1,pos.getZ()+1+row),
		 * b.getDefaultState(this.board,row,col,this));
		 */
		return true;

	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

	public void update() {
		System.out.println(board);
		for (int row = 0; row < 8; row++)
			for (int col = 0; col < 8; col++) {
					//ChessPieceBlock b = new ChessPieceBlock(Material.IRON, "block",this.board,row,col,this);
					world.setBlockState(new BlockPos(blockPos.getX()+1 + col,blockPos.getY()+1,blockPos.getZ()+1+row),new ChessPieceBlock(Material.IRON,"test").getDefaultState(row,col,board,this));
					TileEntity tileentity = world.getTileEntity(new BlockPos(blockPos.getX()+1 + col,blockPos.getY()+1,blockPos.getZ()+1+row));
					if(tileentity instanceof TileEntityData) {
						TileEntityData tileEntityData = (TileEntityData)tileentity;
						tileEntityData.col = col;
						tileEntityData.row = row;
				}
				
			}

	}
}
