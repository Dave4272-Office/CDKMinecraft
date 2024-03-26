package com.corpdk.minecraft.cdkminecraft

import org.bukkit.plugin.java.JavaPlugin

class CDKMinecraft: JavaPlugin() {
    override fun onEnable() {
        logger.info("${this.name} Enabled!")
    }

    override fun onDisable() {
        logger.info("${this.name} Disabled!")
    }
}