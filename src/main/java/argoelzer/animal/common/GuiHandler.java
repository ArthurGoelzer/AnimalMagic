package argoelzer.animal.common;

import argoelzer.animal.client.gui.GuiBlocoAnimal;
import argoelzer.animal.common.blocos.TileEntityBlocoAnimal;
import argoelzer.animal.common.inventario.ContainerBlocoAnimal;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {

    public enum GUIsIDs {
        BLOCO_ANIMAL;
    }

    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntityAlvo = world.getTileEntity(x, y, z);
        switch(GUIsIDs.values()[ID])
        {
            case BLOCO_ANIMAL:
                if (tileEntityAlvo != null && tileEntityAlvo instanceof TileEntityBlocoAnimal)
                    return new ContainerBlocoAnimal((TileEntityBlocoAnimal)tileEntityAlvo, player);
        }
        return null;
    }

    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntityAlvo = world.getTileEntity(x, y, z);
        switch(GUIsIDs.values()[ID])
        {
            case BLOCO_ANIMAL:
                if (tileEntityAlvo != null && tileEntityAlvo instanceof TileEntityBlocoAnimal)
                    return new GuiBlocoAnimal((TileEntityBlocoAnimal)tileEntityAlvo, player);
        }
        return null;
    }
}
