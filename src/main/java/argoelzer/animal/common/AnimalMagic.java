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
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@Mod(name = Nomes.MOD_NOME, modid =  Nomes.MOD_ID, version = "0.2")
public class AnimalMagic {
    public static Block blocoAnimal;
    public static Item itemEspiritoAnimal;

    @Mod.Instance(Nomes.MOD_ID)
    public static AnimalMagic instancia;

    @SidedProxy(serverSide = "argoelzer.animal.common.CommonProxy", clientSide = "argoelzer.animal.client.ClientProxy")
    public static CommonProxy proxy;

    public static CreativeTabs abaAnimalMagic;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent evento) {
        abaAnimalMagic = new CreativeTabs(CreativeTabs.getNextID(), Nomes.ABA_ANIMAL_MAGIC) {
            @Override
            public Item getTabIconItem() {
                return Item.getItemFromBlock(blocoAnimal);
            }
        };
        GameRegistry.registerBlock(blocoAnimal = new BlocoAnimal(), Nomes.BLOCO_ANIMAL);
        GameRegistry.registerItem(itemEspiritoAnimal = new ItemEspiritoAnimal(), Nomes.ITEM_ESPIRITO_ANIMAL);
        NetworkRegistry.INSTANCE.registerGuiHandler(instancia, new GuiHandler());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent evento) {
        GameRegistry.registerTileEntity(TileEntityBlocoAnimal.class, Nomes.TILE_ENTITY_ANIMAL);
        GameRegistry.addShapelessRecipe(new ItemStack(itemEspiritoAnimal, 1, 0), Items.emerald, Blocks.soul_sand, Items.blaze_powder);
        GameRegistry.addShapedRecipe(new ItemStack(itemEspiritoAnimal, 1, 1), "XXX", "XAX", "XXX", 'X', Blocks.wool, 'A', new ItemStack(itemEspiritoAnimal, 1, 0));
        GameRegistry.addShapedRecipe(new ItemStack(itemEspiritoAnimal, 1, 2), "XXX", "XAX", "XXX", 'X', Items.feather, 'A', new ItemStack(itemEspiritoAnimal, 1, 0));
        GameRegistry.addShapedRecipe(new ItemStack(blocoAnimal, 1, 0), "FMF", "APA", "FMF", 'F', Items.iron_ingot, 'M', Blocks.log, 'P',
                new ItemStack(itemEspiritoAnimal, 1, 0), 'A', Blocks.soul_sand);
        GameRegistry.addShapedRecipe(new ItemStack(blocoAnimal, 1, 0), "FMF", "APA", "FMF", 'F', Items.iron_ingot, 'M', Blocks.log2, 'P',
                new ItemStack(itemEspiritoAnimal, 1, 0), 'A', Blocks.soul_sand);
        proxy.registrarRender();
    }

}
