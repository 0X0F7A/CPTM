package net.entityCatPig.testmod.client.model;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.PhantomEntity;
import net.minecraft.util.math.MathHelper;


public class CPTMPhantomModel<T extends PhantomEntity> extends PlayerEntityModel<T> {
    public CPTMPhantomModel(ModelPart mdp) {
        this(mdp, true);
    }
    public ModelPart leftWingBase;
    public ModelPart leftWingTip;
    public ModelPart rightWingBase;
    public ModelPart rightWingTip;

    public CPTMPhantomModel(ModelPart root, boolean p_i46303_2_) {
        super(root,p_i46303_2_);
        this.child = false;
        this.leftWingBase = root.getChild("leftwingbase");
        this.leftWingTip = root.getChild("leftwingbase").getChild("leftwingtip");
        this.rightWingBase = root.getChild("rightwingbase");
        this.rightWingTip = root.getChild("rightwingbase").getChild("rightwingtip");
        this.leftWingBase.roll = 0.1F;
        this.leftWingTip.roll = 0.1F;
        this.rightWingBase.roll = -0.1F;
        this.rightWingTip.roll = -0.1F;
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = PlayerEntityModel.getTexturedModelData(new Dilation(0.0F),true);
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild("leftwingbase",
                ModelPartBuilder.create().uv(0, 76)
                        .cuboid(0.0F, 0.0F, 0.0F, 6.0F, 1.0F, 9.0F, new Dilation(0.0F)),
                ModelTransform.pivot(2.0F, -2.0F, -8.0F))
                .addChild("leftwingtip",
                ModelPartBuilder.create().uv(0, 64)
                        .cuboid(0.0F, 0.0F, 0.0F, 13.0F, 1.0F, 9.0F, new Dilation(0.0F)),
                ModelTransform.pivot(6.0F, 0.0F, 0.0F));
        modelPartData.addChild("rightwingbase",
                        ModelPartBuilder.create().uv(0, 76)
                                .cuboid(-6.0F, 0.0F, 0.0F, 6.0F, 1.0F, 9.0F,true),
                        ModelTransform.pivot(-3.0F, -2.0F, -8.0F))
                .addChild("rightwingtip",
                        ModelPartBuilder.create().uv(0, 64)
                                .cuboid(-13.0F, 0.0F, 0.0F, 13.0F, 1.0F, 9.0F, true),
                        ModelTransform.pivot(-6.0F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData,64,128);
    }
    public static TexturedModelData getTexturedModelDataIA() {
        return TexturedModelData.of(BipedEntityModel.getModelData(new Dilation(0.5F),0.0F),64,32);
    }
    public static TexturedModelData getTexturedModelDataOA() {
        return TexturedModelData.of(BipedEntityModel.getModelData(new Dilation(1.0F),0.0F),64,32);
    }

    public void render(MatrixStack p_225598_1_, VertexConsumer p_225598_2_, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
        p_225598_1_.push();
        float f = 1.5F / 2.0F;
        p_225598_1_.scale(f, f, f);
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
    }

    protected Iterable<ModelPart> getHeadParts() {
        return Iterables.concat(super.getHeadParts(), ImmutableList.of(this.hat,this.leftWingBase,this.rightWingBase));
    }
    public void setAngles(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
        this.riding = false;
        super.setAngles(p_225597_1_, p_225597_2_, p_225597_3_, p_225597_4_, p_225597_5_, p_225597_6_);
        this.head.pitch = this.head.pitch - 0.7F - p_225597_1_.getPitch()/180.0F*3.1415F;
        this.hat.copyTransform(this.head);

        this.leftWingBase.setPivot(3.0F, 0.5F, 2.0F);
        this.rightWingBase.setPivot(-3.0F, 0.5F, 2.0F);
        float f = ((float)(p_225597_1_.getId() * 3) + p_225597_4_) * 0.13F;
        this.rightWingBase.pitch = -1.57F;
        this.leftWingBase.pitch = -1.57F;

        this.leftWingBase.yaw = MathHelper.cos(f) * 16.0F * ((float)Math.PI / 180F);
        this.leftWingTip.roll = MathHelper.cos(f) * 16.0F * ((float)Math.PI / 180F);
        this.rightWingBase.yaw = -this.leftWingBase.yaw;
        this.rightWingTip.roll = -this.leftWingTip.roll;
    }
}