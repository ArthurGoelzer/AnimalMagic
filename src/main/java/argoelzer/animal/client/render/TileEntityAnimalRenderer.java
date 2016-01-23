package argoelzer.animal.client.render;

import argoelzer.animal.client.Texturas;
import argoelzer.animal.client.modelos.ModeloBlocoAnimal;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;

public class TileEntityAnimalRenderer extends TileEntitySpecialRenderer {
    ModeloBlocoAnimal modeloPrincipal;

    public TileEntityAnimalRenderer() {
        modeloPrincipal = new ModeloBlocoAnimal();
    }

    @Override
    public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f1) {
        GL11.glPushMatrix();
        GL11.glTranslated(x+0.5f, y-0.5f, z+0.5f);
        GL11.glPushMatrix();
        Minecraft.getMinecraft().renderEngine.bindTexture(Texturas.MODELO_BLOCO_ANIMAL);
        modeloPrincipal.render(null, 0, 0, 0, 0, 0, 0.0625f);
        GL11.glPopMatrix();
        GL11.glPopMatrix();

    }
}
