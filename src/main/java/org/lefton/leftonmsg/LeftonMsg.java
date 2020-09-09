package org.lefton.leftonmsg;

import org.bukkit.plugin.java.JavaPlugin;
import org.lefton.leftonmsg.api.LastMsg;
import org.lefton.leftonmsg.commands.Msg;
import org.lefton.leftonmsg.commands.R;

import java.util.ArrayList;

public class LeftonMsg extends JavaPlugin {

    // makes an empty array of the LastMsg object (containg 2 varibiles)
    private ArrayList <LastMsg> lastMsgs = new ArrayList<LastMsg>();


    @Override
    public void onEnable() {
        this.getCommand("msg").setExecutor(new Msg(this));
        this.getCommand("w").setExecutor(new Msg(this));
        this.getCommand("r").setExecutor(new R(this));
    }

    public void addLastMessage(String user, String lastMsgPlayer) {
        lastMsgs.add(new LastMsg(user, lastMsgPlayer));
    }

    public void updateLastMessage(String user, String lastMsgPlayer) {
        for(LastMsg lastMsg: lastMsgs) {
            if(lastMsg.getUser().equalsIgnoreCase(user)) {
                lastMsg.setLastMsgPlayer(lastMsgPlayer);
                break;
            }
        }
    }

    public LastMsg getLastMessage(String user) {

        for(LastMsg lastMsg: lastMsgs) {

            if( lastMsg.getUser().equalsIgnoreCase(user)) return lastMsg;

        }


        return null;

    }


}
