package ru.pearx.customwhitelist;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import java.util.Collections;

/*
 * Created by mrAppleXZ on 26.07.18.
 */
@Mod(name = CustomWhitelist.NAME, modid = CustomWhitelist.MODID, version = CustomWhitelist.VERSION, acceptedMinecraftVersions = "", acceptableRemoteVersions = "*")
public class CustomWhitelist
{
    @Mod.Instance
    public static CustomWhitelist INSTANCE;

    public static final String NAME = "Custom Whitelist";
    public static final String MODID = "customwhitelist";
    public static final String VERSION = "@VERSION@";
    public static final String DESCRIPTION = "@DESCRIPTION@";

    private Logger log;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {
        log = e.getModLog();
        setupMetadata(e.getModMetadata());

    }

    private void setupMetadata(ModMetadata d)
    {
        d.autogenerated = false;
        d.authorList = Collections.singletonList("mrAppleXZ");
        d.description = DESCRIPTION;
        d.version = VERSION;
        d.modId = MODID;
        d.name = NAME;
    }

    public Logger getLog()
    {
        return log;
    }
}
