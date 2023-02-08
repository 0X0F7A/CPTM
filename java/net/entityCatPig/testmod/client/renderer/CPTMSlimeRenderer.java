package net.entityCatPig.testmod.client.renderer;

import net.entityCatPig.testmod.TestMod;
import net.entityCatPig.testmod.client.model.CPTMSlimeModel;
import net.entityCatPig.testmod.init.ModEntityTypes;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;




public class CPTMSlimeRenderer extends BipedEntityRenderer<SlimeEntity, CPTMSlimeModel<SlimeEntity>> {
    private static final Identifier ZOMBIE_LOCATION = new Identifier(TestMod.MOD_ID,"textures/entity/cptmslime.png");

    public CPTMSlimeRenderer(EntityRendererFactory.Context p_i46143_1_) {
        super(p_i46143_1_, new CPTMSlimeModel<>(p_i46143_1_.getPart(ModEntityTypes.MODEL_SLIME_LAYER)), 0.4F);
        this.addFeature(new ArmorFeatureRenderer<>(this, new BipedEntityModel(p_i46143_1_.getPart(ModEntityTypes.MODEL_SLIME_LAYER_IA)), new BipedEntityModel(p_i46143_1_.getPart(ModEntityTypes.MODEL_SLIME_LAYER_OA))));
        //this.addFeature(new CPTMSnowGolemHeldLayer(this));
    }

    protected void scale(SlimeEntity p_225620_1_, MatrixStack p_225620_2_, float p_225620_3_) {
        float f = 0.999F;
        p_225620_2_.scale(0.999F, 0.999F, 0.999F);
        p_225620_2_.translate(0.0D, (double)0.001F, 0.0D);
        float f1 = (float)p_225620_1_.getSize();
        float f4 = 1.0F;
        if(f1<=1.0F){
            this.model.sizeIntIns = 0;
        }
        else if(f1<=2.0F){
            this.model.sizeIntIns = 1;
        }
        else {
            this.model.sizeIntIns = 2;
        }
        float f2 = MathHelper.lerp(p_225620_3_, p_225620_1_.lastStretch, p_225620_1_.stretch) / (f1 * 0.5F + 1.0F);
        float f3 = 1.0F / (f2 + 1.0F);
        p_225620_2_.scale(f3 * f4, 1.0F / f3 * f4, f3 * f4);
    }

    public Identifier getTexture(SlimeEntity p_110775_1_) {
        return ZOMBIE_LOCATION;
    }
}

