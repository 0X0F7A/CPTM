package net.entityCatPig.testmod.client.model;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.CrossbowPosing;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.entity.mob.DrownedEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;




public class CPTMDrownedModel<T extends DrownedEntity> extends PlayerEntityModel<T> {
    public CPTMDrownedModel(ModelPart mdp) {
        this(mdp, true);
    }

    public CPTMDrownedModel(ModelPart p_i46303_1_, boolean p_i46303_2_) {
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

    protected Iterable<ModelPart> getHeadParts() {
        return Iterables.concat(super.getHeadParts(), ImmutableList.of(this.hat));
    }

    public void animateModel(T p_212843_1_, float p_212843_2_, float p_212843_3_, float p_212843_4_) {
        this.rightArmPose = BipedEntityModel.ArmPose.EMPTY;
        this.leftArmPose = BipedEntityModel.ArmPose.EMPTY;
        ItemStack itemstack = p_212843_1_.getStackInHand(Hand.MAIN_HAND);
        if (itemstack.getItem() == Items.TRIDENT && p_212843_1_.isAttacking()) {
            if (p_212843_1_.getMainArm() == Arm.RIGHT) {
                this.rightArmPose = BipedEntityModel.ArmPose.THROW_SPEAR;
            } else {
                this.leftArmPose = BipedEntityModel.ArmPose.THROW_SPEAR;
            }
        }

        super.animateModel(p_212843_1_, p_212843_2_, p_212843_3_, p_212843_4_);
    }

    public void setAngles(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
        super.setAngles(p_225597_1_, p_225597_2_, p_225597_3_, p_225597_4_, p_225597_5_, p_225597_6_);
        CrossbowPosing.meleeAttack(this.leftArm, this.rightArm, this.isAttacking(p_225597_1_), this.handSwingProgress, p_225597_4_);
        CrossbowPosing.meleeAttack(this.leftSleeve, this.rightSleeve, this.isAttacking(p_225597_1_), this.handSwingProgress, p_225597_4_);

        if (this.leftArmPose == BipedEntityModel.ArmPose.THROW_SPEAR) {
            this.leftArm.pitch = this.leftArm.pitch * 0.5F - (float)Math.PI;
            this.leftArm.yaw = 0.0F;
        }

        if (this.rightArmPose == BipedEntityModel.ArmPose.THROW_SPEAR) {
            this.rightArm.pitch = this.rightArm.pitch * 0.5F - (float)Math.PI;
            this.rightArm.yaw = 0.0F;
        }
        
        if (this.leaningPitch > 0.0F) {
            this.rightArm.pitch = this.lerpAngle(this.leaningPitch, this.rightArm.pitch, -2.5132742F) + this.leaningPitch * 0.35F * MathHelper.sin(0.1F * p_225597_4_);
            this.leftArm.pitch = this.lerpAngle(this.leaningPitch, this.leftArm.pitch, -2.5132742F) - this.leaningPitch * 0.35F * MathHelper.sin(0.1F * p_225597_4_);
            this.rightArm.roll = this.lerpAngle(this.leaningPitch, this.rightArm.roll, -0.15F);
            this.leftArm.roll = this.lerpAngle(this.leaningPitch, this.leftArm.roll, 0.15F);
            this.leftLeg.pitch -= this.leaningPitch * 0.55F * MathHelper.sin(0.1F * p_225597_4_);
            this.rightLeg.pitch += this.leaningPitch * 0.55F * MathHelper.sin(0.1F * p_225597_4_);
            this.head.pitch = 0.0F;
        }
    }

    public boolean isAttacking(T p_212850_1_) {
        return p_212850_1_.isAttacking();
    }
}