package com.corpdk.minecraft.cdkminecraft.placeholders

import com.corpdk.minecraft.cdkminecraft.CDKMinecraft
import me.clip.placeholderapi.expansion.PlaceholderExpansion
import org.bukkit.OfflinePlayer

class CDKPlaceholderExpansion(private val plugin: CDKMinecraft): PlaceholderExpansion() {
    override fun getIdentifier(): String {
        return plugin.name.lowercase()
    }

    override fun getAuthor(): String {
        return plugin.description.authors.joinToString(", ")
    }

    override fun getVersion(): String {
        return plugin.description.version
    }

    override fun persist(): Boolean {
        return true
    }

    override fun onRequest(player: OfflinePlayer, params: String): String? {
        return when {
            params.equals("test", ignoreCase = true) -> "${plugin.name} Test Placeholder"
//            params.equals("placeholder2", ignoreCase = true) -> plugin.config.getString("placeholders.placeholder2", "default2")
            else -> null
        }
    }
}