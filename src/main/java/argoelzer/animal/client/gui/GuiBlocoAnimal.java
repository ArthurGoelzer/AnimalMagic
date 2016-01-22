package argoelzer.animal.client.gui;

import argoelzer.animal.client.Texturas;
import argoelzer.animal.common.blocos.TileEntityBlocoAnimal;
import argoelzer.animal.common.inventario.ContainerBlocoAnimal;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.StatCollector;

public class GuiBlocoAnimal extends GuiContainer {
    TileEntityBlocoAnimal tileAnimal;
    EntityPlayer jogador;
    public GuiBlocoAnimal(TileEntityBlocoAnimal tileAnimal, EntityPlayer player) {
        super(new ContainerBlocoAnimal(tileAnimal, player));
        this.jogador = player;
        this.tileAnimal = tileAnimal;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY){
        String nome = StatCollector.translateToLocal("container.bloco.animal");
        fontRendererObj.drawString(nome, xSize / 2 - fontRendererObj.getStringWidth(nome) / 2, 6, 4210752);
        fontRendererObj.drawString(I18n.format("container.inventory"), 8, ySize - 96 + 4, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int mouseX, int mouseY) {
        mc.getTextureManager().bindTexture(Texturas.GUI_BLOCO_ANIMAL);
        this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }
}
