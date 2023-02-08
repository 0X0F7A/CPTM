package net.entityCatPig.testmod.client.model;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.util.math.MathHelper;




public class CPTMCatModel<T extends CatEntity> extends PlayerEntityModel<T> {
    public CPTMCatModel(ModelPart mdp) {
        this(mdp, true);
    }
    public final ModelPart tail1;
    public final ModelPart tail2;
    protected int state = 1;
    private float lieDownAmount;
    private float lieDownAmountTail;
    private float relaxStateOneAmount;
    private static float tailShiftAmount = 7.0F;
    private static float sitShifiAmount = -9.5F;
    private static float tailYShiftAmount = 7.0F;

    public CPTMCatModel(ModelPart p_i46303_1_, boolean p_i46303_2_) {
        super(p_i46303_1_,p_i46303_2_);
        this.tail1 = p_i46303_1_.getChild("tail1");
        this.tail1.pitch = 0.9F;
        this.tail2 = p_i46303_1_.getChild("tail2");

        //this.body.addChild(this.tail1);
        //this.tail1.addChild(this.tail2);
    }

    public static TexturedModelData getTexturedModelData() {
        return getTexturedModelData(0.0F);
    }

    public static TexturedModelData getTexturedModelData(float dilation) {
        ModelData modelData = PlayerEntityModel.getTexturedModelData(new Dilation(dilation),true);
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild("tail1",
                ModelPartBuilder.create().uv(54,16)
                        .cuboid(-0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F,new Dilation(dilation)),
                ModelTransform.pivot(0.0F, 15.0F-tailYShiftAmount, 8.0F-tailShiftAmount));
        modelPartData.addChild("tail2",
                ModelPartBuilder.create().uv(58, 16)
                        .cuboid(-0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F,new Dilation(dilation)),
                ModelTransform.pivot(0.0F, 20.0F-tailYShiftAmount, 14.0F-tailShiftAmount));
        return TexturedModelData.of(modelData,64,64);
    }
    public static TexturedModelData getTexturedModelDataIA() {
        return TexturedModelData.of(BipedEntityModel.getModelData(new Dilation(0.5F),0.0F),64,32);
    }
    public static TexturedModelData getTexturedModelDataOA() {
        return TexturedModelData.of(BipedEntityModel.getModelData(new Dilation(1.0F),0.0F),64,32);
    }

    protected Iterable<ModelPart> getHeadParts() {
        return ImmutableList.of(this.head, this.hat, this.tail1, this.tail2);
    }

    public static TexturedModelData getTexturedModelDataCatCollar() {
        return getTexturedModelData(0.25F);
    }

    public void setAngles(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
        super.setAngles(p_225597_1_, p_225597_2_, p_225597_3_, p_225597_4_, p_225597_5_, p_225597_6_);
        if (this.state != 3) {
            if (this.state == 2) {
                this.tail2.pitch = 1.7278761F + ((float)Math.PI / 10F) * MathHelper.cos(p_225597_2_) * p_225597_3_;
            } else {
                if (this.state == 1) {
                    this.tail2.pitch = 1.7278761F + ((float)Math.PI / 4F) * MathHelper.cos(p_225597_2_) * p_225597_3_;
                } else {
                    this.tail2.pitch = 1.7278761F + 0.47123894F * MathHelper.cos(p_225597_2_) * p_225597_3_;
                }
            }
        }
        if (this.lieDownAmount > 0.0F) {
            this.tail1.pitch = ModelUtil.interpolateAngle(this.tail1.pitch, 0.8F, this.lieDownAmountTail);
            this.tail2.pitch = ModelUtil.interpolateAngle(this.tail2.pitch, -0.4F, this.lieDownAmountTail);
        }
        if (p_225597_1_.isInSittingPose()) {
            this.body.pivotY -= sitShifiAmount;
            this.jacket.pivotY -= sitShifiAmount;
            this.head.pivotY -= sitShifiAmount/1.5F;
            this.hat.pivotY -= sitShifiAmount/1.5F;
            this.rightArm.pivotY -= sitShifiAmount;
            this.rightLeg.pivotY -= sitShifiAmount;
            this.rightSleeve.pivotY -= sitShifiAmount;
            this.rightPants.pivotY -= sitShifiAmount;
            this.leftArm.pivotY -= sitShifiAmount;
            this.leftLeg.pivotY -= sitShifiAmount;
            this.leftSleeve.pivotY -= sitShifiAmount;
            this.leftPants.pivotY -= sitShifiAmount;
        }
    }

    public void animateModel(T p_212843_1_, float p_212843_2_, float p_212843_3_, float p_212843_4_) {
        if(p_212843_1_.isInSittingPose()){
            this.riding = true;
        }
        super.animateModel(p_212843_1_,p_212843_2_,p_212843_3_,p_212843_4_);
        this.lieDownAmount = p_212843_1_.getSleepAnimation(p_212843_4_);
        this.lieDownAmountTail = p_212843_1_.getTailCurlAnimation(p_212843_4_);
        this.relaxStateOneAmount = p_212843_1_.getHeadDownAnimation(p_212843_4_);
        this.tail1.pivotY = 15.0F-tailYShiftAmount;
        this.tail1.pivotZ = 8.0F-tailShiftAmount;
        this.tail2.pivotY = 20.0F-tailYShiftAmount;
        this.tail2.pivotZ = 14.0F-tailShiftAmount;
        this.tail1.pitch = 0.9F;
        if (p_212843_1_.isSprinting()) {
            this.tail2.pivotY = this.tail1.pivotY;
            this.tail2.pivotZ += 2.0F;
            this.tail1.pitch = ((float)Math.PI / 2F);
            this.tail2.pitch = ((float)Math.PI / 2F);
            this.state = 2;
        } else {
            this.state = 1;
        }
        if (p_212843_1_.isInSittingPose()) {
            this.tail1.pivotY += 6.0F;
            this.tail2.pivotZ += 1.2F;
            this.tail1.pitch = 1.7278761F;
            this.tail2.pitch = 2.670354F;
            this.state = 3;

        }

    }
    
    public void render(MatrixStack p_225598_1_, VertexConsumer p_225598_2_, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
        p_225598_1_.push();
        if (true) {
            float f = 3.0F / 2.0F;
            p_225598_1_.scale(f, f, f);
        }

        //p_225598_1_.translate(0.0D, (double)(16.0F / 16.0F), (double)(0.0F / 16.0F));
        this.getHeadParts().forEach((p_228230_8_) -> {
            p_228230_8_.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        });
        p_225598_1_.pop();

        p_225598_1_.push();
        float f1 = 2.0F / 2.0F;
        p_225598_1_.scale(f1, f1, f1);
        this.getBodyParts().forEach((p_228229_8_) -> {
            p_228229_8_.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        });
        p_225598_1_.pop();
    }
    public void getIfSitting(){
        return;
    }
}

