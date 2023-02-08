package net.entityCatPig.testmod.client.model;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.CrossbowPosing;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.entity.mob.EvokerEntity;
import net.minecraft.entity.mob.IllagerEntity;
import net.minecraft.util.math.MathHelper;




public class CPTMEvokerModel<T extends EvokerEntity> extends PlayerEntityModel<T> {
    public CPTMEvokerModel(ModelPart mdp) {
        this(mdp, true);
    }

    public CPTMEvokerModel(ModelPart p_i46303_1_, boolean p_i46303_2_) {
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
    public void setAngles(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
        super.setAngles(p_225597_1_,p_225597_2_,p_225597_3_,p_225597_4_,p_225597_5_,p_225597_6_);
        IllagerEntity.State abstractillagerentity$armpose = p_225597_1_.getState();
        if (abstractillagerentity$armpose == IllagerEntity.State.ATTACKING) {
            if (p_225597_1_.getMainHandStack().isEmpty()) {
                CrossbowPosing.meleeAttack(this.leftArm, this.rightArm, true, this.handSwingProgress, p_225597_4_);
            } else {
                CrossbowPosing.meleeAttack(this.rightArm, this.leftArm, p_225597_1_, this.handSwingProgress, p_225597_4_);
            }
        } else if (abstractillagerentity$armpose == IllagerEntity.State.SPELLCASTING) {
            this.rightArm.pivotZ = 0.0F;
            this.rightArm.pivotX = -5.0F;
            this.leftArm.pivotZ = 0.0F;
            this.leftArm.pivotX = 5.0F;
            this.rightArm.pitch = MathHelper.cos(p_225597_4_ * 0.6662F) * 0.25F;
            this.leftArm.pitch = MathHelper.cos(p_225597_4_ * 0.6662F) * 0.25F;
            this.rightArm.roll = 2.3561945F;
            this.leftArm.roll = -2.3561945F;
            this.rightArm.yaw = 0.0F;
            this.leftArm.yaw = 0.0F;
        } else if (abstractillagerentity$armpose == IllagerEntity.State.CELEBRATING) {
            this.rightArm.pivotZ = 0.0F;
            this.rightArm.pivotX = -5.0F;
            this.rightArm.pitch = MathHelper.cos(p_225597_4_ * 0.6662F) * 0.05F;
            this.rightArm.roll = 2.670354F;
            this.rightArm.yaw = 0.0F;
            this.leftArm.pivotZ = 0.0F;
            this.leftArm.pivotX = 5.0F;
            this.leftArm.pitch = MathHelper.cos(p_225597_4_ * 0.6662F) * 0.05F;
            this.leftArm.roll = -2.3561945F;
            this.leftArm.yaw = 0.0F;
        }
        this.leftPants.copyTransform(this.leftLeg);
        this.rightPants.copyTransform(this.rightLeg);
        this.leftSleeve.copyTransform(this.leftArm);
        this.rightSleeve.copyTransform(this.rightArm);
        this.jacket.copyTransform(this.body);
    }

    public ModelPart getHat() {
        return this.hat;
    }

    public ModelPart getHead() {
        return this.head;
    }
}