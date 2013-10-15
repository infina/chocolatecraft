package com.cbouton.chocolatecraft.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

public class BlockFluidChocolate extends BlockFluidBase {

	public BlockFluidChocolate(int id, Fluid fluid, Material material) {
		super(id, fluid, material);
		// TODO Auto-generated constructor stub
	}

	@Override
	public FluidStack drain(World world, int x, int y, int z, boolean doDrain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canDrain(World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getQuantaValue(IBlockAccess world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean canCollideCheck(int meta, boolean fullHit) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getMaxRenderHeightMeta() {
		// TODO Auto-generated method stub
		return 0;
	}

}
