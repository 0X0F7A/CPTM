package net.entityCatPig.testmod.client.model;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.entity.LivingEntity;

public class CPTMFlyingPlayerModel<T extends LivingEntity> extends PlayerEntityModel<T> {

    public final ModelPart Njacket;
    public final ModelPart left_arm_Lower_r1;
    public final ModelPart left_sleve;
    public final ModelPart left_sleve_Lower_r1;
    public final ModelPart right_arm_Lower_r1;
    public final ModelPart right_sleve;
    public final ModelPart right_sleve_Lower_r1;
    public final ModelPart left_leg_Lower_r1;
    public final ModelPart left_pants;
    public final ModelPart left_pants_Lower_r1;
    public final ModelPart right_leg_Lower_r1;
    public final ModelPart right_pants;
    public final ModelPart right_pants_Lower_r1;
    public final ModelPart leftSleeve;
    public final ModelPart rightSleeve;
    public final ModelPart leftPants;
    public final ModelPart rightPants;
    public final ModelPart head;
    public final ModelPart hat;
    public final ModelPart body;
    public final ModelPart rightArm;
    public final ModelPart leftArm;
    public final ModelPart rightLeg;
    public final ModelPart leftLeg;
    private final ModelPart cloak;
    private final ModelPart ear;


    public CPTMFlyingPlayerModel(ModelPart root, boolean slim) {
        super(root, slim);
        this.Njacket = root.getChild("jacket");
        this.left_arm_Lower_r1 = root.getChild("left_arm").getChild("left_arm_Lower_r1");
        this.left_sleve = root.getChild("left_sleeve");
        this.left_sleve_Lower_r1 = root.getChild("left_sleeve").getChild("left_sleeve_Lower_r1");
        this.right_arm_Lower_r1 = root.getChild("right_arm").getChild("right_arm_Lower_r1");
        this.right_sleve = root.getChild("right_sleeve");
        this.right_sleve_Lower_r1 = root.getChild("right_sleeve").getChild("right_sleeve_Lower_r1");
        this.left_leg_Lower_r1 = root.getChild("left_leg").getChild("left_leg_Lower_r1");
        this.left_pants = root.getChild("left_pants");
        this.left_pants_Lower_r1 = root.getChild("left_pants").getChild("left_pants_Lower_r1");
        this.right_leg_Lower_r1 = root.getChild("right_leg").getChild("right_leg_Lower_r1");
        this.right_pants = root.getChild("right_pants");
        this.right_pants_Lower_r1 = root.getChild("right_pants").getChild("right_pants_Lower_r1");
        this.leftSleeve = root.getChild("left_sleeve");
        this.rightSleeve = root.getChild("right_sleeve");
        this.leftPants = root.getChild("left_pants");
        this.rightPants = root.getChild("right_pants");
        this.head = root.getChild("head");
        this.hat = root.getChild("hat");
        this.body = root.getChild("body");
        this.rightArm = root.getChild("right_arm");
        this.leftArm = root.getChild("left_arm");
        this.rightLeg = root.getChild("right_leg");
        this.leftLeg = root.getChild("left_leg");
        this.ear = root.getChild("ear");
        this.cloak = root.getChild("cloak");

        setRotationAngle(this.leftArm, 0.1719F, 0.0302F, -0.1719F);
        setRotationAngle(left_arm_Lower_r1, -0.3491F, 0.0F, 0.0F);
        setRotationAngle(this.left_sleve, 0.1719F, 0.0302F, -0.1719F);
        setRotationAngle(left_sleve_Lower_r1, -0.3491F, 0.0F, 0.0F);
        setRotationAngle(this.rightArm, 0.1719F, -0.0302F, 0.1719F);
        setRotationAngle(right_arm_Lower_r1, -0.3491F, 0.0F, 0.0F);
        setRotationAngle(this.right_sleve, 0.1719F, -0.0302F, 0.1719F);
        setRotationAngle(right_sleve_Lower_r1, -0.3491F, 0.0F, 0.0F);
        setRotationAngle(this.leftLeg, -0.2569F, -0.0594F, -0.1642F);
        setRotationAngle(left_leg_Lower_r1, 0.6981F, 0.0F, 0.0F);
        setRotationAngle(this.left_pants, -0.2569F, -0.0594F, -0.1642F);
        setRotationAngle(left_pants_Lower_r1, 0.6981F, 0.0F, 0.0F);
        setRotationAngle(this.rightLeg, -0.2569F, 0.0594F, 0.1642F);
        setRotationAngle(right_leg_Lower_r1, 0.6981F, 0.0F, 0.0F);
        setRotationAngle(this.right_pants, -0.2569F, 0.0594F, 0.1642F);
        setRotationAngle(right_pants_Lower_r1, 0.6981F, 0.0F, 0.0F);

    }

