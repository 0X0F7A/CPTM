package net.entityCatPig.testmod.client.renderer.layers;

import net.entityCatPig.testmod.client.model.CPTMEndermanModel;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.util.math.Vec3f;

public class CPTMHeldBlockLayer extends FeatureRenderer<EndermanEntity, CPTMEndermanModel<EndermanEntity>> {
    public CPTMHeldBlockLayer(FeatureRendererContext<EndermanEntity, CPTMEndermanModel<EndermanEntity>> p_i50949_1_) {
        super(p_i50949_1_);
    }

    public void render(MatrixStack p_225628_1_, VertexConsumerProvider p_225628_2_, int p_225628_3_, EndermanEntity p_225628_4_, float p_225628_5_, float p_225628_6_, float p_225628_7_, float p_225628_8_, float p_225628_9_, float p_225628_10_) {
        BlockState blockstate = p_225628_4_.getCarriedBlock();
        if (blockstate != null) {
            p_225628_1_.push();
            p_225628_1_.translate(0.0D, 0.6875D-0.1D, -0.5D);//左右，上下，前后
            p_225628_1_.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(20.0F));
            p_225628_1_.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(45.0F));
            p_225628_1_.translate(0.25D, 0.1875D, 0.25D);
            float f = 0.5F;
            p_225628_1_.scale(-0.5F, -0.5F, 0.5F);
            p_225628_1_.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(90.0F));
            MinecraftClient.getInstance().getBlockRenderManager().renderBlockAsEntity(blockstate, p_225628_1_, p_225628_2_, p_225628_3_, OverlayTexture.DEFAULT_UV);
            p_225628_1_.pop();
        }
    }
}
