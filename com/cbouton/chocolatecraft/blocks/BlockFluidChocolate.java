package com.cbouton.chocolatecraft.blocks;

import com.cbouton.chocolatecraft.lib.BlockStatics;
import com.cbouton.chocolatecraft.lib.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockFluidChocolate extends BlockFluidClassic {

	private Icon theIcon;

	public BlockFluidChocolate(int id, Fluid fluid, Material material) {
		super(id, fluid, material);
		setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		this.theIcon = (Icon)iconRegister.registerIcon(Reference.MOD_NAME + ":" + BlockStatics.BLOCK_LIQUID_CHOCOLATE);
	}


}
