package org.lefton.leftonkill;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;


public class LeftonKill extends JavaPlugin {

    @Override
    public void onEnable(){

    }
    @Override
    public void onDisable(){

    }
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(label.equalsIgnoreCase("kill")){
            if(sender instanceof Player) {

                Player player = (Player) sender;
                for(PotionEffect effect:player.getActivePotionEffects()){
                    player.removePotionEffect(effect.getType());
                }
                player.damage(player.getHealth());
                return true;
            }
            else {
                return true;
            }

        }
        return false;
    }
}

