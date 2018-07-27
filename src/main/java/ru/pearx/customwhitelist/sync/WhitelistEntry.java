package ru.pearx.customwhitelist.sync;

import java.util.UUID;

/*
 * Created by mrAppleXZ on 27.07.18.
 */
public class WhitelistEntry
{
    private UUID uuid;
    private String username;

    public WhitelistEntry(UUID uuid, String username)
    {
        this.uuid = uuid;
        this.username = username;
    }

    public UUID getUuid()
    {
        return uuid;
    }

    public String getUsername()
    {
        return username;
    }
}
