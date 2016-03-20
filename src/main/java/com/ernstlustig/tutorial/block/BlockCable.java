package com.ernstlustig.tutorial.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCable extends BlockTutorial {

    public static final PropertyBool NORTH = PropertyBool.create("north");

    public BlockCable(){
        super( new Material( MapColor.blackColor ) );
        this.setUnlocalizedName("cable");
        this.setBlockBounds( 0.3125F, 0.3125F, 0.3125F, 0.6875F, 0.6875F, 0.6875F );
        this.setDefaultState( this.blockState.getBaseState().withProperty( NORTH, Boolean.valueOf( false ) ) );
    }

    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.CUTOUT;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    public boolean canConnectTo(IBlockAccess worldIn, BlockPos pos)
    {
        Block block = worldIn.getBlockState(pos).getBlock();
        return (block instanceof BlockCable);
    }

    public int getMetaFromState(IBlockState state)
    {
        return 0;
    }

    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        return state.withProperty( NORTH, Boolean.valueOf( this.canConnectTo( worldIn, pos.north() ) ) );
    }

    protected BlockState createBlockState()
    {
        return new BlockState( this, new IProperty[] {NORTH} );
    }
}
