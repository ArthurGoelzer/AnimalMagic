package argoelzer.animal.common;

import argoelzer.animal.common.lib.Nomes;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;

import java.util.List;

public class ItemEspiritoAnimal extends Item {
    public IIcon[] icones = new IIcon[3];

    public ItemEspiritoAnimal() {
        this.setUnlocalizedName(Nomes.ITEM_ESPIRITO_ANIMAL);
        this.setHasSubtypes(true);
        this.setCreativeTab(AnimalMagic.abaAnimalMagic);
        this.setMaxStackSize(1);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer jogador, List lista, boolean b) {
        if (stack.getItemDamage() != 0) {
            if (stack.hasTagCompound()) {
                lista.add(StatCollector.translateToLocal("nome.jogador") + ": " + stack.getTagCompound().getString(Nomes.KEY_NBT_USUARIO));
                lista.add(StatCollector.translateToLocal("nome.quantidade") + ": " + stack.getTagCompound().getInteger(Nomes.KEY_NBT_QUANTIDADE));
            } else {
                lista.add(StatCollector.translateToLocal("nome.jogador.indefinido"));
                lista.add(StatCollector.translateToLocal("nome.quantidade") + ": " + 0);
            }
        } else {
            lista.add(StatCollector.translateToLocal("msg.instru.items"));
        }
        super.addInformation(stack, jogador, lista, b);
    }

    @Override
    public void registerIcons(IIconRegister iconRegister) {
        this.icones[0] = iconRegister.registerIcon(Nomes.MOD_ASSETS + ":EspiritoAnimalVazio");
        this.icones[1] = iconRegister.registerIcon(Nomes.MOD_ASSETS + ":EspiritoAnimalOvelha");
        this.icones[2] = iconRegister.registerIcon(Nomes.MOD_ASSETS + ":EspiritoAnimalGalinha");
    }

    @Override
    public IIcon getIconFromDamage(int meta) {
        return icones[meta];
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        String nome = super.getUnlocalizedName(stack);
        switch (stack.getItemDamage()) {
            case 0:
                nome = nome + "Vazio";
                break;
            case 1:
                nome = nome + "Ovelha";
                break;
            case 2:
                nome = nome + "Galinha";
                break;
        }
        return nome;
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List lista) {
        for (int i = 0; i < 3; i++) {
            lista.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        return EnumChatFormatting.GREEN + super.getItemStackDisplayName(stack);
    }
}
