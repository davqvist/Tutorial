package com.ernstlustig.tutorial.init;

import com.ernstlustig.tutorial.block.BlockCable;
import com.ernstlustig.tutorial.block.BlockCupboard;
import com.ernstlustig.tutorial.block.BlockTutorial;
import com.ernstlustig.tutorial.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@GameRegistry.ObjectHolder( Reference.MOD_ID )
public class ModBlocks {
    public static final BlockTutorial cable = new BlockCable();
    public static final BlockCupboard cupboard = new BlockCupboard();

    public static void registerBlocks(){
        GameRegistry.registerBlock( cable, "cable" );
        GameRegistry.registerBlock( cupboard, "cupboard" );
    }

    @SideOnly(Side.CLIENT)
    public static void loadTextures(){
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register( GameRegistry.findItem( Reference.MOD_ID.toLowerCase(), "cable" ), 0, new ModelResourceLocation( cable.getUnlocalizedName().substring(5), "inventory" ) );
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register( GameRegistry.findItem( Reference.MOD_ID.toLowerCase(), "cupboard" ), 0, new ModelResourceLocation( cupboard.getUnlocalizedName().substring(5), "inventory" ) );
    }
}