    public static ModelData getModelData(Dilation dilation){
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild("ear", ModelPartBuilder.create().uv(24, 0).cuboid(-3.0F, -6.0F, -1.0F, 6.0F, 6.0F, 1.0F, dilation), ModelTransform.NONE);
        modelPartData.addChild("cloak", ModelPartBuilder.create().uv(0, 0).cuboid(-5.0F, 0.0F, -1.0F, 10.0F, 16.0F, 1.0F, dilation, 1.0F, 0.5F), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        modelPartData.addChild("head",
                ModelPartBuilder.create().uv(0, 0)
                        .cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, dilation),
                ModelTransform.NONE);
        modelPartData.addChild("hat",
                ModelPartBuilder.create().uv(32, 0)
                        .cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, dilation.add(0.5F)),
                ModelTransform.NONE);
        modelPartData.addChild("body",
                ModelPartBuilder.create().uv(16, 16)
                        .cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, dilation.add(0.0F)),
                ModelTransform.NONE);
        modelPartData.addChild("jacket",
                ModelPartBuilder.create().uv(16, 32)
                        .cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, dilation.add(0.25F)),
                ModelTransform.NONE);
        ModelPartData modelPartDataLeftArm = modelPartData.addChild("left_arm",
                ModelPartBuilder.create().uv(32, 56)
                        .cuboid(-1.0F, -2.0F, -2.0F, 3.0F, 6.0F, 4.0F, dilation.add(0.0F)),
                ModelTransform.pivot(5.0F, 2.0F, 0.0F));
        modelPartDataLeftArm.addChild("left_arm_Lower_r1",
                ModelPartBuilder.create().uv(32, 66)
                        .cuboid(-1.0F, 0.0F, -4.0F, 3.0F, 6.0F, 4.0F, dilation.add(0.0F)),
                ModelTransform.pivot(0.0F, 4.0F, 2.0F));
        ModelPartData modelPartDataLeftSleeve = modelPartData.addChild("left_sleeve",
                ModelPartBuilder.create().uv(48, 56)
                        .cuboid(-1.0F, -2.25F, -2.0F, 3.0F, 6.0F, 4.0F, dilation.add(0.25F)),
                ModelTransform.pivot(5.0F, 2.0F, 0.0F));
        modelPartDataLeftSleeve.addChild("left_sleeve_Lower_r1",
                ModelPartBuilder.create().uv(48, 66)
                        .cuboid(-1.0F, 0.25F, -4.0F, 3.0F, 6.0F, 4.0F, dilation.add(0.25F)),
                ModelTransform.pivot(0.0F, 4.0F, 2.0F));
        ModelPartData modelPartDataRightArm = modelPartData.addChild("right_arm",
                ModelPartBuilder.create().uv(40, 16)
                        .cuboid(-2.0F, -2.0F, -2.0F, 3.0F, 6.0F, 4.0F, dilation.add(0.0F)),
                ModelTransform.pivot(-5.0F, 2.0F, 0.0F));
        modelPartDataRightArm.addChild("right_arm_Lower_r1",
                ModelPartBuilder.create().uv(40, 26)
                        .cuboid(-2.0F, 0.0F, -4.0F, 3.0F, 6.0F, 4.0F, dilation.add(0.0F)),
                ModelTransform.pivot(0.0F, 4.0F, 2.0F));
        ModelPartData modelPartDataRightSleeve = modelPartData.addChild("right_sleeve",
                ModelPartBuilder.create().uv(40, 36)
                        .cuboid(-2.0F, -2.25F, -2.0F, 3.0F, 6.0F, 4.0F, dilation.add(0.25F)),
                ModelTransform.pivot(-5.0F, 2.0F, 0.0F));
        modelPartDataRightSleeve.addChild("right_sleeve_Lower_r1",
                ModelPartBuilder.create().uv(40, 46)
                        .cuboid(-2.0F, 0.25F, -4.0F, 3.0F, 6.0F, 4.0F, dilation.add(0.25F)),
                ModelTransform.pivot(0.0F, 4.0F, 2.0F));
        ModelPartData modelPartDataLeftLeg = modelPartData.addChild("left_leg",
                ModelPartBuilder.create().uv(16, 56)
                        .cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, dilation.add(0.0F)),
                ModelTransform.pivot(2.0F, 12.0F, 0.0F));
        modelPartDataLeftLeg.addChild("left_leg_Lower_r1",
                ModelPartBuilder.create().uv(16, 66)
                        .cuboid(0.0F, 0.0F, 0.0F, 4.0F, 6.0F, 4.0F, dilation.add(0.0F)),
                ModelTransform.pivot(-2.0F, 6.0F, -2.0F));
        ModelPartData modelPartDataLeftPants = modelPartData.addChild("left_pants",
                ModelPartBuilder.create().uv(0, 56)
                        .cuboid(-2.0F, -0.25F, -2.0F, 4.0F, 6.0F, 4.0F, dilation.add(0.25F)),
                ModelTransform.pivot(2.0F, 12.0F, 0.0F));
        modelPartDataLeftPants.addChild("left_pants_Lower_r1",
                ModelPartBuilder.create().uv(0, 66)
                        .cuboid(0.0F, 0.25F, 0.0F, 4.0F, 6.0F, 4.0F, dilation.add(0.25F)),
                ModelTransform.pivot(-2.0F, 6.0F, -2.0F));
        ModelPartData modelPartDataRightLeg = modelPartData.addChild("right_leg",
                ModelPartBuilder.create().uv(0, 16)
                        .cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, dilation.add(0.0F)),
                ModelTransform.pivot(-2.0F, 12.0F, 0.0F));
        modelPartDataRightLeg.addChild("right_leg_Lower_r1",
                ModelPartBuilder.create().uv(0, 26)
                        .cuboid(-4.0F, 0.0F, 0.0F, 4.0F, 6.0F, 4.0F, dilation.add(0.0F)),
                ModelTransform.pivot(2.0F, 6.0F, -2.0F));
        ModelPartData modelPartDataRightPants = modelPartData.addChild("right_pants",
                ModelPartBuilder.create().uv(0, 36)
                        .cuboid(-2.0F, -0.25F, -2.0F, 4.0F, 6.0F, 4.0F, dilation.add(0.25F)),
                ModelTransform.pivot(-2.0F, 12.0F, 0.0F));
        modelPartDataRightPants.addChild("right_pants_Lower_r1",
                ModelPartBuilder.create().uv(0, 46)
                        .cuboid(-4.0F, 0.25F, 0.0F, 4.0F, 6.0F, 4.0F, dilation.add(0.25F)),
                ModelTransform.pivot(2.0F, 6.0F, -2.0F));
        return modelData;
    }

    public void setAngles(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
        super.setAngles(p_225597_1_, p_225597_2_, p_225597_3_, p_225597_4_, p_225597_5_, p_225597_6_);
        this.rightLeg.pitch = 0.1F;
        this.leftLeg.pitch = 0.0F;
        this.rightArm.pitch = 0.0F;
        this.leftArm.pitch = 0.0F;
        this.rightLeg.yaw = 0.0F;
        this.leftLeg.yaw = 0.0F;
        this.rightLeg.roll = 0.1F;
        this.leftLeg.roll = -0.1F;
        this.left_pants.copyTransform(this.leftLeg);
        this.right_pants.copyTransform(this.rightLeg);
        this.left_sleve.copyTransform(this.leftArm);
        this.right_sleve.copyTransform(this.rightArm);
        this.Njacket.copyTransform(this.body);
    }

    protected Iterable<ModelPart> getBodyParts() {
        return ImmutableList.of(this.Njacket,this.body, this.rightArm, this.leftArm, this.rightLeg, this.leftLeg,
                this.hat, this.left_sleve,this.right_sleve,this.right_pants,this.left_pants);
    }
    protected Iterable<ModelPart> getHeadParts() {
        return ImmutableList.of(this.hat,this.head);
    }

    public void setRotationAngle(ModelPart modelRenderer, float x, float y, float z) {
        modelRenderer.pitch = x;
        modelRenderer.yaw = y;
        modelRenderer.roll = z;
    }

}
