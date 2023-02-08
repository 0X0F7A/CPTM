package net.entityCatPig.testmod.client.renderer.layers;

import net.entityCatPig.testmod.client.model.CPTMSnowGolemModel;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformation.Mode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3f;




public class CPTMSnowGolemHeldLayer extends FeatureRenderer<SnowGolemEntity, CPTMSnowGolemModel<SnowGolemEntity>> {
    private final ItemRenderer itemRenderer;
    public CPTMSnowGolemHeldLayer(FeatureRendererContext<SnowGolemEntity, CPTMSnowGolemModel<SnowGolemEntity>> p_i50922_1_, ItemRenderer itemRenderer) {
        super(p_i50922_1_);
        this.itemRenderer = itemRenderer;
    }

    public void render(MatrixStack p_225628_1_, VertexConsumerProvider p_225628_2_, int p_225628_3_, SnowGolemEntity p_225628_4_, float p_225628_5_, float p_225628_6_, float p_225628_7_, float p_225628_8_, float p_225628_9_, float p_225628_10_) {
        if (!p_225628_4_.isInvisible() && p_225628_4_.hasPumpkin()) {

            p_225628_1_.push();
            this.getContextModel().getHand().rotate(p_225628_1_);
            p_225628_1_.translate(0.0D, 0.5D, -0.3D);//左右，上下，前后
            p_225628_1_.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(20.0F));
            p_225628_1_.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(45.0F));
            //p_225628_1_.translate(0.0D, 0.0D, 0.0D);
            p_225628_1_.scale(-0.3F, -0.3F, 0.3F);
            float f = 0.625F;
            ItemStack itemstack = new ItemStack(Blocks.CARVED_PUMPKIN);
            this.itemRenderer.renderItem(p_225628_4_, itemstack, Mode.HEAD, false, p_225628_1_, p_225628_2_, p_225628_4_.world, p_225628_3_, LivingEntityRenderer.getOverlay(p_225628_4_, 0.0F),p_225628_4_.getId());
            p_225628_1_.pop();
        }
    }
}
