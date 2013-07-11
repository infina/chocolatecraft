package com.cbouton.chocolatecraft.fluids;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraftforge.fluids.Fluid;

public class FluidChocolate extends net.minecraftforge.fluids.Fluid{
	public String iconname;
	public Icon flowingicon;
	public Icon stillicon;

	public FluidChocolate(String fluidName) {
		super(fluidName);
		iconname = "chocolatecraft:fluidchocolate";
		
	}

}
