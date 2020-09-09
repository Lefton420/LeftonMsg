package org.lefton.leftonmsg.api;

public class LastMsg {

    String user, lastMsgPlayer;

    public LastMsg(String user, String lastMsgPlayer) {
        this.user = user;
        this.lastMsgPlayer = lastMsgPlayer;
    }

    public String getUser() {
        return user;
    }

    public String getLastMsgPlayer() {
        return lastMsgPlayer;
    }

    public void setLastMsgPlayer(String lastMsgPlayer) {
        this.lastMsgPlayer = lastMsgPlayer;
    }
}
