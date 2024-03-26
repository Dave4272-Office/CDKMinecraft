package com.corpdk.minecraft.cdkminecraft

import com.corpdk.minecraft.cdkminecraft.placeholders.CDKPlaceholderExpansion
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class CDKMinecraft: JavaPlugin() {
    override fun onEnable() {
        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            CDKPlaceholderExpansion(this).register()
        }
        logger.info("${this.name} Enabled!")
    }

    override fun onDisable() {
        logger.info("${this.name} Disabled!")
    }
}