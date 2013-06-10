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
import java.util.logging.Level;

import com.cbouton.chocolatecraft.lib.BlockIds;
import com.cbouton.chocolatecraft.lib.ChocolatecraftBooleans;
import com.cbouton.chocolatecraft.lib.ItemIds;

import cpw.mods.fml.common.FMLLog;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;
import static net.minecraftforge.common.Configuration.*;

public class Chocolatecraftconfig {

	public static void init(File configFile) {
		Configuration configuration = new Configuration(configFile);
		try {
            configuration.load();
            ItemIds.ITEM_CHOCOLATE = configuration
            		.getItem("Chocolate", ItemIds.ITEM_CHOCOLATE_DEFAULT)
            		.getInt(ItemIds.ITEM_CHOCOLATE_DEFAULT);
            ItemIds.ITEM_POWDEREDSUGAR = configuration
            		.getItem("Powdered Sugar", ItemIds.ITEM_POWDEREDSUGAR_DEFAULT)
            		.getInt(ItemIds.ITEM_POWDEREDSUGAR_DEFAULT);
            ItemIds.ITEM_CHOCOLATEBAR = configuration
            		.getItem("Chocolate Bar", ItemIds.ITEM_CHOCOLATEBAR_DEFAULT)
            		.getInt(ItemIds.ITEM_CHOCOLATEBAR_DEFAULT);
            ItemIds.ITEM_HOTCOCOA = configuration
            		.getItem("Hot Chocolate", ItemIds.ITEM_HOTCOCOA_DEFAULT)
            		.getInt(ItemIds.ITEM_HOTCOCOA_DEFAULT);
            ItemIds.ITEM_HOTCHOCMARSH = configuration
            		.getItem("Hot Chocolate w/ Marshmallow", ItemIds.ITEM_HOTCHOCMARSH_DEFAULT)
            		.getInt(ItemIds.ITEM_CHOCOLATE_DEFAULT);
            ItemIds.ITEM_MARSHMALLOW = configuration
            		.getItem("Marshmallow", ItemIds.ITEM_MARSHMALLOW_DEFAULT)
            		.getInt(ItemIds.ITEM_MARSHMALLOW_DEFAULT);
            ItemIds.ITEM_GELATIN = configuration
            		.getItem("Gelatin", ItemIds.ITEM_GELATIN_DEFAULT)
            		.getInt(ItemIds.ITEM_GELATIN_DEFAULT);
            ItemIds.ITEM_CHOCOLATEMILK = configuration
            		.getItem("Chocolate Milk", ItemIds.ITEM_CHOCOLATEMILK_DEFAULT)
            		.getInt(ItemIds.ITEM_CHOCOLATEMILK_DEFAULT);
            ItemIds.ITEM_ROASTEDMARSHMALLOW = configuration
            		.getItem("Roasted Marshmallow", ItemIds.ITEM_ROASTEDMARSHMALLOW_DEFAULT)
            		.getInt(ItemIds.ITEM_ROASTEDMARSHMALLOW_DEFAULT);
            ItemIds.ITEM_GRAHAM = configuration
            		.getItem("Graham Cracker", ItemIds.ITEM_GRAHAM_DEFAULT)
            		.getInt(ItemIds.ITEM_GRAHAM_DEFAULT);
            ItemIds.ITEM_SMORE = configuration
            		.getItem("S'more", ItemIds.ITEM_SMORE_DEFAULT)
            		.getInt(ItemIds.ITEM_SMORE_DEFAULT);
            ItemIds.ITEM_HOTCHOCMARSH_EFFECT_TIME = configuration
            		.getItem("Effect Time 2", ItemIds.ITEM_HOTCHOCMARSH_EFFECT_TIME_DEFAULT)
            		.getInt(ItemIds.ITEM_HOTCHOCMARSH_EFFECT_TIME_DEFAULT);
            ItemIds.ITEM_HOTCOCOA_EFFECT_TIME = configuration
            		.getItem("Effect Time 1", ItemIds.ITEM_HOTCOCOA_EFFECT_TIME_DEFAULT)
            		.getInt(ItemIds.ITEM_HOTCOCOA_EFFECT_TIME_DEFAULT);
            BlockIds.BLOCK_GRINDER = configuration
            		.getBlock("Grinder", BlockIds.BLOCK_GRINDER_DEFAULT)
            		.getInt(BlockIds.BLOCK_GRINDER_DEFAULT);
            BlockIds.BLOCK_MIXER = configuration
            		.getBlock("Mixer", BlockIds.BLOCK_MIXER_DEFAULT)
            		.getInt(BlockIds.BLOCK_MIXER_DEFAULT);
            BlockIds.BLOCK_SEPARATOR = configuration
            		.getBlock("Separator", BlockIds.BLOCK_SEPARATOR_DEFAULT)
            		.getInt(BlockIds.BLOCK_SEPARATOR_DEFAULT);
            BlockIds.LIQUID_CHOCOLATE = configuration
            		.getBlock("Liquid Chocolate", BlockIds.LIQUID_CHOCOLATE_DEFAULT)
            		.getInt(BlockIds.LIQUID_CHOCOLATE_DEFAULT);
            ChocolatecraftBooleans.LOG_POISON = configuration
            		.get("Log Options", "Poison Logger", ChocolatecraftBooleans.LOG_POISON_DEFAULT)
            		.getBoolean(ChocolatecraftBooleans.LOG_POISON_DEFAULT);
		}
		catch (Exception e) {
            FMLLog.log(Level.SEVERE, e, "ChocolateCraft has had a problem loading its configuration");
        }
        finally {
            configuration.save();
        }
	}

}
