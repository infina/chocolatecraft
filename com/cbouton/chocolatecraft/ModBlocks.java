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
package com.cbouton.chocolatecraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

import com.cbouton.chocolatecraft.blocks.BlockFluidChocolate;
import com.cbouton.chocolatecraft.blocks.BlockGrinder;
import com.cbouton.chocolatecraft.blocks.BlockMixer;
import com.cbouton.chocolatecraft.blocks.BlockSeparator;
import com.cbouton.chocolatecraft.fluids.FluidChocolate;
import com.cbouton.chocolatecraft.lib.BlockStatics;
import com.cbouton.chocolatecraft.lib.FluidStatics;
import com.cbouton.chocolatecraft.lib.ItemStatics;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModBlocks {
	public static Block blockgrinder;
	public static Block blockmixer;
	public static Block blockseparator;
	public static Block blockfluidchocolate;
	public static Fluid fluidchocolate;

	public static void init() {
		blockgrinder = new BlockGrinder(BlockStatics.BLOCK_GRINDER);
		blockmixer = new BlockMixer(BlockStatics.BLOCK_MIXER);
		blockseparator = new BlockSeparator(BlockStatics.BLOCK_SEPARATOR);
		fluidchocolate = new FluidChocolate(FluidStatics.FLUID_CHOCOLATE_NAME);
		FluidRegistry.registerFluid(fluidchocolate);
		blockfluidchocolate = new BlockFluidChocolate(BlockStatics.BLOCK_LIQUID_CHOCOLATE, fluidchocolate, Material.water);
		//fluidchocolate.setBlockID(blockfluidchocolate);
		
		
		
		
		GameRegistry.registerBlock(blockgrinder, BlockStatics.BLOCK_GRINDER_UNLOCALIZEDNAME);
		GameRegistry.registerBlock(blockmixer, BlockStatics.BLOCK_MIXER_UNLOCALIZEDNAME);
		GameRegistry.registerBlock(blockseparator, BlockStatics.BLOCK_SEPARATOR_UNLOCALIZEDNAME);
		
		LanguageRegistry.addName(blockgrinder, BlockStatics.BLOCK_GRINDER_NAME);
		LanguageRegistry.addName(blockmixer, BlockStatics.BLOCK_MIXER_NAME);
		LanguageRegistry.addName(blockseparator, BlockStatics.BLOCK_SEPARATOR_NAME);
	}

}
