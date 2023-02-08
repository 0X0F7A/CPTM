package net.entityCatPig.testmod.client.model;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.CaveSpiderEntity;

public class CPTMCaveSpiderModel<T extends CaveSpiderEntity> extends PlayerEntityModel<T> {

    public CPTMCaveSpiderModel(ModelPart mdp) {
        this(mdp, true);
    }

    public final ModelPart leg1;
    public final ModelPart leg1_r1;
    public final ModelPart leg2;
    public final ModelPart leg1_r2;
    public final ModelPart leg3;
    public final ModelPart leg1_r3;
    public final ModelPart leg4;
    public final ModelPart leg1_r4;
    public final ModelPart leg5;
    public final ModelPart leg1_r5;
    public final ModelPart leg6;
    public final ModelPart leg1_r6;
    public final ModelPart leg7;
    public final ModelPart leg1_r7;
    public final ModelPart leg8;
    public final ModelPart leg1_r8;

    public CPTMCaveSpiderModel(ModelPart root, boolean p_i46303_2_) {
        super(root, p_i46303_2_);
        this.leg1 = root.getChild("leg1");
        this.leg1_r1 = root.getChild("leg1").getChild("leg1_r1");
        this.leg2 = root.getChild("leg2");
        this.leg1_r2= root.getChild("leg2").getChild("leg1_r2");
        this.leg3 = root.getChild("leg3");
        this.leg1_r3= root.getChild("leg3").getChild("leg1_r3");
        this.leg4 = root.getChild("leg4");
        this.leg1_r4= root.getChild("leg4").getChild("leg1_r4");
        this.leg5 = root.getChild("leg5");
        this.leg1_r5= root.getChild("leg5").getChild("leg1_r5");
        this.leg6 = root.getChild("leg6");
        this.leg1_r6= root.getChild("leg6").getChild("leg1_r6");
        this.leg7 = root.getChild("leg7");
        this.leg1_r7= root.getChild("leg7").getChild("leg1_r7");
        this.leg8 = root.getChild("leg8");
        this.leg1_r8= root.getChild("leg8").getChild("leg1_r8");

        setRotationAngle(leg1, 0.3295F, 0.7268F, 0.4754F);
        setRotationAngle(leg1_r1, 0.0F, 0.0F, -1.5708F);
        setRotationAngle(leg2, 0.0914F, 0.2457F, 0.3604F);
        setRotationAngle(leg1_r2, 0.0F, 0.0F, -1.5708F);
        setRotationAngle(leg3, -0.0914F, -0.2457F, 0.3604F);
        setRotationAngle(leg1_r3, 0.0F, 0.0F, -1.5708F);
        setRotationAngle(leg4, -0.3295F, -0.7268F, 0.4754F);
        setRotationAngle(leg1_r4, 0.0F, 0.0F, -1.5708F);
        setRotationAngle(leg5, 3.0177F, 0.3272F, 2.7721F);
        setRotationAngle(leg1_r5, 0.0F, 0.0F, -1.5708F);
        setRotationAngle(leg6, 2.812F, 0.7268F, 2.6662F);
        setRotationAngle(leg1_r6, 0.0F, 0.0F, -1.5708F);
        setRotationAngle(leg7, -3.0177F, -0.3272F, 2.7721F);
        setRotationAngle(leg1_r7, 0.0F, 0.0F, -1.5708F);
        setRotationAngle(leg8, -2.812F, -0.7268F, 2.6662F);
        setRotationAngle(leg1_r8, 0.0F, 0.0F, -1.5708F);
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = PlayerEntityModel.getTexturedModelData(new Dilation(0.0F),true);
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild("body",
                ModelPartBuilder.create().uv(0, 48).cuboid(-7.0F, -4.0F, -6.0F, 12.0F, 8.0F, 12.0F)
                        .uv(0, 68).cuboid(-5.0F, -3.0F, -14.0F, 8.0F, 6.0F, 8.0F)
                        .uv(14, 16).cuboid(-5.0F, -14.0F, -15.0F, 8.0F, 12.0F, 4.0F)
                        .uv(14, 32).cuboid(-5.0F, -14.0F, -15.0F, 8.0F, 12.0F, 4.0F,new Dilation(0.25F)),
                ModelTransform.pivot(1.0F, 15.0F, 9.0F));
        modelPartData.addChild("leg1",
                        ModelPartBuilder.create().uv(44, 52).cuboid(-8.0F, 0.0F, -1.0F, 8.0F, 2.0F, 2.0F),
                        ModelTransform.pivot(-4.0F, 14.0F, 0.25F))
                .addChild("leg1_r1",
                        ModelPartBuilder.create().uv(44, 48).cuboid(-8.0F, 0.0F, -1.0F, 8.0F, 2.0F, 2.0F),
                        ModelTransform.pivot(-8.0F, 2.0F, 0.0F));
        modelPartData.addChild("leg2",
                        ModelPartBuilder.create().uv(44, 52).cuboid(-8.0F, 0.0F, -1.0F, 8.0F, 2.0F, 2.0F),
                        ModelTransform.pivot(-4.0F, 14.0F, 0.5F))
                .addChild("leg1_r2",
                        ModelPartBuilder.create().uv(44, 48).cuboid(-8.0F, 0.0F, -1.0F, 8.0F, 2.0F, 2.0F),
                        ModelTransform.pivot(-8.0F, 2.0F, 0.0F));
        modelPartData.addChild("leg3",
                        ModelPartBuilder.create().uv(44, 52).cuboid(-8.0F, 0.0F, -1.0F, 8.0F, 2.0F, 2.0F),
                        ModelTransform.pivot(-4.0F, 14.0F, 0.0F))
                .addChild("leg1_r3",
                        ModelPartBuilder.create().uv(44, 48).cuboid(-8.0F, 0.0F, -1.0F, 8.0F, 2.0F, 2.0F),
                        ModelTransform.pivot(-8.0F, 2.0F, 0.0F));
        modelPartData.addChild("leg4",
                        ModelPartBuilder.create().uv(44, 52).cuboid(-8.0F, 0.0F, -1.0F, 8.0F, 2.0F, 2.0F),
                        ModelTransform.pivot(-4.0F, 14.0F, -0.25F))
                .addChild("leg1_r4",
                        ModelPartBuilder.create().uv(44, 48).cuboid(-8.0F, 0.0F, -1.0F, 8.0F, 2.0F, 2.0F),
                        ModelTransform.pivot(-8.0F, 2.0F, 0.0F));
        modelPartData.addChild("leg5",
                        ModelPartBuilder.create().uv(44, 52).cuboid(-8.0F, 0.0F, -1.0F, 8.0F, 2.0F, 2.0F),
                        ModelTransform.pivot(4.0F, 14.0F, 0.25F))
                .addChild("leg1_r5",
                        ModelPartBuilder.create().uv(44, 48).cuboid(-8.0F, 0.0F, -1.0F, 8.0F, 2.0F, 2.0F),
                        ModelTransform.pivot(-8.0F, 2.0F, 0.0F));
        modelPartData.addChild("leg6",
                        ModelPartBuilder.create().uv(44, 52).cuboid(-8.0F, 0.0F, -1.0F, 8.0F, 2.0F, 2.0F),
                        ModelTransform.pivot(4.0F, 14.0F, 0.5F))
                .addChild("leg1_r6",
                        ModelPartBuilder.create().uv(44, 48).cuboid(-8.0F, 0.0F, -1.0F, 8.0F, 2.0F, 2.0F),
                        ModelTransform.pivot(-8.0F, 2.0F, 0.0F));
        modelPartData.addChild("leg7",
                        ModelPartBuilder.create().uv(44, 52).cuboid(-8.0F, 0.0F, -1.0F, 8.0F, 2.0F, 2.0F),
                        ModelTransform.pivot(4.0F, 14.0F, 0.0F))
                .addChild("leg1_r7",
                        ModelPartBuilder.create().uv(44, 48).cuboid(-8.0F, 0.0F, -1.0F, 8.0F, 2.0F, 2.0F),
                        ModelTransform.pivot(-8.0F, 2.0F, 0.0F));
        modelPartData.addChild("leg8",
                        ModelPartBuilder.create().uv(44, 52).cuboid(-8.0F, 0.0F, -1.0F, 8.0F, 2.0F, 2.0F),
                        ModelTransform.pivot(4.0F, 14.0F, -0.25F))
                .addChild("leg1_r8",
                        ModelPartBuilder.create().uv(44, 48).cuboid(-8.0F, 0.0F, -1.0F, 8.0F, 2.0F, 2.0F),
                        ModelTransform.pivot(-8.0F, 2.0F, 0.0F));
        modelPartData.addChild("head",
                ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F)
                        .uv(32, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F,new Dilation(0.5F)),
                ModelTransform.pivot(0.0F, 1.0F, -4.0F));
        modelPartData.addChild("right_arm",
                ModelPartBuilder.create().uv(38, 16).cuboid(-2.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F)
                        .uv(38, 32).cuboid(-2.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F,new Dilation(0.25F)),
                ModelTransform.pivot(-5.0F, 3.0F, -4.0F));
        modelPartData.addChild("left_arm",
                ModelPartBuilder.create().uv(0, 16).cuboid(-1.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F)
                        .uv(0, 32).cuboid(-1.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new Dilation(0.25F)),
                ModelTransform.pivot(5.0F, 3.0F, -4.0F));

