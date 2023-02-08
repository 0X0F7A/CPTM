package net.entityCatPig.testmod.client.renderer;

import net.entityCatPig.testmod.TestMod;
import net.entityCatPig.testmod.client.model.CPTMPhantomModel;
import net.entityCatPig.testmod.init.ModEntityTypes;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.PhantomEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3f;




public class CPTMPhantomRenderer extends BipedEntityRenderer<PhantomEntity, CPTMPhantomModel<PhantomEntity>> {
    private static final Identifier ENDERMITE_LOCATION = new Identifier(TestMod.MOD_ID,"textures/entity/cptmphantom.png");

    public CPTMPhantomRenderer(EntityRendererFactory.Context p_i46143_1_) {
        super(p_i46143_1_, new CPTMPhantomModel<>(p_i46143_1_.getPart(ModEntityTypes.MODEL_PHANTOM_LAYER)), 0.5F);
    }

    public Identifier getTexture(PhantomEntity p_110775_1_) {
        return ENDERMITE_LOCATION;
    }

    protected void scale(PhantomEntity p_225620_1_, MatrixStack p_225620_2_, float p_225620_3_) {
        int i = p_225620_1_.getPhantomSize();
        float f = 1.0F + 0.15F * (float)i;
        p_225620_2_.scale(f, f, f);
        p_225620_2_.translate(0.0D, 1.3125D*0.5D, 0.1875D);
    }

    protected void setupTransforms(PhantomEntity p_225621_1_, MatrixStack p_225621_2_, float p_225621_3_, float p_225621_4_, float p_225621_5_) {
        super.setupTransforms(p_225621_1_, p_225621_2_, p_225621_3_, p_225621_4_, p_225621_5_);
        p_225621_2_.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(p_225621_1_.getPitch()-90.0F));
    }
}