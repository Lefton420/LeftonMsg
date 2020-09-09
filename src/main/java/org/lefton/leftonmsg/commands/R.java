package org.lefton.leftonmsg.commands;

import org.apache.commons.lang.CharUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.lefton.leftonmsg.LeftonMsg;

public class R implements CommandExecutor {
    private LeftonMsg plugin;

    public R (LeftonMsg plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(final CommandSender sender, Command command, String label, String[] args) {

        // Makes sure its a player
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Error: Must be a player to use this command.");
            return true;
        }

        // Makes sure you can reply
        if(plugin.getLastMessage(sender.getName()) == null){
            sender.sendMessage(ChatColor.RED + "Error: You have know-one to reply to!");
            return true;
        }

        Player reciever = Bukkit.getPlayer(plugin.getLastMessage(sender.getName()).getLastMsgPlayer());

        // Makes sure you can reply
        if( reciever == null) {
            sender.sendMessage(ChatColor.RED + "Error: This player is offline");
            return true;
        }
        String recivermsg = ChatColor.LIGHT_PURPLE + sender.getName() + " whispers: ";
        String sendermsg = ChatColor.LIGHT_PURPLE +"To " + reciever.getName() + ": " ;

        for (int i = 0; i < args.length; i++) {
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

    }}