        return TexturedModelData.of(modelData,64,128);
    }
    public static TexturedModelData getTexturedModelDataIA() {
        return TexturedModelData.of(BipedEntityModel.getModelData(new Dilation(0.5F),0.0F),64,32);
    }
    public static TexturedModelData getTexturedModelDataOA() {
        return TexturedModelData.of(BipedEntityModel.getModelData(new Dilation(1.0F),0.0F),64,32);
    }

    protected Iterable<ModelPart> getBodyParts() {
        return ImmutableList.of(this.body, this.rightArm, this.leftArm,this.leg1,this.leg2,this.leg3, this.leg4,this.leg5,
                this.leg6,this.leg7,this.leg8);
    }
    protected Iterable<ModelPart> getHeadParts() {
        return  ImmutableList.of(this.head);
    }
    public void setAngles(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
        super.setAngles(p_225597_1_, p_225597_2_, p_225597_3_, p_225597_4_, p_225597_5_, p_225597_6_);
        head.setPivot(0.0F, 1.0F, -2.5F);
        rightArm.setPivot(-5.0F, 3.0F, -4.0F);
        leftArm.setPivot(5.0F, 3.0F, -4.0F);
        body.setPivot(1.0F, 15.0F, 9.0F);
        this.leg1.pivotY = 13.0F;
        this.leg2.pivotY = 13.0F;
        this.leg3.pivotY = 13.0F;
        this.leg4.pivotY = 13.0F;
        this.leg5.pivotY = 13.0F;
        this.leg6.pivotY = 13.0F;
        this.leg7.pivotY = 13.0F;
        this.leg8.pivotY = 13.0F;
    }
    public void setRotationAngle(ModelPart modelRenderer, float x, float y, float z) {
        modelRenderer.pitch = x;
        modelRenderer.yaw = y;
        modelRenderer.roll = z;
    }

    public void render(MatrixStack p_225598_1_, VertexConsumer p_225598_2_, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
        if (true) {
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
}
