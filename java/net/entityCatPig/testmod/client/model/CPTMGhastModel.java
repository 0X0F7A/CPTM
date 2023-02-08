package net.entityCatPig.testmod.client.model;

import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.GhastEntity;

public class CPTMGhastModel<T extends GhastEntity> extends CPTMFlyingPlayerModel<T> {

    public CPTMGhastModel(ModelPart mdp) {
        this(mdp, true);
    }
    public CPTMGhastModel(ModelPart p_i46304_1_, boolean p_i46304_2_) {
        super(p_i46304_1_, p_i46304_2_);
    }
    public static TexturedModelData getTexturedModelData() {
        return TexturedModelData.of(CPTMFlyingPlayerModel.getModelData(new Dilation(0.0F)),64,128);
    }
    public static TexturedModelData getTexturedModelDataIA() {
        return TexturedModelData.of(BipedEntityModel.getModelData(new Dilation(0.5F),0.0F),64,32);
    }
    public static TexturedModelData getTexturedModelDataOA() {
        return TexturedModelData.of(BipedEntityModel.getModelData(new Dilation(1.0F),0.0F),64,32);
    }

    public void setAngles(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
        super.setAngles(p_225597_1_, p_225597_2_, p_225597_3_, p_225597_4_, p_225597_5_, p_225597_6_);
        this.rightLeg.pitch = 0.0F;
        this.leftLeg.pitch = 0.0F;
        this.rightArm.pitch = 0.0F;
        this.leftArm.pitch = 0.0F;
        this.rightLeg.yaw = 0.0F;
        this.leftLeg.yaw = 0.0F;
        this.rightLeg.roll = 0.0F;
        this.leftLeg.roll = 0.0F;
    }


    public void render(MatrixStack p_225598_1_, VertexConsumer p_225598_2_, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
        p_225598_1_.scale(2.0F,2.0F,2.0F);
        super.render(p_225598_1_,p_225598_2_,p_225598_3_,p_225598_4_,p_225598_5_,p_225598_6_,p_225598_7_,p_225598_8_);
    }
}
