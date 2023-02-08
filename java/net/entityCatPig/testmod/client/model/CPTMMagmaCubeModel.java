package net.entityCatPig.testmod.client.model;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.MagmaCubeEntity;

public class CPTMMagmaCubeModel<T extends MagmaCubeEntity> extends PlayerEntityModel<T> {

    public int sizeIntIns;

    public ModelPart tntBlock;
    public CPTMMagmaCubeModel(ModelPart mdp) {
        this(mdp, true);
    }

    public CPTMMagmaCubeModel(ModelPart root, boolean p_i46303_2_) {
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

    public void render(MatrixStack p_225598_1_, VertexConsumer p_225598_2_, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
        if (sizeIntIns == 0) {
            p_225598_1_.push();
            if (true) {
                float f = 1.5F / 2.0F;
                p_225598_1_.scale(f, f, f);
            }

            p_225598_1_.translate(0.0D, (double)(16.0F / 16.0F), (double)(0.0F / 16.0F));
            this.getHeadParts().forEach((p_228230_8_) -> {
                p_228230_8_.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
            });
            p_225598_1_.pop();
            p_225598_1_.push();
            float f1 = 1.0F / 2.0F;
            p_225598_1_.scale(f1, f1, f1);
            p_225598_1_.translate(0.0D, (double)(24.0F / 16.0F), 0.0D);
            this.getBodyParts().forEach((p_228229_8_) -> {
                p_228229_8_.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
            });
            p_225598_1_.pop();
        } else {
            this.getHeadParts().forEach((p_228228_8_) -> {
                p_228228_8_.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
            });
            this.getBodyParts().forEach((p_228227_8_) -> {
                p_228227_8_.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
            });
        }
    }

    protected Iterable<ModelPart> getBodyParts() {
        if(this.sizeIntIns==2) {
            return Iterables.concat(super.getBodyParts(), ImmutableList.of(this.tntBlock));
        } else {
            return super.getBodyParts();
        }
    }

    protected Iterable<ModelPart> getHeadParts() {
        return Iterables.concat(super.getHeadParts(), ImmutableList.of(this.hat));
    }
    public ModelPart getHand() {
        return this.rightArm;
    }

    public void setAngles(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
        super.setAngles(p_225597_1_, p_225597_2_, p_225597_3_, p_225597_4_, p_225597_5_, p_225597_6_);
        if(this.sizeIntIns ==2) {
            this.rightArm.pitch = -0.75F;
            this.leftArm.pitch = -0.75F;
            this.rightArm.roll = 0.05F;
            this.leftArm.roll = -0.05F;
            this.leftLeg.pitch = 0.0F;
            this.rightLeg.pitch = 0.0F;
        } else {
            this.rightArm.pitch = 0F;
            this.leftArm.pitch = 0F;
            this.rightArm.roll = 0.1F;
            this.leftArm.roll = -0.1F;
            this.leftLeg.pitch = 0.0F;
            this.rightLeg.pitch = 0.0F;
        }

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

