package com.ernstlustig.tutorial.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import com.ernstlustig.tutorial.reference.Reference;
import com.ernstlustig.tutorial.init.ModBlocks;

public class CreativeTabTutorial {
    public static final CreativeTabs TUTORIAL_TAB = new CreativeTabs( Reference.MOD_ID ){
        @Override
        public Item getTabIconItem() {
            return Item.getItemFromBlock( ModBlocks.cable );
        }

        @Override
        public String getTranslatedTabLabel(){
            return Reference.MOD_NAME;
        }
    };
}
