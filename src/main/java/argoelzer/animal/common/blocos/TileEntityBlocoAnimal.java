package argoelzer.animal.common.blocos;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityBlocoAnimal extends TileEntity implements ISidedInventory {

    public ItemStack[] inventario = new ItemStack[11];

    @Override
    public void updateEntity() {
        super.updateEntity();
    }

    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);
        NBTTagList nbttaglist = tagCompound.getTagList("Items", 10);
        this.inventario = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i) {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            int j = nbttagcompound1.getByte("Slot") & 255;

            if (j >= 0 && j < this.inventario.length) {
                this.inventario[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.inventario.length; ++i) {
            if (this.inventario[i] != null) {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte) i);
                this.inventario[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        tagCompound.setTag("Items", nbttaglist);
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int i) {
        return new int[] {0,1,2,3,4,5,6,7,8,9};
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack stack, int lado) {
        if (slot < 10)
            return true;
        return false;
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack stack, int lado) {
        if (slot < 10)
            return true;
        return false;
    }

    @Override
    public int getSizeInventory() {
        return 11;
    }

    @Override
    public ItemStack getStackInSlot(int i) {
        return inventario[i];
    }

    @Override
    public ItemStack decrStackSize(int i, int j) {
        if (this.inventario[i] != null) {
            ItemStack itemstack;
            if (this.inventario[i].stackSize <= j) {
                itemstack = this.inventario[i];
                this.inventario[i] = null;
                return itemstack;
            } else {
                itemstack = this.inventario[i].splitStack(j);

                if (this.inventario[i].stackSize == 0) {
                    this.inventario[i] = null;
                }
                return itemstack;
            }
        } else {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int i) {
        if (this.inventario[i] != null) {
            ItemStack itemstack = this.inventario[i];
            this.inventario[i] = null;
            return itemstack;
        } else {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack stack) {
        this.inventario[i] = stack;

        if (stack != null && stack.stackSize > this.getInventoryStackLimit()) {
            stack.stackSize = this.getInventoryStackLimit();
        }

        this.markDirty();
    }

    @Override
    public String getInventoryName() {
        return "container.bloco.animal";
    }

    @Override
    public boolean hasCustomInventoryName() {
        return true;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
        return true;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack stack) {
        if (i > 9)
            return false;
        return true;
    }

}
