package com.ernstlustig.tutorial.item;

import com.ernstlustig.tutorial.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemTutorial extends Item {

    public ItemTutorial(){
        super();
        setCreativeTab( CreativeTabs.tabMisc );
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format( "item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName( super.getUnlocalizedName() ) );
    }

    @Override
    public String getUnlocalizedName( ItemStack itemStack )
    {
        return String.format( "item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName( super.getUnlocalizedName() ) );
    }

    protected String getUnwrappedUnlocalizedName( String unlocalizedName )
    {
        return unlocalizedName.substring( unlocalizedName.indexOf(".") + 1 );
    }
}
