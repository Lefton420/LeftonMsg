package org.lefton.leftonmsg.commands;

import org.apache.commons.lang.CharUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.lefton.leftonmsg.LeftonMsg;

public class Msg implements CommandExecutor {
    private LeftonMsg plugin;

    public Msg (LeftonMsg plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(final CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Error: Must be a player to use this command.");
            return true;
        }

        Player reciever = Bukkit.getPlayer(args[0]);

        if( reciever == null) {
            sender.sendMessage(ChatColor.RED + "Error: This player is offline");
            return true;
        }
         String recivermsg = ChatColor.LIGHT_PURPLE + sender.getName() + " whispers: ";
         String sendermsg = ChatColor.LIGHT_PURPLE +"To " + reciever.getName() + ": " ;

        for (int i = 1; i < args.length; i++) {
            recivermsg+= args[i] +" ";
            sendermsg+= args[i] +" ";
        }
        sender.sendMessage(sendermsg);
        reciever.sendMessage(recivermsg);

        if(plugin.getLastMessage(reciever.getName()) != null){
            plugin.updateLastMessage(reciever.getName(), sender.getName());
        }
        else plugin.addLastMessage(reciever.getName(), sender.getName());


        return true;
    }

}