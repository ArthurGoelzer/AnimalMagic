package argoelzer.animal.common.inventario;

import argoelzer.animal.common.blocos.TileEntityBlocoAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerBlocoAnimal extends Container {
    TileEntityBlocoAnimal tileAnimal;
    EntityPlayer jogador;
    public ContainerBlocoAnimal(TileEntityBlocoAnimal tileAnimal, EntityPlayer player) {
        super();
        this.jogador = player;
        this.tileAnimal = tileAnimal;

        for (int i = 0; i < 10; i++) {
            adicionarSaidas(i, i >= 5 ? 1 : 0);
        }
        this.addSlotToContainer(new SlotAnimal(tileAnimal, 10, 80, 16, true));

        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                addSlotToContainer(new Slot(jogador.inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for(int i = 0; i < 9; ++i) {
            addSlotToContainer(new Slot(jogador.inventory, i, 8 + i * 18, 84 + 58));
        }



    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int index) {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index < 11) {
                if (!this.mergeItemStack(itemstack1, 11, 46, true))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 0, 10, false)) {
                return null;
            }
            if (itemstack1.stackSize == 0) {
                slot.putStack((ItemStack)null);
            }
            else {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize) {
                return null;
            }

            slot.onPickupFromSlot(player, itemstack1);
        }
        return itemstack;
    }

    private void adicionarSaidas(int id, int ln) {
        if (ln == 0) {
            this.addSlotToContainer(new SlotAnimal(tileAnimal, id, 44 + (id * 18), 37, false));
        } else {
            this.addSlotToContainer(new SlotAnimal(tileAnimal, id, 44 + ((id - 5) * 18), 37 + 18, false));
        }
        ////System.out.println("\n id: " + id +"\n ln: " + ln); DEBUG
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return tileAnimal.isUseableByPlayer(player);
    }
}
