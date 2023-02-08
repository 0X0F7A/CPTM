package net.entityCatPig.testmod.client.model;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.entity.mob.CreeperEntity;


public class CPTMCreeperModel<T extends CreeperEntity> extends PlayerEntityModel<T> {

    public CPTMCreeperModel(ModelPart mdp) {
        this(mdp, true);
    }
    public ModelPart tntBlock;

    public CPTMCreeperModel(ModelPart root, boolean p_i46303_2_) {
        super(root,p_i46303_2_);
        this.tntBlock = root.getChild("tntBlock");
    }
    public static TexturedModelData getTexturedModelData() {
        return getTexturedModelData(new Dilation(0.0F));
    }
    public static TexturedModelData getTexturedModelData(Dilation dilation) {
        ModelData modelData = PlayerEntityModel.getTexturedModelData(dilation,true);
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild("tntBlock",
                ModelPartBuilder.create().uv(0,64)
                        .cuboid(-4.0F, 3.0F, -11.0F, 8.0F, 8.0F, 8.0F, dilation.add(0.0F)),
                ModelTransform.NONE);
        return TexturedModelData.of(modelData,64,128);
    }
    public static TexturedModelData getTexturedModelDataIA() {
        return TexturedModelData.of(BipedEntityModel.getModelData(new Dilation(0.5F),0.0F),64,32);
    }
    public static TexturedModelData getTexturedModelDataOA() {
        return TexturedModelData.of(BipedEntityModel.getModelData(new Dilation(1.0F),0.0F),64,32);
    }
    public static TexturedModelData getTexturedModelDataArmor() {
        return getTexturedModelData(new Dilation(1.5F));
    }

    protected Iterable<ModelPart> getBodyParts() {
        return Iterables.concat(super.getBodyParts(), ImmutableList.of(this.tntBlock));
    }


    public void setAngles(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
        super.setAngles(p_225597_1_, p_225597_2_, p_225597_3_, p_225597_4_, p_225597_5_, p_225597_6_);

        this.rightArm.pitch = -0.75F;
        this.leftArm.pitch = -0.75F;
        this.rightArm.roll = 0.05F;
        this.leftArm.roll = -0.05F;

        this.leftPants.copyTransform(this.leftLeg);
        this.rightPants.copyTransform(this.rightLeg);
        this.leftSleeve.copyTransform(this.leftArm);
        this.rightSleeve.copyTransform(this.rightArm);
        this.jacket.copyTransform(this.body);

        this.leftSleeve.pitch = this.leftArm.pitch;
        this.leftSleeve.roll = this.leftArm.roll;
        this.rightSleeve.pitch = this.rightArm.pitch;
        this.rightSleeve.roll = this.rightArm.roll;
    }
}
