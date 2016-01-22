package argoelzer.animal.common.blocos;

import argoelzer.animal.common.AnimalMagic;
import argoelzer.animal.common.GuiHandler;
import argoelzer.animal.common.lib.Nomes;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlocoAnimal extends BlockContainer {

    public BlocoAnimal() {
        super(Material.iron);
        this.setHardness(1f);
        this.setBlockName(Nomes.BLOCO_ANIMAL);
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
