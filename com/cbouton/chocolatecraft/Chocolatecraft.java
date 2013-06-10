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

import java.io.File;
import java.util.logging.Logger;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import com.cbouton.chocolatecraft.lib.ItemIds;
import com.cbouton.chocolatecraft.Chocolatecraftconfig;
import com.cbouton.chocolatecraft.ModItems;

@Mod(modid="Chocolatecraft", name="Chocolatecraft", version="1.3.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class Chocolatecraft {
	@Instance("Chocolatecraft")
	public static Chocolatecraft instance;
	@SidedProxy(clientSide="com.cbouton.chocolatecraft.ChocolatecraftClientProxy", serverSide="com.cbouton.chocolatecraft.ChocolatecraftCommonProxy")
	public static ChocolatecraftCommonProxy proxy;
	
		
	
	
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		Chocolatecraftconfig.init(event.getSuggestedConfigurationFile());
		System.out.println("ChocolateCraft Config Loaded");
	}
	
	@Init
	public void load(FMLInitializationEvent event) {
		ModItems.init();
		//ModBlocks.init();
		MinecraftForge.EVENT_BUS.register(new EntityInteractionHandler());
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		
	}
}