package com.cbouton.chocolatecraft.fluids;

import com.cbouton.chocolatecraft.lib.FluidStatics;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

public class FluidChocolate extends Fluid{

	public FluidChocolate(String fluidName) {
		super(fluidName);
		setUnlocalizedName(FluidStatics.FLUID_CHOCOLATE_UNLOCALIZED);
		
	}
	
	

	
}