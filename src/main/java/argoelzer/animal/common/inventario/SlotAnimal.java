package argoelzer.animal.common.inventario;

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
    public boolean isItemValid(ItemStack p_75214_1_) {
        return true;
    }
}
