package net.entityCatPig.testmod.client.renderer;

import net.entityCatPig.testmod.TestMod;
import net.entityCatPig.testmod.client.model.CPTMIllusionerModel;
import net.entityCatPig.testmod.init.ModEntityTypes;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.IllusionerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;




public class CPTMIllusionerRenderer extends BipedEntityRenderer<IllusionerEntity, CPTMIllusionerModel<IllusionerEntity>> {
    private static final Identifier ZOMBIE_LOCATION = new Identifier(TestMod.MOD_ID,"textures/entity/cptmillusioner.png");
    public CPTMIllusionerRenderer(EntityRendererFactory.Context p_i46143_1_) {
        super(p_i46143_1_, new CPTMIllusionerModel<>(p_i46143_1_.getPart(ModEntityTypes.MODEL_ILLUSIONER_LAYER)), 0.5F);
        this.addFeature(new ArmorFeatureRenderer<>(this, new BipedEntityModel(p_i46143_1_.getPart(ModEntityTypes.MODEL_ILLUSIONER_LAYER_IA)), new BipedEntityModel(p_i46143_1_.getPart(ModEntityTypes.MODEL_ILLUSIONER_LAYER_OA))));
    }

    public Identifier getTexture(IllusionerEntity p_110775_1_) {
        return ZOMBIE_LOCATION;
    }

    public void render(IllusionerEntity p_225623_1_, float p_225623_2_, float p_225623_3_, MatrixStack p_225623_4_, VertexConsumerProvider p_225623_5_, int p_225623_6_) {
        if (p_225623_1_.isInvisible()) {
            Vec3d[] avector3d = p_225623_1_.method_7065(p_225623_3_); //method_7065 = getIllusionOffset
            float f = this.getAnimationProgress(p_225623_1_, p_225623_3_);

            for(int i = 0; i < avector3d.length; ++i) {
                p_225623_4_.push();
                p_225623_4_.translate(avector3d[i].x + (double) MathHelper.cos((float)i + f * 0.5F) * 0.025D, avector3d[i].y + (double)MathHelper.cos((float)i + f * 0.75F) * 0.0125D, avector3d[i].z + (double)MathHelper.cos((float)i + f * 0.7F) * 0.025D);
                super.render(p_225623_1_, p_225623_2_, p_225623_3_, p_225623_4_, p_225623_5_, p_225623_6_);
                p_225623_4_.pop();
            }
        } else {
            super.render(p_225623_1_, p_225623_2_, p_225623_3_, p_225623_4_, p_225623_5_, p_225623_6_);
        }

    }

    protected boolean isVisible(IllusionerEntity p_225622_1_) {
        return true;
    }
}