package drewJoseph.apcsamod;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class TileEntityData extends TileEntity implements ITickable{
	public int row = 0;
	public int col = 0;
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	@Override
	  public NBTTagCompound getUpdateTag()
	  {
	    NBTTagCompound nbtTagCompound = new NBTTagCompound();
	    writeToNBT(nbtTagCompound);
	    return nbtTagCompound;
	  }
	  @Override
	  public void handleUpdateTag(NBTTagCompound tag)
	  {
	    this.readFromNBT(tag);
	  }
	  @Override
		public NBTTagCompound writeToNBT(NBTTagCompound parentNBTTagCompound)
		{
			super.writeToNBT(parentNBTTagCompound);
			parentNBTTagCompound.setInteger("row", row);
			parentNBTTagCompound.setInteger("col", col);
			return parentNBTTagCompound;
		}
	  public void readFromNBT(NBTTagCompound parentNBTTagCompound)
		{
			super.readFromNBT(parentNBTTagCompound);
			row = parentNBTTagCompound.getInteger("row");
			col = parentNBTTagCompound.getInteger("ticksLeft");
		}
}
