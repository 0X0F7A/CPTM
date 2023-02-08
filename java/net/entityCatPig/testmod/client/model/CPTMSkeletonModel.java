package net.entityCatPig.testmod.client.model;

import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.CrossbowPosing;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;

public class CPTMSkeletonModel<T extends MobEntity & RangedAttackMob> extends PlayerEntityModel<T> {
    public CPTMSkeletonModel(ModelPart mdp) {
        this(mdp, true);
    }
    public CPTMSkeletonModel(ModelPart p_i46303_1_, boolean p_i46303_2_) {
        super(p_i46303_1_,p_i46303_2_);
    }
    public static TexturedModelData getTexturedModelData() {
        return TexturedModelData.of(PlayerEntityModel.getTexturedModelData(new Dilation(0.0F),true),64,64);
    }
    public static TexturedModelData getTexturedModelDataIA() {
        return TexturedModelData.of(BipedEntityModel.getModelData(new Dilation(0.5F),0.0F),64,32);
    }
    public static TexturedModelData getTexturedModelDataOA() {
        return TexturedModelData.of(BipedEntityModel.getModelData(new Dilation(1.0F),0.0F),64,32);
    }

    public void animateModel(T p_212843_1_, float p_212843_2_, float p_212843_3_, float p_212843_4_) {
        this.rightArmPose = BipedEntityModel.ArmPose.EMPTY;
        this.leftArmPose = BipedEntityModel.ArmPose.EMPTY;
        ItemStack itemstack = p_212843_1_.getStackInHand(Hand.MAIN_HAND);
        if (itemstack.getItem() == Items.BOW && p_212843_1_.isAttacking()) {
            if (p_212843_1_.getMainArm() == Arm.RIGHT) {
                this.rightArmPose = BipedEntityModel.ArmPose.BOW_AND_ARROW;
            } else {
                this.leftArmPose = BipedEntityModel.ArmPose.BOW_AND_ARROW;
            }
        }

        super.animateModel(p_212843_1_, p_212843_2_, p_212843_3_, p_212843_4_);
    }

    public void setAngles(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
        super.setAngles(p_225597_1_, p_225597_2_, p_225597_3_, p_225597_4_, p_225597_5_, p_225597_6_);
        ItemStack itemstack = p_225597_1_.getMainHandStack();
        if (p_225597_1_.isAttacking() && (itemstack.isEmpty() || itemstack.getItem() != Items.BOW)) {
            float f = MathHelper.sin(this.handSwingProgress * (float)Math.PI);
            float f1 = MathHelper.sin((1.0F - (1.0F - this.handSwingProgress) * (1.0F - this.handSwingProgress)) * (float)Math.PI);
            this.rightArm.roll = 0.0F;
            this.leftArm.roll = 0.0F;
            this.rightArm.yaw = -(0.1F - f * 0.6F);
            this.leftArm.yaw = 0.1F - f * 0.6F;
            this.rightArm.pitch = (-(float)Math.PI / 2F);
            this.leftArm.pitch = (-(float)Math.PI / 2F);
            this.rightArm.pitch -= f * 1.2F - f1 * 0.4F;
            this.leftArm.pitch -= f * 1.2F - f1 * 0.4F;
            CrossbowPosing.swingArms(this.rightArm, this.leftArm, p_225597_4_);
        }

    }

    public void setArmAngle(Arm p_225599_1_, MatrixStack p_225599_2_) {
        float f = p_225599_1_ == Arm.RIGHT ? 1.0F : -1.0F;
        ModelPart modelrenderer = this.getArm(p_225599_1_);
        modelrenderer.pivotX += f;
        modelrenderer.rotate(p_225599_2_);
        modelrenderer.pivotX -= f;
    }
}
