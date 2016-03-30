package com.ernstlustig.tutorial.block;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockCupboard extends BlockTutorial {

    public static final PropertyDirection FACING = PropertyDirection.create( "facing", EnumFacing.Plane.HORIZONTAL );

    public BlockCupboard(){
        super( new Material( MapColor.brownColor ) );
        this.setUnlocalizedName("cupboard");
        this.setDefaultState( this.blockState.getBaseState().withProperty( FACING, EnumFacing.NORTH ) );
    }

    @Override
    public int getMetaFromState( IBlockState state ) {
        return state.getValue( FACING ).getIndex();
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState( this, new IProperty[] {FACING} );
    }

    @Override
    public IBlockState onBlockPlaced( World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer )
    {
        return this.getDefaultState().withProperty( FACING, placer.getHorizontalFacing().getOpposite() );
    }
}
