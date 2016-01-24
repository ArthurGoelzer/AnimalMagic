package argoelzer.animal.client.render;

import argoelzer.animal.client.Texturas;
import argoelzer.animal.client.modelos.ModeloBlocoAnimal;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

/**
 * Created by Arthur on 23/01/2016.
 */
public class ItemBlocoAnimalRenderer implements IItemRenderer {
    ModeloBlocoAnimal modelo;
    public ItemBlocoAnimalRenderer() {
        modelo = new ModeloBlocoAnimal();
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        GL11.glPushMatrix();
        GL11.glPushMatrix();
        Minecraft.getMinecraft().renderEngine.bindTexture(Texturas.MODELO_BLOCO_ANIMAL);

        if (type == ItemRenderType.EQUIPPED)
            GL11.glTranslatef(0.4f, 0, 0.4f);
        if (type == ItemRenderType.INVENTORY)
            GL11.glTranslatef(0, -1f, 0);
        if (type == ItemRenderType.EQUIPPED_FIRST_PERSON) {
            GL11.glTranslatef(0.5f, 0.1f, 0.5f);
            GL11.glScalef(0.8f, 0.9f, 0.8f);
        }
        if(type == ItemRenderType.ENTITY)
            GL11.glTranslatef(0, -0.9f, 0);
        modelo.render(null, 0, 0, 0, 0, 0, 0.0625f);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }
}
