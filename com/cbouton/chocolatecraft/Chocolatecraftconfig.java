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

import com.cbouton.chocolatecraft.lib.BlockStatics;
import com.cbouton.chocolatecraft.lib.ChocolatecraftBooleans;
import com.cbouton.chocolatecraft.lib.FluidStatics;
import com.cbouton.chocolatecraft.lib.ItemStatics;

import cpw.mods.fml.common.FMLLog;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;
import static net.minecraftforge.common.Configuration.*;

public class Chocolatecraftconfig {

	public static void init(File configFile) {
		Configuration configuration = new Configuration(configFile);
		try {
            configuration.load();
            ItemStatics.ITEM_CHOCOLATE = configuration
            		.getItem("Chocolate", ItemStatics.ITEM_CHOCOLATE_DEFAULT)
            		.getInt(ItemStatics.ITEM_CHOCOLATE_DEFAULT) - 256;
            ItemStatics.ITEM_POWDEREDSUGAR = configuration
            		.getItem("Powdered Sugar", ItemStatics.ITEM_POWDEREDSUGAR_DEFAULT)
            		.getInt(ItemStatics.ITEM_POWDEREDSUGAR_DEFAULT) - 256;
            ItemStatics.ITEM_CHOCOLATEBAR = configuration
            		.getItem("Chocolate Bar", ItemStatics.ITEM_CHOCOLATEBAR_DEFAULT)
            		.getInt(ItemStatics.ITEM_CHOCOLATEBAR_DEFAULT) - 256;
            ItemStatics.ITEM_HOTCOCOA = configuration
            		.getItem("Hot Chocolate", ItemStatics.ITEM_HOTCOCOA_DEFAULT)
            		.getInt(ItemStatics.ITEM_HOTCOCOA_DEFAULT) - 256;
            ItemStatics.ITEM_HOTCHOCMARSH = configuration
            		.getItem("Hot Chocolate w/ Marshmallow", ItemStatics.ITEM_HOTCHOCMARSH_DEFAULT)
            		.getInt(ItemStatics.ITEM_CHOCOLATE_DEFAULT) - 256;
            ItemStatics.ITEM_MARSHMALLOW = configuration
            		.getItem("Marshmallow", ItemStatics.ITEM_MARSHMALLOW_DEFAULT)
            		.getInt(ItemStatics.ITEM_MARSHMALLOW_DEFAULT) - 256;
            ItemStatics.ITEM_GELATIN = configuration
            		.getItem("Gelatin", ItemStatics.ITEM_GELATIN_DEFAULT)
            		.getInt(ItemStatics.ITEM_GELATIN_DEFAULT) - 256;
            ItemStatics.ITEM_CHOCOLATEMILK = configuration
            		.getItem("Chocolate Milk", ItemStatics.ITEM_CHOCOLATEMILK_DEFAULT)
            		.getInt(ItemStatics.ITEM_CHOCOLATEMILK_DEFAULT) - 256;
            ItemStatics.ITEM_ROASTEDMARSHMALLOW = configuration
            		.getItem("Roasted Marshmallow", ItemStatics.ITEM_ROASTEDMARSHMALLOW_DEFAULT)
            		.getInt(ItemStatics.ITEM_ROASTEDMARSHMALLOW_DEFAULT) - 256;
            ItemStatics.ITEM_GRAHAM = configuration
            		.getItem("Graham Cracker", ItemStatics.ITEM_GRAHAM_DEFAULT)
            		.getInt(ItemStatics.ITEM_GRAHAM_DEFAULT) - 256;
            ItemStatics.ITEM_SMORE = configuration
            		.getItem("S'more", ItemStatics.ITEM_SMORE_DEFAULT)
            		.getInt(ItemStatics.ITEM_SMORE_DEFAULT) - 256;
            ItemStatics.ITEM_HOTCHOCMARSH_EFFECT_TIME = configuration
            		.getItem("Effect Time 2", ItemStatics.ITEM_HOTCHOCMARSH_EFFECT_TIME_DEFAULT)
            		.getInt(ItemStatics.ITEM_HOTCHOCMARSH_EFFECT_TIME_DEFAULT);
            ItemStatics.ITEM_HOTCOCOA_EFFECT_TIME = configuration
            		.getItem("Effect Time 1", ItemStatics.ITEM_HOTCOCOA_EFFECT_TIME_DEFAULT)
            		.getInt(ItemStatics.ITEM_HOTCOCOA_EFFECT_TIME_DEFAULT);
            BlockStatics.BLOCK_LIQUID_CHOCOLATE = configuration
            		.getBlock("Liquid Chocolate", BlockStatics.BLOCK_LIQUID_CHOCOLATE_DEFAULT)
            		.getInt(BlockStatics.BLOCK_LIQUID_CHOCOLATE_DEFAULT);
            FluidStatics.FLUID_CHOCOLATE = configuration
            		.getBlock("Fluid Chocolate", FluidStatics.FLUID_CHOCOLATE_DEFAULT)
            		.getInt(FluidStatics.FLUID_CHOCOLATE_DEFAULT);
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
