package com.corpdk.minecraft

import org.bukkit.plugin.java.JavaPlugin

class CDKMinecraftServerPlugin: JavaPlugin() {
    override fun onEnable() {
        logger.info("${this.name} Enabled!")
    }

    override fun onDisable() {
        logger.info("${this.name} Disabled!")
    }
}