package com.ernstlustig.tutorial.client.gui;

import com.ernstlustig.tutorial.handler.ConfigurationHandler;
import com.ernstlustig.tutorial.reference.Reference;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;

public class ModGuiConfig extends GuiConfig {
    public ModGuiConfig( GuiScreen guiScreen ) {
        super( guiScreen,
                new ConfigElement( ConfigurationHandler.config.getCategory( Configuration.CATEGORY_GENERAL ) ).getChildElements(),
                Reference.MOD_ID,
                false, //allRequireWorldRestart
                false, //allRequireMcRestart
                GuiConfig.getAbridgedConfigPath( ConfigurationHandler.config.toString() )
        );
    }
}
