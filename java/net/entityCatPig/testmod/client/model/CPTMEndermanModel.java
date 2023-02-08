package net.entityCatPig.testmod.client.model;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.entity.mob.EndermanEntity;


public class CPTMEndermanModel<T extends EndermanEntity> extends PlayerEntityModel<T> {

    public boolean carrying;
    public boolean creepy;
    public ModelPart topCube;

    public CPTMEndermanModel(ModelPart mdp) {
        this(mdp, false);
    }

    public CPTMEndermanModel(ModelPart p_i46303_1_, boolean p_i46303_2_) {
        super(p_i46303_1_,p_i46303_2_);
        this.topCube = p_i46303_1_.getChild("top_cube");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = PlayerEntityModel.getTexturedModelData(new Dilation(0.0F),false);
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild("top_cube",
                ModelPartBuilder.create().uv(0,0)
                        .cuboid(-1.0F, -18.0F, -1.0F, 2.0F, 2.0F, 2.0F,new Dilation(0.0F)),
                ModelTransform.NONE);
        return TexturedModelData.of(modelData,64,64);
    }
    public static TexturedModelData getTexturedModelDataIA() {
        return TexturedModelData.of(BipedEntityModel.getModelData(new Dilation(0.5F),0.0F),64,32);
    }
    public static TexturedModelData getTexturedModelDataOA() {
        return TexturedModelData.of(BipedEntityModel.getModelData(new Dilation(1.0F),0.0F),64,32);
    }

    protected Iterable<ModelPart> getBodyParts() {
        return Iterables.concat(super.getBodyParts(), ImmutableList.of(this.topCube));
    }

    public void setAngles(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
        super.setAngles(p_225597_1_, p_225597_2_, p_225597_3_, p_225597_4_, p_225597_5_, p_225597_6_);

        if (this.carrying) {
            this.rightArm.pitch = -0.75F;
            this.leftArm.pitch = -0.75F;
            this.rightArm.roll = 0.05F;
            this.leftArm.roll = -0.05F;
        }

        this.leftSleeve.pitch = this.leftArm.pitch;
        this.leftSleeve.roll = this.leftArm.roll;
        this.rightSleeve.pitch = this.rightArm.pitch;
        this.rightSleeve.roll = this.rightArm.roll;
        this.leftPants.pitch = this.leftLeg.pitch;
        this.rightPants.pitch = this.rightLeg.pitch;
        this.hat.pivotX = this.head.pivotX;
        this.hat.pivotY = this.head.pivotY;
        this.hat.pivotZ = this.head.pivotZ;
        this.hat.pitch = this.head.pitch;
        this.hat.yaw = this.head.yaw;
        this.hat.roll = this.head.roll;

    }
}

