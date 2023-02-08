package net.entityCatPig.testmod.client.model;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.boss.WitherEntity;

public class CPTMWitherModel<T extends WitherEntity> extends CPTMFlyingPlayerModel<T> {

    public CPTMWitherModel(ModelPart mdp) {
        this(mdp, true);
    }
    private final ModelPart[] heads;

    public ImmutableList<ModelPart> parts() {
        return (ImmutableList.of(this.heads[0],this.heads[1],this.heads[2]));
    }

    public CPTMWitherModel(ModelPart root, boolean p_i46304_2_) {
        super(root, p_i46304_2_);
        this.heads = new ModelPart[3];
        this.heads[0] = root.getChild("heads0");
        this.heads[1] = root.getChild("heads1");
        this.heads[2] = root.getChild("heads2");
    }
    public static TexturedModelData getTexturedModelData() {
        return getTexturedModelData(0.0F);
    }
    public static TexturedModelData getTexturedModelDataArmor() {
        return getTexturedModelData(0.8F);
    }
    public static TexturedModelData getTexturedModelData(float dilation) {
        ModelData modelData = CPTMFlyingPlayerModel.getModelData(new Dilation(dilation));
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild("heads0",
                ModelPartBuilder.create().uv(0, 76)
                        .cuboid(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F,new Dilation(dilation)),
                ModelTransform.pivot(0.0f,-12.0f,0.0f));
        modelPartData.addChild("heads1",
                ModelPartBuilder.create().uv(0, 76)
                        .cuboid(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F,new Dilation(dilation)),
                ModelTransform.pivot(-12.0f,-4.0f,0.0f));
        modelPartData.addChild("heads2",
                ModelPartBuilder.create().uv(0, 76)
                        .cuboid(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F,new Dilation(dilation)),
                ModelTransform.pivot(12.0f,-4.0f,0.0f));

        return TexturedModelData.of(modelData,64,128);
    }
    public static TexturedModelData getTexturedModelDataIA() {
        return TexturedModelData.of(BipedEntityModel.getModelData(new Dilation(0.5F),0.0F),64,32);
    }
    public static TexturedModelData getTexturedModelDataOA() {
        return TexturedModelData.of(BipedEntityModel.getModelData(new Dilation(1.0F),0.0F),64,32);
    }

    public void animateModel(T p_212843_1_, float p_212843_2_, float p_212843_3_, float p_212843_4_) {
        super.animateModel(p_212843_1_,p_212843_2_,p_212843_3_,p_212843_4_);
        for(int i = 1; i < 3; ++i) {
            this.heads[i].yaw = (p_212843_1_.getHeadYaw(i - 1) - p_212843_1_.bodyYaw) * ((float)Math.PI / 180F);
            this.heads[i].pitch = p_212843_1_.getHeadPitch(i - 1) * ((float)Math.PI / 180F);
        }
    }

    public void setAngles(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
        super.setAngles(p_225597_1_, p_225597_2_, p_225597_3_, p_225597_4_, p_225597_5_, p_225597_6_);
        this.heads[0].copyTransform(this.head);
        this.heads[0].pivotX = 0.0F;
        this.heads[0].pivotY = -16.0F;
    }

    public void render(MatrixStack p_225598_1_, VertexConsumer p_225598_2_, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
        super.render(p_225598_1_,p_225598_2_,p_225598_3_,p_225598_4_,p_225598_5_,p_225598_6_,p_225598_7_,p_225598_8_);
        this.parts().forEach((p_228272_8_) -> {
            p_228272_8_.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        });
    }
}
