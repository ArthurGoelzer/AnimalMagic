package argoelzer.animal.common.inventario;

import argoelzer.animal.common.AnimalMagic;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotAnimal extends Slot {
    public boolean entrada;
    public SlotAnimal(IInventory inventario, int id, int x, int y, boolean entrada) {
            super(inventario, id, x, y);
        this.entrada = entrada;
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        if (entrada && stack.getItem() != AnimalMagic.itemEspiritoAnimal)
            return false;
        return true;
    }
}
