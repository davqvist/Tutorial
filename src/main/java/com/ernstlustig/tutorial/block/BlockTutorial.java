package com.ernstlustig.tutorial.block;

import com.ernstlustig.tutorial.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockTutorial extends Block {

    public BlockTutorial( Material material ){
        super( material );
        setCreativeTab( CreativeTabs.tabMisc );
    }

    public BlockTutorial(){
        this( Material.rock );
    }

    @Override
    public String getUnlocalizedName(){
        return String.format( "tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName( super.getUnlocalizedName() ) );
    }

    protected String getUnwrappedUnlocalizedName( String unlocalizedName ){
        return unlocalizedName.substring( unlocalizedName.indexOf(".") + 1 );
    }
}
