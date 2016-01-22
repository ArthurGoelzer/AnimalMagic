package argoelzer.animal.common;

import argoelzer.animal.common.blocos.BlocoAnimal;
import argoelzer.animal.common.blocos.TileEntityBlocoAnimal;
import argoelzer.animal.common.lib.Nomes;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

@Mod(name = Nomes.MOD_NOME, modid =  Nomes.MOD_ID, version = "0.1 teste")
public class AnimalMagic {
    public static Block blocoAnimal;

    @Mod.Instance(Nomes.MOD_ID)
    public static AnimalMagic instancia;

    @SidedProxy(serverSide = "argoelzer.animal.common.CommonProxy", clientSide = "argoelzer.animal.client.ClientProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent evento) {
        GameRegistry.registerBlock(blocoAnimal = new BlocoAnimal(), Nomes.BLOCO_ANIMAL);
        NetworkRegistry.INSTANCE.registerGuiHandler(instancia, new GuiHandler());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent evento) {
        GameRegistry.registerTileEntity(TileEntityBlocoAnimal.class, Nomes.TILE_ENTITY_ANIMAL);
    }

}
