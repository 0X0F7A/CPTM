package net.entityCatPig.testmod.client.model;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.entity.mob.GuardianEntity;
import net.minecraft.util.math.MathHelper;




public class CPTMGuardianModel<T extends GuardianEntity> extends PlayerEntityModel<T> {

    public CPTMGuardianModel(ModelPart mdp) {
        this(mdp, true);
    }
    private final ModelPart[] tailParts;
    public float NSwimAmount = -0.1F;

    public CPTMGuardianModel(ModelPart root, boolean p_i46303_2_) {
        super(root,p_i46303_2_);
        this.tailParts = new ModelPart[3];
        this.tailParts[0] = root.getChild("tailparts0");
        this.tailParts[1] = root.getChild("tailparts0").getChild("tailparts1");
        this.tailParts[2] = root.getChild("tailparts0").getChild("tailparts1").getChild("tailparts2");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = PlayerEntityModel.getTexturedModelData(new Dilation(0.0F),true);
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData modelPartData1 = modelPartData.addChild("tailparts0",
                        ModelPartBuilder.create().uv(0,64)
                                .cuboid(-2.0F, 10.0F, 7.0F, 4.0F, 4.0F, 8.0F, new Dilation(0.0F)),
                        ModelTransform.NONE)
                .addChild("tailparts1",
                        ModelPartBuilder.create().uv(0, 76)
                                .cuboid(0.0F, 10.0F, 0.0F, 3.0F, 3.0F, 7.0F, new Dilation(0.0F)),
                        ModelTransform.NONE);
        modelPartData1.addChild("tailparts2",
                ModelPartBuilder.create().uv(0, 86)
                        .cuboid(0.0F, 10.0F, 0.0F, 2.0F, 2.0F, 6.0F, new Dilation(0.0F)).uv(0, 94)
                        .cuboid(1.0F, 6.5F, 3.0F, 1.0F, 9.0F, 9.0F, new Dilation(0.0F)),
                ModelTransform.NONE);
        return TexturedModelData.of(modelData,64,128);
    }
    public static TexturedModelData getTexturedModelDataIA() {
        return TexturedModelData.of(BipedEntityModel.getModelData(new Dilation(0.5F),0.0F),64,32);
    }
    public static TexturedModelData getTexturedModelDataOA() {
        return TexturedModelData.of(BipedEntityModel.getModelData(new Dilation(1.0F),0.0F),64,32);
    }

    protected Iterable<ModelPart> getBodyParts() {
        return Iterables.concat(super.getBodyParts(), ImmutableList.of(this.tailParts[0]));
    }


    public void setAngles(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {

        if(p_225597_1_.areSpikesRetracted() && p_225597_1_.isTouchingWater()) {
            if(this.NSwimAmount<=0.0F){
                this.NSwimAmount = 0.01F;
            } else {
                this.NSwimAmount += 0.01F;
            }
        } else {
            this.NSwimAmount = 0.0F;
        }
        this.leaningPitch = this.NSwimAmount;

        super.setAngles(p_225597_1_, p_225597_2_, p_225597_3_, p_225597_4_, p_225597_5_, p_225597_6_);
        float f = p_225597_4_ - (float)p_225597_1_.age;
        float f2 = p_225597_1_.getTailAngle(f);
        this.tailParts[0].yaw = MathHelper.sin(f2) * (float)Math.PI * 0.05F;
        this.tailParts[1].yaw = MathHelper.sin(f2) * (float)Math.PI * 0.1F;
        this.tailParts[1].pivotX = -1.5F;
        this.tailParts[1].pivotY = 0.5F;
        this.tailParts[1].pivotZ = 14.0F;
        this.tailParts[2].yaw = MathHelper.sin(f2) * (float)Math.PI * 0.15F;
        this.tailParts[2].pivotX = 0.5F;
        this.tailParts[2].pivotY = 0.5F;
        this.tailParts[2].pivotZ = 6.0F;
        this.tailParts[0].pivotZ = -5.0F;

        float f12 = 0.6F;
        this.rightArm.pitch *= f12;
        this.leftArm.pitch *= f12;
        this.rightLeg.pitch *= f12;
        this.leftLeg.pitch *= f12;

        this.leftPants.copyTransform(this.leftLeg);
        this.rightPants.copyTransform(this.rightLeg);
        this.leftSleeve.copyTransform(this.leftArm);
        this.rightSleeve.copyTransform(this.rightArm);
        this.jacket.copyTransform(this.body);
    }
}
