package net.entityCatPig.testmod.client.model;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.CrossbowPosing;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.entity.mob.ZombieVillagerEntity;


public class CPTMZombieVillagerModel<T extends ZombieVillagerEntity> extends PlayerEntityModel<T> {
    public CPTMZombieVillagerModel(ModelPart mdp) {
        this(mdp, true);
    }

    public CPTMZombieVillagerModel(ModelPart p_i46303_1_, boolean p_i46303_2_) {
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
        CrossbowPosing.meleeAttack(this.leftArm, this.rightArm, p_225597_1_.isAttacking(), this.handSwingProgress, p_225597_4_);
        CrossbowPosing.meleeAttack(this.leftSleeve, this.rightSleeve, p_225597_1_.isAttacking(), this.handSwingProgress, p_225597_4_);
    }

    public ModelPart getHead() {
        return this.head;
    }
    public void hatVisible(boolean p_217146_1_) {
        this.head.visible = p_217146_1_;
        this.hat.visible = p_217146_1_;
    }
}
