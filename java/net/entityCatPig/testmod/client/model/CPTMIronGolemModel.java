package net.entityCatPig.testmod.client.model;

import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.util.math.MathHelper;




public class CPTMIronGolemModel<T extends IronGolemEntity> extends PlayerEntityModel<T> {
    public CPTMIronGolemModel(ModelPart mdp) {
        this(mdp, false);
    }
    public CPTMIronGolemModel(ModelPart p_i46303_1_, boolean p_i46303_2_) {
        super(p_i46303_1_,p_i46303_2_);
    }
    public static TexturedModelData getTexturedModelData() {
        return TexturedModelData.of(PlayerEntityModel.getTexturedModelData(new Dilation(0.0F),false),64,64);
    }
    public static TexturedModelData getTexturedModelDataIA() {
        return TexturedModelData.of(BipedEntityModel.getModelData(new Dilation(0.5F),0.0F),64,32);
    }
    public static TexturedModelData getTexturedModelDataOA() {
        return TexturedModelData.of(BipedEntityModel.getModelData(new Dilation(1.0F),0.0F),64,32);
    }

    public void setAngles(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_){
        super.setAngles(p_225597_1_,p_225597_2_,p_225597_3_, p_225597_4_, p_225597_5_,p_225597_6_);
        int i = p_225597_1_.getAttackTicksLeft();
        if (i > 0) {
            this.rightArm.pitch = -0.75F * MathHelper.wrap((float)i - p_225597_4_, 10.0F);
            this.leftArm.pitch = -0.75F * MathHelper.wrap((float)i - p_225597_4_, 10.0F);
        } else {
            int j = p_225597_1_.getLookingAtVillagerTicks();
            if (j > 0) {
                this.rightArm.pitch = -0.8F + 0.025F * MathHelper.wrap((float)j, 70.0F);
                this.leftArm.pitch = 0.0F;
            }
        }
        this.rightSleeve.copyTransform(this.rightArm);
        this.leftSleeve.copyTransform(this.leftArm);
    }
    public void animateModel(T p_212843_1_, float p_212843_2_, float p_212843_3_, float p_212843_4_) {
        super.animateModel(p_212843_1_,p_212843_2_,p_212843_3_,p_212843_4_);
        int i = p_212843_1_.getAttackTicksLeft();
        if (i > 0) {
            this.rightArm.pitch = -2.0F - 0.75F * MathHelper.wrap((float)i - p_212843_4_, 10.0F);
            this.leftArm.pitch = -2.0F - 0.75F * MathHelper.wrap((float)i - p_212843_4_, 10.0F);
        } else {
            int j = p_212843_1_.getLookingAtVillagerTicks();
            if (j > 0) {
                this.rightArm.pitch = -0.8F + 0.025F * MathHelper.wrap((float)j, 70.0F);
                this.leftArm.pitch = 0.0F;
            }
        }
        this.rightSleeve.copyTransform(this.rightArm);
        this.leftSleeve.copyTransform(this.leftArm);

    }
}
