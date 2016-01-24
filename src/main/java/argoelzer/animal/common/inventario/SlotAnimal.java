package argoelzer.animal.common.inventario;

import argoelzer.animal.client.Texturas;
import argoelzer.animal.common.AnimalMagic;
import argoelzer.animal.common.lib.Nomes;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class SlotAnimal extends Slot {
    public boolean entrada, modificador;
    public SlotAnimal(IInventory inventario, int id, int x, int y, boolean entrada, boolean modificador) {
            super(inventario, id, x, y);
        this.entrada = entrada;
        this.modificador = modificador;
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        if (modificador) {
            if (stack.getItem() == Items.dye)
                return true;
            return false;
        }
        if (entrada) {
            return (stack.getItem() == AnimalMagic.itemEspiritoAnimal && stack.getItemDamage() != 0 && stack.hasTagCompound() && stack.getTagCompound().hasKey(Nomes.KEY_NBT_USUARIO));
        } else {
            return !(stack.getItem() == AnimalMagic.itemEspiritoAnimal);
        }
    }
}
