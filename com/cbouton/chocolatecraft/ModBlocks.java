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
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.cbouton.chocolatecraft.blocks.BlockFluidChocolate;
import com.cbouton.chocolatecraft.fluids.FluidChocolate;
import com.cbouton.chocolatecraft.items.ItemChocolate;
import com.cbouton.chocolatecraft.lib.BlockStatics;
import com.cbouton.chocolatecraft.lib.ItemStatics;

import forestry.api.recipes.ISqueezerManager;
import forestry.api.recipes.RecipeManagers;

public class ModBlocks {
	public static Block blockfluidchocolate;
	public static Fluid fluidchocolate;
	public static ItemStack[] itemStacks = {new ItemStack(358, 1, 3)};
	public static ItemChocolate itemChocolate = new ItemChocolate(ItemStatics.ITEM_CHOCOLATE);
	public static ItemStack itemstackChocolate = new ItemStack(itemChocolate);

	public static void init() {
		FluidRegistry.registerFluid(fluidchocolate);
		blockfluidchocolate = new BlockFluidChocolate(BlockStatics.BLOCK_LIQUID_CHOCOLATE, fluidchocolate, Material.water);
		RecipeManagers.squeezerManager.addRecipe(3, itemStacks, new FluidStack(fluidchocolate, 100), itemstackChocolate, 25);
	}
	
}
