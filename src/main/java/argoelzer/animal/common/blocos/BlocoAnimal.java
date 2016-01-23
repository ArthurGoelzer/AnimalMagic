package argoelzer.animal.common.blocos;

import argoelzer.animal.common.AnimalMagic;
import argoelzer.animal.common.GuiHandler;
import argoelzer.animal.common.lib.Nomes;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlocoAnimal extends BlockContainer {

    public BlocoAnimal() {
        super(Material.iron);
        this.setHardness(1f);
        this.setBlockName(Nomes.BLOCO_ANIMAL);
        this.setCreativeTab(AnimalMagic.abaAnimalMagic);
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
        TileEntityBlocoAnimal tile = (TileEntityBlocoAnimal)world.getTileEntity(x, y, z);
        if(tile == null && world.isRemote)
            super.breakBlock(world, x, y, z, block, meta);
        for (int i = 0; i < tile.inventario.length; i++) {
            if (tile.inventario[i] != null)
                world.spawnEntityInWorld(new EntityItem(world, x, y, z, tile.inventario[i].copy()));
        }
        super.breakBlock(world, x, y, z, block, meta);
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f1, float f2, float f3) {
        if (!world.isRemote && !player.isSneaking())
        {
            FMLNetworkHandler.openGui(player, AnimalMagic.instancia, GuiHandler.GUIsIDs.BLOCO_ANIMAL.ordinal(), world, x, y, z);
            return true;
        }
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityBlocoAnimal();
    }
}
