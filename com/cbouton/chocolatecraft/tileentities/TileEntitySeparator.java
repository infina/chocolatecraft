package com.cbouton.chocolatecraft.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySeparator extends TileEntity{

	public boolean isActive() {
		return worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
	}
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
	}
}
