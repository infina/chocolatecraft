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

import java.lang.reflect.Field;
import java.util.Random;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bouncycastle.crypto.prng.RandomGenerator;

import com.cbouton.chocolatecraft.lib.ChocolatecraftBooleans;
import com.cbouton.chocolatecraft.lib.ItemIds;

import cpw.mods.fml.common.FMLLog;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.item.Item;
import net.minecraft.item.ItemExpBottle;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.EntityInteractEvent;

public class EntityInteractionHandler {
	@ForgeSubscribe
	public void onEntityInteractEvent(EntityInteractEvent event) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		if (event.target instanceof EntityWolf && event.entityPlayer.getHeldItem() != null){
			if (event.entityPlayer.getHeldItem().getItemName().equals("item.chocolatebar")){
					TheobrominePoisoner.PoisonEntity(event.entityPlayer, ((EntityLiving)event.target));
					EntityWolf wolf = (EntityWolf) event.target;
					String owner = wolf.getOwnerName();
					if ((owner.length() != 0 || event.entityPlayer.getEntityName() != "_infina_") && ChocolatecraftBooleans.LOG_POISON){
						FMLLog.info("[ChocolateCraft] " + event.entityPlayer.getEntityName() + " poisoned " + owner + "'s wolf.", event.entityPlayer);
					}
			}
		}
		else if (event.target instanceof EntityOcelot && event.entityPlayer.getHeldItem() != null){
			if (event.entityPlayer.getHeldItem().getItemName().equals("item.chocolatebar")){
				int randint = (int) Math.round(Math.random() * 4);
				event.entityPlayer.getHeldItem().stackSize = event.entityPlayer.getHeldItem().stackSize - 1;
				if (randint == 4){
					TheobrominePoisoner.PoisonEntity(event.entityPlayer, ((EntityLiving)event.target));
					EntityOcelot cat = (EntityOcelot) event.target;
					String owner = cat.getOwnerName();
					if ((owner.length() != 0 || event.entityPlayer.getEntityName() != "_infina_") && ChocolatecraftBooleans.LOG_POISON){
						FMLLog.info("[ChocolateCraft] " + event.entityPlayer.getEntityName() + " poisoned " + owner + "'s cat.", event.entityPlayer);
					}
				}
			}
		}
			else if (event.target instanceof EntityWolf && event.entityPlayer.getHeldItem() == null){
				event.target.interact(event.entityPlayer);
			}
			else if (event.target instanceof EntityVillager && event.entityPlayer.getHeldItem() != null){
			if (event.entityPlayer.getHeldItem().getItemName().equals("item.chocolatebar")){
				EntityVillager villager = (EntityVillager) event.target;
				villager.heal(4);
				event.entityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.emerald, 2));
				event.entityPlayer.getHeldItem().stackSize = event.entityPlayer.getHeldItem().stackSize - 1;
			}
		}
	}
}
