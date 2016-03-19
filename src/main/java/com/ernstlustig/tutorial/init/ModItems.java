package com.ernstlustig.tutorial.init;

import com.ernstlustig.tutorial.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@GameRegistry.ObjectHolder( Reference.MOD_ID )
public class ModItems {

    //public static final ItemTutorial mapleLeaf = new ItemMapleLeaf();

    public static void registerItems(){
        //GameRegistry.registerItem( mapleLeaf, "mapleLeaf" );
    }

    @SideOnly(Side.CLIENT)
    public static void loadTextures(){
        //Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register( mapleLeaf, 0, new ModelResourceLocation( mapleLeaf.getUnlocalizedName().substring(5), "inventory" ) );
    }
}
