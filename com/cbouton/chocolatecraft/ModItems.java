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

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;

import com.cbouton.chocolatecraft.fluids.FluidChocolate;
import com.cbouton.chocolatecraft.items.ItemChocolate;
import com.cbouton.chocolatecraft.items.ItemChocolateBar;
import com.cbouton.chocolatecraft.items.ItemChocolateMilk;
import com.cbouton.chocolatecraft.items.ItemGelatin;
import com.cbouton.chocolatecraft.items.ItemGraham;
import com.cbouton.chocolatecraft.items.ItemHotChocolateMarshmallow;
import com.cbouton.chocolatecraft.items.ItemHotCocoa;
import com.cbouton.chocolatecraft.items.ItemMarshmallow;
import com.cbouton.chocolatecraft.items.ItemPowderedSugar;
import com.cbouton.chocolatecraft.items.ItemRoastedMarshmallow;
import com.cbouton.chocolatecraft.items.ItemSmore;
import com.cbouton.chocolatecraft.lib.ItemIds;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModItems {

	public static void init() {
		Item ItemChocolate = new ItemChocolate(ItemIds.ITEM_CHOCOLATE);
		Item ItemPowderedSugar = new ItemPowderedSugar(ItemIds.ITEM_POWDEREDSUGAR);
		Item ItemChocolateBar = new ItemChocolateBar(ItemIds.ITEM_CHOCOLATEBAR, 10, true);
		Item ItemHotCocoa = new ItemHotCocoa(ItemIds.ITEM_HOTCOCOA, 10, false);
		Item ItemHotChocoMarsh = new ItemHotChocolateMarshmallow(ItemIds.ITEM_HOTCHOCMARSH, 15, false);
		Item ItemMarshmallow = new ItemMarshmallow(ItemIds.ITEM_MARSHMALLOW);
		Item ItemGelatin = new ItemGelatin(ItemIds.ITEM_GELATIN);
		Item ItemChocolateMilk = new ItemChocolateMilk(ItemIds.ITEM_CHOCOLATEMILK, 4, false);
		Item ItemRoastedMarshmallow = new ItemRoastedMarshmallow(ItemIds.ITEM_ROASTEDMARSHMALLOW, 4, false);
		Item ItemGraham = new ItemGraham(ItemIds.ITEM_GRAHAM, 4, false);
		Item ItemSmore = new ItemSmore(ItemIds.ITEM_SMORE, 10, false);
		Fluid FluidChocolate = new FluidChocolate("FluidChocolate");
		
		ItemStack chocolate = new ItemStack(ItemChocolate);
		ItemStack powderedsugar = new ItemStack(ItemPowderedSugar);
		ItemStack powderedsugar6 = new ItemStack(ItemPowderedSugar, 6);
		ItemStack chocolatebar20 = new ItemStack(ItemChocolateBar, 20);
		ItemStack chocolatebar = new ItemStack(ItemChocolateBar);
		ItemStack hotcocoa = new ItemStack(ItemHotCocoa);
		ItemStack hotcocoamarsh = new ItemStack(ItemHotChocoMarsh);
		ItemStack cocoabeans = new ItemStack(351,1,3);
		ItemStack bonemeal = new ItemStack(351,1,15);
		ItemStack milk = new ItemStack(335,1,0);
		ItemStack blazerod = new ItemStack(369,1,0);
		ItemStack water = new ItemStack(326,1,0);
		ItemStack sugar = new ItemStack(Item.sugar);
		ItemStack wheat = new ItemStack(Item.wheat);
		ItemStack gelatin = new ItemStack(ItemGelatin);
		ItemStack marshmallow = new ItemStack(ItemMarshmallow);
		ItemStack marshmallow4 = new ItemStack(ItemMarshmallow, 4);
		ItemStack roastedmarshmallow = new ItemStack(ItemRoastedMarshmallow);
		ItemStack graham = new ItemStack(ItemGraham);
		ItemStack smore = new ItemStack(ItemSmore);
		
		GameRegistry.addRecipe(chocolate, "CCC", "PMP", "CCC", 'C', cocoabeans, 'P', powderedsugar, 'M', milk);
		GameRegistry.addShapelessRecipe(powderedsugar6, sugar, sugar, sugar, sugar);
		GameRegistry.addRecipe(chocolatebar20, "CCC", "CCC", "CCC", 'C', chocolate);
		GameRegistry.addRecipe(hotcocoa, "CCC", " B ", " W ", 'C', chocolate, 'B', blazerod, 'W', water);
		GameRegistry.addRecipe(graham, " W ", " M ", " W ", 'W', wheat, 'M', milk);
		GameRegistry.addRecipe(smore, " G ", "CRC", " G ", 'C', chocolatebar, 'G', graham, 'R', roastedmarshmallow);
		GameRegistry.addShapelessRecipe(marshmallow4, powderedsugar, gelatin, sugar, sugar);
		GameRegistry.addShapelessRecipe(gelatin, bonemeal, water);
		GameRegistry.addShapelessRecipe(hotcocoamarsh, hotcocoa, marshmallow);
		GameRegistry.addShapelessRecipe(new ItemStack(ItemChocolateMilk), milk, chocolate);
		GameRegistry.addSmelting(ItemMarshmallow.itemID, roastedmarshmallow, 0.5f);
		
		LanguageRegistry.addName(ItemChocolate, "Chocolate");
		LanguageRegistry.addName(ItemPowderedSugar, "Powdered Sugar");
		LanguageRegistry.addName(ItemChocolateBar, "Chocolate Bar");
		LanguageRegistry.addName(ItemHotCocoa, "Hot Cocoa");
		LanguageRegistry.addName(ItemHotChocoMarsh, "Hot Chocolate w/ Marshmallows");
		LanguageRegistry.addName(ItemMarshmallow, "Marshmallow");
		LanguageRegistry.addName(ItemGelatin, "Gelatin");
		LanguageRegistry.addName(ItemChocolateMilk, "Chocolate Milk");
		LanguageRegistry.addName(ItemRoastedMarshmallow, "Roasted Marshmallow");
		LanguageRegistry.addName(ItemGraham, "Graham Cracker");
		LanguageRegistry.addName(ItemSmore, "S'more");
	}

}
