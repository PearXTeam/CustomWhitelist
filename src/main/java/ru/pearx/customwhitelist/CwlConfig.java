package ru.pearx.customwhitelist;

import net.minecraftforge.common.config.Config;
import ru.pearx.customwhitelist.sync.SyncMethod;

/*
 * Created by mrAppleXZ on 26.07.18.
 */
@Config(modid = CustomWhitelist.MODID)
public class CwlConfig
{
    @Config.Comment({
            "The custom whitelist message feature.",
            "That feature sets a custom message that will be shown to non-white-listed players instead of the standard \"You are not white-listed on this server!\"."
    })
    public static CustomMessage customMessage = new CustomMessage();

    @Config.Comment({
            "The whitelist synchronization feature.",
            "With the whitelist synchronization, you can keep your server's whitelist up-to-date with a remote source.",
            "For instance, this will be useful, if you have a moderation process of the players before taking them to the server, or you have a paid server with automatic payment system.",
            "Currently, there are two ways of syncing the whitelist: automatic synchronization at specified intervals (see the \"interval\" option) and the \"/customwhitelist sync\" command."
    })
    public static Sync sync = new Sync();

    public static class CustomMessage
    {
        @Config.Comment("Enables or disables the custom message feature.")
        public boolean enable = true;

        @Config.Comment("A text of the custom message.")
        public String message = "Send a whitelist request firstly!";
    }

    public static class Sync
    {
        @Config.Comment({
                "Enables or disables the synchronization of the whitelist.",
                "NOTE: Don't forget to set up the \"method\" option and the corresponding options to it!"
        })
        public boolean enable = false;

        @Config.RangeInt(min = 0)
        @Config.Comment({
                "An interval in seconds between automatic synchronizations of the whitelist. Set to 0 to disable it.",
                "If it is enabled, the whitelist also will be synced on the server startup."
        })
        public int interval = 300;

        @Config.Comment({
                "The method that will be used to synchronize the whitelist.",
                "Currently, there are two methods supported:",
                "1) HTTP - sends an HTTP GET request to URL specified in the \"httpUrl\" option.",
                "The server must return a JSON in the format of vanilla \"whitelist.json\".",
                "(e.g. [{\"uuid\": \"00000000-0000-0000-0000-000000000000\", \"name\": \"user1\"}, {\"uuid\": \"123e4567-e89b-12d3-a456-426655440000\", \"name\": \"user2\"}])",
                "The UUIDs can be formatted with dashes or without, no matter.",
                "2) JDBC - Connects to a database using a JDBC connection URL specified in the \"jdbcUrl\" option and executes a query specified in the \"jdbcQuery\" option.",
                "The server must return two columns: first one should be filled with UUIDs, second one should be filled with usernames.",
                "The UUIDs can be formatted with dashes or without, no matter."
        })
        public SyncMethod method = SyncMethod.HTTP;

        @Config.Comment("See the \"method\" option.")
        public String httpUrl = "https://127.0.0.1/minecraft/whitelist?token=exampletoken";

        @Config.Comment("See the \"method\" option.")
        public String jdbcUrl = "jdbc:mysql://127.0.0.1/minecraft?user=YOUR_USERNAME&password=YOUR_PASSWORD";

        @Config.Comment("See the \"method\" option.")
        public String jdbcQuery = "SELECT `uuid`, `username` FROM `players` WHERE `access` = 2;";
    }
}
