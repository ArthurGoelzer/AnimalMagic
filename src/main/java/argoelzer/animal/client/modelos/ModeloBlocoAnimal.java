package argoelzer.animal.client.modelos;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

/**
 * BlocoAnimal - Arthur Goelzer
 * Created using Tabula 5.1.0
 */
public class ModeloBlocoAnimal extends ModelBase {
    public ModelRenderer chao;
    public ModelRenderer teto;
    public ModelRenderer pilar1;
    public ModelRenderer pilar2;
    public ModelRenderer pilar3;
    public ModelRenderer pilar4;
    public ModelRenderer vidro1;
    public ModelRenderer vidro2;
    public ModelRenderer vidro3;
    public ModelRenderer vidro4;
    public ModelRenderer engateB1;
    public ModelRenderer engateT1;
    public ModelRenderer engateT2;
    public ModelRenderer engateB2;
    public ModelRenderer engateB3;
    public ModelRenderer engateT3;
    public ModelRenderer engateT4;
    public ModelRenderer engateB4;
    public ModelRenderer con1;
    public ModelRenderer con2;
    public ModelRenderer con3;
    public ModelRenderer con4;

    public ModeloBlocoAnimal() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.con4 = new ModelRenderer(this, 45, 1);
        this.con4.setRotationPoint(0.0F, 12.0F, 7.0F);
        this.con4.addBox(-4.0F, 0.0F, 0.0F, 8, 8, 1, 0.0F);
        this.engateB3 = new ModelRenderer(this, 0, 48);
        this.engateB3.setRotationPoint(0.0F, 20.0F, 7.0F);
        this.engateB3.addBox(-2.0F, 0.0F, -15.0F, 4, 4, 1, 0.0F);
        this.pilar1 = new ModelRenderer(this, 59, 32);
        this.pilar1.setRotationPoint(6.0F, 9.0F, -7.0F);
        this.pilar1.addBox(0.0F, 0.0F, 0.0F, 1, 14, 1, 0.0F);
        this.vidro2 = new ModelRenderer(this, 1, 1);
        this.vidro2.setRotationPoint(-6.0F, 9.0F, 6.0F);
        this.vidro2.addBox(0.0F, 0.0F, 0.0F, 12, 14, 1, 0.0F);
        this.pilar4 = new ModelRenderer(this, 59, 32);
        this.pilar4.setRotationPoint(-7.0F, 9.0F, -7.0F);
        this.pilar4.addBox(0.0F, 0.0F, 0.0F, 1, 14, 1, 0.0F);
        this.chao = new ModelRenderer(this, 0, 48);
        this.chao.setRotationPoint(-7.0F, 23.0F, -7.0F);
        this.chao.addBox(0.0F, 0.0F, 0.0F, 14, 1, 14, 0.0F);
        this.teto = new ModelRenderer(this, 0, 32);
        this.teto.setRotationPoint(-7.0F, 8.0F, -7.0F);
        this.teto.addBox(0.0F, 0.0F, 0.0F, 14, 1, 14, 0.0F);
        this.engateB2 = new ModelRenderer(this, 0, 54);
        this.engateB2.setRotationPoint(-8.0F, 20.0F, 0.0F);
        this.engateB2.addBox(0.0F, 0.0F, -2.0F, 1, 4, 4, 0.0F);
        this.engateB4 = new ModelRenderer(this, 0, 48);
        this.engateB4.setRotationPoint(0.0F, 20.0F, 7.0F);
        this.engateB4.addBox(-2.0F, 0.0F, 0.0F, 4, 4, 1, 0.0F);
        this.vidro4 = new ModelRenderer(this, 17, 5);
        this.vidro4.setRotationPoint(6.0F, 9.0F, -6.0F);
        this.vidro4.addBox(0.0F, 0.0F, 0.0F, 1, 14, 12, 0.0F);
        this.engateT2 = new ModelRenderer(this, 0, 31);
        this.engateT2.setRotationPoint(7.0F, 8.0F, 0.0F);
        this.engateT2.addBox(0.0F, 0.0F, -2.0F, 1, 4, 4, 0.0F);
        this.engateT1 = new ModelRenderer(this, 0, 31);
        this.engateT1.setRotationPoint(-8.0F, 8.0F, 0.0F);
        this.engateT1.addBox(0.0F, 0.0F, -2.0F, 1, 4, 4, 0.0F);
        this.vidro1 = new ModelRenderer(this, 1, 1);
        this.vidro1.setRotationPoint(-6.0F, 9.0F, -7.0F);
        this.vidro1.addBox(0.0F, 0.0F, 0.0F, 12, 14, 1, 0.0F);
        this.engateT3 = new ModelRenderer(this, 0, 40);
        this.engateT3.setRotationPoint(0.0F, 8.0F, -8.0F);
        this.engateT3.addBox(-2.0F, 0.0F, 0.0F, 4, 4, 1, 0.0F);
        this.con1 = new ModelRenderer(this, 45, 11);
        this.con1.setRotationPoint(7.0F, 12.0F, 0.0F);
        this.con1.addBox(0.0F, 0.0F, -4.0F, 1, 8, 8, 0.0F);
        this.con2 = new ModelRenderer(this, 45, 11);
        this.con2.setRotationPoint(-8.0F, 12.0F, 0.0F);
        this.con2.addBox(0.0F, 0.0F, -4.0F, 1, 8, 8, 0.0F);
        this.pilar2 = new ModelRenderer(this, 59, 32);
        this.pilar2.setRotationPoint(6.0F, 9.0F, 6.0F);
        this.pilar2.addBox(0.0F, 0.0F, 0.0F, 1, 14, 1, 0.0F);
        this.con3 = new ModelRenderer(this, 45, 1);
        this.con3.setRotationPoint(0.0F, 12.0F, -8.0F);
        this.con3.addBox(-4.0F, 0.0F, 0.0F, 8, 8, 1, 0.0F);
        this.pilar3 = new ModelRenderer(this, 59, 32);
        this.pilar3.setRotationPoint(-7.0F, 9.0F, 6.0F);
        this.pilar3.addBox(0.0F, 0.0F, 0.0F, 1, 14, 1, 0.0F);
        this.engateB1 = new ModelRenderer(this, 0, 54);
        this.engateB1.setRotationPoint(7.0F, 20.0F, 0.0F);
        this.engateB1.addBox(0.0F, 0.0F, -2.0F, 1, 4, 4, 0.0F);
        this.engateT4 = new ModelRenderer(this, 0, 40);
        this.engateT4.setRotationPoint(0.0F, 8.0F, 7.0F);
        this.engateT4.addBox(-2.0F, 0.0F, 0.0F, 4, 4, 1, 0.0F);
        this.vidro3 = new ModelRenderer(this, 17, 5);
        this.vidro3.setRotationPoint(-7.0F, 9.0F, -6.0F);
        this.vidro3.addBox(0.0F, 0.0F, 0.0F, 1, 14, 12, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.con4.render(f5);
        this.engateB3.render(f5);
        this.pilar1.render(f5);

        this.pilar4.render(f5);
        this.chao.render(f5);
        this.teto.render(f5);
        this.engateB2.render(f5);
        this.engateB4.render(f5);

        this.engateT2.render(f5);
        this.engateT1.render(f5);

        this.engateT3.render(f5);
        this.con1.render(f5);
        this.con2.render(f5);
        this.pilar2.render(f5);
        this.con3.render(f5);
        this.pilar3.render(f5);

        this.engateB1.render(f5);
        this.engateT4.render(f5);


        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        this.vidro3.render(f5);
        this.vidro4.render(f5);
        this.vidro2.render(f5);
        this.vidro1.render(f5);
        GL11.glDisable(GL11.GL_BLEND);

    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
