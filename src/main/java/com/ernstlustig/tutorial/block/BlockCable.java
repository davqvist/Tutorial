package com.ernstlustig.tutorial.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class BlockCable extends BlockTutorial {

    public static final PropertyBool NORTH = PropertyBool.create("north");
    public static final PropertyBool EAST = PropertyBool.create("east");
    public static final PropertyBool SOUTH = PropertyBool.create("south");
    public static final PropertyBool WEST = PropertyBool.create("west");
    public static final PropertyBool UP = PropertyBool.create("up");
    public static final PropertyBool DOWN = PropertyBool.create("down");

    public BlockCable(){
        super( new Material( MapColor.blackColor ) );
        this.setUnlocalizedName("cable");
        this.setBlockBounds( 0.3125F, 0.3125F, 0.3125F, 0.6875F, 0.6875F, 0.6875F );
        this.setDefaultState( this.blockState.getBaseState().withProperty( NORTH, Boolean.valueOf( false ) ).withProperty( EAST, Boolean.valueOf( false ) ).withProperty( SOUTH, Boolean.valueOf( false ) ).withProperty( WEST, Boolean.valueOf( false ) ).withProperty( UP, Boolean.valueOf( false ) ).withProperty( DOWN, Boolean.valueOf( false ) ) );
    }

    @SideOnly(Side.CLIENT)
    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.CUTOUT_MIPPED;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    public boolean canConnectTo( IBlockAccess worldIn, BlockPos pos ) {
        Block block = worldIn.getBlockState( pos ).getBlock();
        return( block instanceof BlockCable );
    }

    @Override
    public int getMetaFromState( IBlockState state ) {
        return 0;
    }

    @Override
    public IBlockState getActualState( IBlockState state, IBlockAccess worldIn, BlockPos pos ) {
        return state.withProperty( NORTH, Boolean.valueOf( this.canConnectTo( worldIn, pos.north() ) ) ).withProperty( EAST, Boolean.valueOf( this.canConnectTo( worldIn, pos.east() ) ) ).withProperty( SOUTH, Boolean.valueOf( this.canConnectTo( worldIn, pos.south() ) ) ).withProperty( WEST, Boolean.valueOf( this.canConnectTo( worldIn, pos.west() ) ) ).withProperty( UP, Boolean.valueOf( this.canConnectTo( worldIn, pos.up() ) ) ).withProperty( DOWN, Boolean.valueOf( this.canConnectTo( worldIn, pos.down() ) ) );
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState( this, new IProperty[] {NORTH, EAST, SOUTH, WEST, UP, DOWN} );
    }

    @Override
    public void setBlockBoundsBasedOnState( IBlockAccess worldIn, BlockPos pos ){
        float xmin = this.canConnectTo( worldIn, pos.west() ) ? 0.0F : 0.3125F;
        float xmax = this.canConnectTo( worldIn, pos.east() ) ? 1.0F : 0.6875F;
        float ymin = this.canConnectTo( worldIn, pos.down() ) ? 0.0F : 0.3125F;
        float ymax = this.canConnectTo( worldIn, pos.up() ) ? 1.0F : 0.6875F;
        float zmin = this.canConnectTo( worldIn, pos.north() ) ? 0.0F : 0.3125F;
        float zmax = this.canConnectTo( worldIn, pos.south() ) ? 1.0F : 0.6875F;

        this.setBlockBounds( xmin, ymin, zmin, xmax, ymax, zmax );
    }

    @Override
    public void addCollisionBoxesToList( World worldIn, BlockPos pos, IBlockState state, AxisAlignedBB mask, List<AxisAlignedBB> list, Entity collidingEntity ){
        float min = 0.3125F;
        float max = 0.6875F;

        this.setBlockBounds( min, min, min, max, max, max );
        super.addCollisionBoxesToList( worldIn, pos, state, mask, list, collidingEntity );

        if( this.canConnectTo( worldIn, pos.west() ) ){
            this.setBlockBounds( 0.0F, min, min, max, max, max );
            super.addCollisionBoxesToList( worldIn, pos, state, mask, list, collidingEntity );
        }
        if( this.canConnectTo( worldIn, pos.east() ) ){
            this.setBlockBounds( min, min, min, 1.0F, max, max );
            super.addCollisionBoxesToList( worldIn, pos, state, mask, list, collidingEntity );
        }
        if( this.canConnectTo( worldIn, pos.down() ) ){
            this.setBlockBounds( min, 0.0F, min, max, max, max );
            super.addCollisionBoxesToList( worldIn, pos, state, mask, list, collidingEntity );
        }
        if( this.canConnectTo( worldIn, pos.up() ) ){
            this.setBlockBounds( min, min, min, max, 1.0F, max );
            super.addCollisionBoxesToList( worldIn, pos, state, mask, list, collidingEntity );
        }
        if( this.canConnectTo( worldIn, pos.north() ) ){
            this.setBlockBounds( min, min, 0.0F, max, max, max );
            super.addCollisionBoxesToList( worldIn, pos, state, mask, list, collidingEntity );
        }
        if( this.canConnectTo( worldIn, pos.south() ) ){
            this.setBlockBounds( min, min, min, max, max, 1.0F );
            super.addCollisionBoxesToList( worldIn, pos, state, mask, list, collidingEntity );
        }
    }

}
