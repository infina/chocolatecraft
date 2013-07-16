/*Copyright 2012, infina (C. Bouton)
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:
* Redistributions of source code must retain the above copyright
  notice, this list of conditions and the following disclaimer.
* Redistributions in binary form must reproduce the above copyright
  notice, this list of conditions and the following disclaimer in the
  documentation and/or other materials provided with the distribution.
* Neither the name of the creator nor the
  names of its contributors may be used to endorse or promote products
  derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL infina BE LIABLE FOR ANY
DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.*/
package com.cbouton.chocolatecraft.blocks;

import java.util.HashMap;
import java.util.Random;

import com.cbouton.chocolatecraft.lib.BlockStatics;
import com.cbouton.chocolatecraft.lib.Reference;
import com.cbouton.chocolatecraft.tileentities.TileEntityGrinder;
import com.cbouton.chocolatecraft.tileentities.TileEntityMixer;
import com.cbouton.chocolatecraft.utils.Position;
import com.cbouton.chocolatecraft.utils.Utils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockMixer extends BlockContainer{

	public BlockMixer(int id) {
		super(id, Material.iron);
		setUnlocalizedName(BlockStatics.BLOCK_MIXER_UNLOCALIZEDNAME);
		setStepSound(soundMetalFootstep);
		setHardness(5.0F);
		setCreativeTab(CreativeTabs.tabRedstone);
	}
    
	
    @SideOnly(Side.CLIENT)
    private Icon topIcon;
    @SideOnly(Side.CLIENT)
    private Icon activetopIcon;
    @SideOnly(Side.CLIENT)
    private Icon frontIcon;
    @SideOnly(Side.CLIENT)
    private Icon activefrontIcon;
    @SideOnly(Side.CLIENT)
    private Icon sideIcon;

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IconRegister icons){
    	topIcon = icons.registerIcon(Reference.MOD_ID + ":" + BlockStatics.BLOCK_MIXER_TOP);
    	frontIcon = icons.registerIcon(Reference.MOD_ID + ":" + BlockStatics.BLOCK_MIXER_FRONT);
    	sideIcon = icons.registerIcon(Reference.MOD_ID + ":" + BlockStatics.BLOCK_MACHINE_SIDES);
    	activefrontIcon = icons.registerIcon(Reference.MOD_ID + ":" + BlockStatics.BLOCK_MIXER_FRONT_ACTIVE);
    	activetopIcon = icons.registerIcon(Reference.MOD_ID + ":" + BlockStatics.BLOCK_MIXER_TOP_ACTIVE);
    }
    
    @Override
    public void onBlockPlacedBy(World world, int i, int j, int k, EntityLivingBase entityliving, ItemStack stack) {
		super.onBlockPlacedBy(world, i, j, k, entityliving, stack);

		ForgeDirection orientation = Utils.get2dOrientation(new Position(entityliving.posX, entityliving.posY, entityliving.posZ), new Position(i, j, k));

		world.setBlockMetadataWithNotify(i, j, k, orientation.getOpposite().ordinal(),1);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public Icon getBlockTexture(IBlockAccess world, int x, int y, int z, int side){
    	int metaData = world.getBlockMetadata(x, y, z);
    	TileEntityMixer mixer = (TileEntityMixer)world.getBlockTileEntity(x, y, z);
    	if (side == 0){
    		return sideIcon;
    	}
    	else if (side == 1){
    		return mixer.isActive() ? activetopIcon : topIcon;
    	}
    	else if (metaData == 0 && side == 3){
			return frontIcon;
    	}
    	else if (side == metaData && side > 1) {
			return mixer.isActive() ? activefrontIcon : frontIcon;	
		}
    	else{
    		return sideIcon;
    	}    	
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public Icon getIcon(int side, int metaData){
    	if (side == 0){
    		return sideIcon;
    	}
    	else if (side == 1){
    		return topIcon;
    	}
    	else if (metaData == 0 && side == 3){
			return frontIcon;
    	}

    	else if (side == metaData && side > 1) {
			return frontIcon;
		}
    	else{
    		return sideIcon;
    	}
    }


	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityMixer();
	}

}
