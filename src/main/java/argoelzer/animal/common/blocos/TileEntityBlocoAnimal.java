package argoelzer.animal.common.blocos;

import argoelzer.animal.common.lib.Cores;
import argoelzer.animal.common.lib.Nomes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TileEntityBlocoAnimal extends TileEntity implements ISidedInventory {

    public ItemStack[] inventario = new ItemStack[12];
    public int tipoAnimal = 0;
    public int ticksProdu, ticksScanOvo, ticksScanAnimal;
    public boolean jogadorOnline;
    @Override
    public void updateEntity() {
        super.updateEntity();
        int rng = 5;
        if (!worldObj.isRemote) {


            ticksScanOvo++;
            if (ticksScanOvo > 500) {
                List listaDeOvos = this.worldObj.getEntitiesWithinAABB(EntityItem.class, AxisAlignedBB.getBoundingBox(this.xCoord - rng, this.yCoord - rng,
                        this.zCoord - rng, this.xCoord + rng, this.yCoord + rng, this.zCoord + rng));
                Iterator iterator = listaDeOvos.iterator();
                while (iterator.hasNext()) {
                    EntityItem item = (EntityItem)iterator.next();
                    if (item.getEntityItem().getItem() == Items.egg) {
                        for (int i = 0; i < item.getEntityItem().stackSize; i++) {
                            adicionarItem(Items.egg, 0, 1);
                        }
                        item.setDead();
                    }
                }
                ticksScanOvo = 0;
            }
        }
        if (inventario[10] != null && !worldObj.isRemote) {
            tipoAnimal = inventario[10].getItemDamage();

            if (!inventario[10].hasTagCompound())
                inventario[10].setTagCompound(new NBTTagCompound());
            NBTTagCompound tagCompound = inventario[10].getTagCompound();

            String[] jogadores = MinecraftServer.getServer().getAllUsernames();
            for (int i = 0; i < jogadores.length; i++) {
                jogadorOnline = jogadores[i].equalsIgnoreCase(tagCompound.getString(Nomes.KEY_NBT_USUARIO));
            }
            if (jogadorOnline)
                produzir(tagCompound.getInteger(Nomes.KEY_NBT_QUANTIDADE), tipoAnimal);


            if (tipoAnimal != 0 && jogadorOnline) {
                ticksScanAnimal++;
                if (ticksScanAnimal >= 200) {
                    ticksScanAnimal = 0;
                    Class classeAnimal = EntityAnimal.class;
                    switch (tipoAnimal) {
                        case 1:
                            classeAnimal = EntitySheep.class;
                            break;
                        case 2:
                            classeAnimal = EntityChicken.class;
                            break;
                    }
                    //System.out.println("Lista de animais:");
                    List listaDeMobs = this.worldObj.getEntitiesWithinAABB(classeAnimal, AxisAlignedBB.getBoundingBox(this.xCoord - rng, this.yCoord - rng,
                            this.zCoord - rng, this.xCoord + rng, this.yCoord + rng, this.zCoord + rng));
                    Iterator iterator = listaDeMobs.iterator();
                    int quantidadeViva = 0;
                    while (iterator.hasNext()) {
                        Entity entidade = (Entity) iterator.next();
                        //System.out.println(" \n Nome: " + entidade.getCommandSenderName() + "Coords: x:" + entidade.posX + " y:" + entidade.posY + " z:" + entidade.posZ);
                        quantidadeViva++;
                        if (quantidadeViva > 10 && !worldObj.isRemote)
                            absorverEntidade(entidade);
                    }
                }
            } else {
                ticksScanAnimal = 0;
            }
        }
    }

    private void absorverEntidade(Entity entidade) {
        if (inventario[10] != null) {
            if (!inventario[10].hasTagCompound())
                inventario[10].setTagCompound(new NBTTagCompound());
            NBTTagCompound tagCompound = inventario[10].getTagCompound();
            int quantidadeAtual = tagCompound.getInteger(Nomes.KEY_NBT_QUANTIDADE);
            if (quantidadeAtual < 100) {
                tagCompound.setInteger(Nomes.KEY_NBT_QUANTIDADE, quantidadeAtual + 1);
            } else {
                //Marcar tileentity como lotada para renderer
            }
            entidade.setDead();
        }
    }

    private void produzir(int quantidade, int tipo) {
        ticksProdu++;
        if (ticksProdu >= 800) {
            ticksProdu = 0;
            Random random = new Random();
            switch (tipo) {
                case 1:
                    for (int i = quantidade; i > 0; i--) {
                        if (random.nextInt(100) < 29) {
                            if (random.nextInt() < 70) {
                                adicionarItem(Item.getItemFromBlock(Blocks.wool), Cores.CORANTE_AT_LA[inventario[11] != null ? inventario[11].getItemDamage() : 15], quantidade);

                            } else {
                                adicionarItem(Item.getItemFromBlock(Blocks.wool), 0, quantidade);
                            }
                        }
                        //Cores.CORANTE_AT_LA[inventario[11] != null ? inventario[11].getItemDamage() : 0]
                        //System.out.println("Teste: aaaa :" + Cores.CORANTE_AT_LA[inventario[11] != null ? inventario[11].getItemDamage() : 0]);
                    }
                    break;
                case 2:
                    for (int i = quantidade; i > 0; i--) {
                        if (random.nextInt(100) < 15)
                            adicionarItem(Items.egg, 0, quantidade);
                    }
                    break;
            }
        }
    }

    private void adicionarItem(Item item, int meta, int quantidadeInicial) {
        int contNull = 0;
        for (int i = 0; i <= 9; i++) {
            if (inventario[i] != null) {
                if (inventario[i].getItem() == item && inventario[i].getItemDamage() == meta && inventario[i].stackSize < inventario[i].getMaxStackSize()) {
                    inventario[i].stackSize++;
                    break;
                } else {
                    contNull++;
                }
            } else {
                contNull++;
            }
        }
        if (contNull >= 9) {
            for (int i = 0; i <= 9; i++) {
                if (inventario[i] == null) {
                    this.setInventorySlotContents(i, new ItemStack(item, 1, meta));
                    break;
                }
            }
        }
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
        return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack stack, int lado) {
        return slot < 10;
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack stack, int lado) {
        return slot < 10;
    }

    @Override
    public int getSizeInventory() {
        return 12;
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
        return i <= 9;
    }

}
