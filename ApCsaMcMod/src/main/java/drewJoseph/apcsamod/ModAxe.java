package drewJoseph.apcsamod;

import drewJoseph.apcsamod.init.ModItems;
import drewJoseph.apcsamod.util.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ModAxe extends ItemAxe {

	public ModAxe(ToolMaterial material, String name) {
		super(material);
		setUnlocalizedName(Reference.MOD_ID + "." + name);
		setRegistryName(name);
		this.setCreativeTab(CreativeTabs.TOOLS);
		ModItems.ITEMS.add(this);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) { 
		EntityLargeFireball f = new EntityLargeFireball(worldIn, 0, 0, 0, 0, 0, 0);
		f.setPositionAndRotation(playerIn.posX /*+playerIn.getLookVec().x*/, playerIn.posY /*+ playerIn.getLookVec().y*/, playerIn.posZ /*+ playerIn.getLookVec().z*/, playerIn.cameraYaw, playerIn.cameraPitch);
		f.motionX = playerIn.getLookVec().x;
		f.motionY = playerIn.getLookVec().y;
		f.motionZ = playerIn.getLookVec().z;
		f.accelerationX = f.motionX *.1;
		f.accelerationY = f.motionY *.1;
		f.accelerationZ = f.motionZ *.1;
		worldIn.spawnEntity(f);
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

}