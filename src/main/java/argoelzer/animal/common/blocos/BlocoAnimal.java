package argoelzer.animal.common.blocos;

import argoelzer.animal.common.lib.Nomes;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlocoAnimal extends BlockContainer {

    public BlocoAnimal()
    {
        super(Material.iron);
        this.setHardness(1f);
        this.setBlockName(Nomes.BLOCO_ANIMAL);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityBlocoAnimal();
    }
}
