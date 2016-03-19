package com.ernstlustig.tutorial.handler;

import com.ernstlustig.tutorial.reference.Reference;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

public class ConfigurationHandler {

    public static Configuration config;
    public static boolean configValue = false;

    public static void init( File configFile ){
        if( config == null ) {
            config = new Configuration(configFile);
        }
        loadConfiguration();
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent( ConfigChangedEvent.OnConfigChangedEvent event ){
        if( event.modID.equalsIgnoreCase( Reference.MOD_ID ) ){
            loadConfiguration();
        }
    }

    private static void loadConfiguration(){

        //try{
        //config.load(); Why don't we need this anymore?

        configValue = config.getBoolean( "configValue", Configuration.CATEGORY_GENERAL, false, "This is an example comment." );
        //}
        //catch( Exception e ){
        // Log
        // }
        //finally{
        if( config.hasChanged() ){
            config.save();
        }
        //}
    }
}
