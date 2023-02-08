package net.entityCatPig.testmod.client.model;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.entity.mob.WitchEntity;


public class CPTMWitchModel<T extends WitchEntity> extends PlayerEntityModel<T> {
    public CPTMWitchModel(ModelPart mdp) {
        this(mdp, true);
    }
    public ModelPart Nhat;
    public ModelPart Nhat1;
    public ModelPart Nhat2;
    public ModelPart Nhat3;
    public CPTMWitchModel(ModelPart root, boolean p_i46303_2_) {
        super(root,p_i46303_2_);
        this.Nhat = root.getChild("head").getChild("nhat");
        this.Nhat1 = root.getChild("head").getChild("nhat").getChild("nhat1");
        this.Nhat2 = root.getChild("head").getChild("nhat").getChild("nhat1").getChild("nhat2");
        this.Nhat3 = root.getChild("head").getChild("nhat").getChild("nhat1").getChild("nhat2").getChild("nhat3");
        Nhat1.pitch = -0.05235988F;
        Nhat1.roll = 0.02617994F;
        Nhat2.pitch = -0.10471976F;
        Nhat2.roll = 0.05235988F;
        Nhat3.pitch = -0.20943952F;
        Nhat3.roll = 0.10471976F;
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = PlayerEntityModel.getTexturedModelData(new Dilation(0.0F),true);
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.getChild("head").addChild("nhat",
                ModelPartBuilder.create().uv(0, 98)
                        .cuboid(0.0F, 0.0F, 0.0F, 14.0F, 2.0F, 14.0F, new Dilation(0.0F)),
                ModelTransform.pivot(-7.0F, -8.03125F, -7.0F))
                .addChild("nhat1",
                        ModelPartBuilder.create().uv(0, 76)
                                .cuboid(0.0F, 0.0F, 0.0F, 7.0F, 4.0F, 7.0F, new Dilation(0.0F)),
                        ModelTransform.pivot(3.75F, -4.0F, 4.0F))
                .addChild("nhat2",
                        ModelPartBuilder.create().uv(0, 87)
                                .cuboid(0.0F, 0.0F, 0.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F)),
                        ModelTransform.pivot(1.75F, -4.0F, 2.0F))
                .addChild("nhat3",
                        ModelPartBuilder.create().uv(0, 95)
                                .cuboid(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.25F)),
                        ModelTransform.pivot(1.75F, -2.0F, 2.0F));
        return TexturedModelData.of(modelData,64,128);
    }
    public static TexturedModelData getTexturedModelDataIA() {
        return TexturedModelData.of(BipedEntityModel.getModelData(new Dilation(0.5F),0.0F),64,32);
    }
    public static TexturedModelData getTexturedModelDataOA() {
        return TexturedModelData.of(BipedEntityModel.getModelData(new Dilation(1.0F),0.0F),64,32);
    }

    public void setAngles(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
        super.setAngles(p_225597_1_, p_225597_2_, p_225597_3_, p_225597_4_, p_225597_5_, p_225597_6_);
    }
}
