package net.entityCatPig.testmod.client.model;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.CrossbowPosing;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.AbstractPiglinEntity;
import net.minecraft.entity.mob.PiglinActivity;
import net.minecraft.entity.mob.PiglinBruteEntity;
import net.minecraft.util.math.MathHelper;




public class CPTMPiglinBruteModel<T extends PiglinBruteEntity> extends PlayerEntityModel<T> {
    public CPTMPiglinBruteModel(ModelPart mdp) {
        this(mdp, true);
    }

    public CPTMPiglinBruteModel(ModelPart p_i46303_1_, boolean p_i46303_2_) {
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
        super.setAngles(p_225597_1_, p_225597_2_, p_225597_3_, p_225597_4_, p_225597_5_, p_225597_6_);
        float f = ((float)Math.PI / 6F);

        if (p_225597_1_ instanceof AbstractPiglinEntity) {
            AbstractPiglinEntity abstractpiglinentity = (AbstractPiglinEntity)p_225597_1_;
            PiglinActivity piglinaction = abstractpiglinentity.getActivity();
            if (piglinaction == PiglinActivity.DANCING) {
                float f3 = p_225597_4_ / 60.0F;
                this.head.pivotX = MathHelper.sin(f3 * 10.0F);
                this.head.pivotY = MathHelper.sin(f3 * 40.0F) + 0.4F;
                this.rightArm.roll = ((float)Math.PI / 180F) * (70.0F + MathHelper.cos(f3 * 40.0F) * 10.0F);
                this.leftArm.roll = this.rightArm.roll * -1.0F;
                this.rightArm.pivotY = MathHelper.sin(f3 * 40.0F) * 0.5F + 1.5F;
                this.leftArm.pivotY = MathHelper.sin(f3 * 40.0F) * 0.5F + 1.5F;
                this.body.pivotY = MathHelper.sin(f3 * 40.0F) * 0.35F;
            } else if (piglinaction == PiglinActivity.ATTACKING_WITH_MELEE_WEAPON && this.handSwingProgress == 0.0F) {
                this.rotateMainArm(p_225597_1_);
            } else if (piglinaction == PiglinActivity.CROSSBOW_HOLD) {
                CrossbowPosing.hold(this.rightArm, this.leftArm, this.head, !p_225597_1_.isLeftHanded());
            } else if (piglinaction == PiglinActivity.CROSSBOW_CHARGE) {
                CrossbowPosing.charge(this.rightArm, this.leftArm, p_225597_1_, !p_225597_1_.isLeftHanded());
            } else if (piglinaction == PiglinActivity.ADMIRING_ITEM) {
                this.head.pitch = 0.5F;
                this.head.yaw = 0.0F;
                if (p_225597_1_.isLeftHanded()) {
                    this.rightArm.yaw = -0.5F;
                    this.rightArm.pitch = -0.9F;
                } else {
                    this.leftArm.yaw = 0.5F;
                    this.leftArm.pitch = -0.9F;
                }
            }
        } else if (p_225597_1_.getType() == EntityType.ZOMBIFIED_PIGLIN) {
            CrossbowPosing.meleeAttack(this.leftArm, this.rightArm, p_225597_1_.isAttacking(), this.handSwingProgress, p_225597_4_);
        }

        this.leftPants.copyTransform(this.leftLeg);
        this.rightPants.copyTransform(this.rightLeg);
        this.leftSleeve.copyTransform(this.leftArm);
        this.rightSleeve.copyTransform(this.rightArm);
        this.jacket.copyTransform(this.body);
        this.hat.copyTransform(this.head);
    }

    //animateArms = setupAttackAnimation

    protected void animateArms(T p_230486_1_, float p_230486_2_) {
        if (this.handSwingProgress > 0.0F && p_230486_1_ instanceof PiglinBruteEntity && ((PiglinBruteEntity)p_230486_1_).getActivity() == PiglinActivity.ATTACKING_WITH_MELEE_WEAPON) {
            CrossbowPosing.meleeAttack(this.rightArm, this.leftArm, p_230486_1_, this.handSwingProgress, p_230486_2_);
        } else {
            super.animateArms(p_230486_1_, p_230486_2_);
        }
    }

    private void rotateMainArm(T p_239117_1_) {
        if (p_239117_1_.isLeftHanded()) {
            this.leftArm.pitch = -1.8F;
        } else {
            this.rightArm.pitch = -1.8F;
        }

    }
}