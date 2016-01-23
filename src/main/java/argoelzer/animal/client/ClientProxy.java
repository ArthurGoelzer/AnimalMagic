package argoelzer.animal.client;

import argoelzer.animal.client.render.ItemBlocoAnimalRenderer;
import argoelzer.animal.client.render.TileEntityAnimalRenderer;
import argoelzer.animal.common.AnimalMagic;
import argoelzer.animal.common.CommonProxy;
import argoelzer.animal.common.blocos.TileEntityBlocoAnimal;
import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {
    @Override
    public void registrarRender() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBlocoAnimal.class, new TileEntityAnimalRenderer());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(AnimalMagic.blocoAnimal), new ItemBlocoAnimalRenderer());
    }
}
