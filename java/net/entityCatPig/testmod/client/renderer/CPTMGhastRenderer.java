package net.entityCatPig.testmod.client.renderer;

import net.entityCatPig.testmod.TestMod;
import net.entityCatPig.testmod.client.model.CPTMGhastModel;
import net.entityCatPig.testmod.init.ModEntityTypes;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.mob.GhastEntity;
import net.minecraft.util.Identifier;




public class CPTMGhastRenderer extends BipedEntityRenderer<GhastEntity, CPTMGhastModel<GhastEntity>> {
    private static final Identifier SKELETON_LOCATION = new Identifier(TestMod.MOD_ID,"textures/entity/cptmghast.png");
    private static final Identifier SHOOTING_LOCATION = new Identifier(TestMod.MOD_ID,"textures/entity/cptmghastshooting.png");

    public CPTMGhastRenderer(EntityRendererFactory.Context p_i46143_1_) {
        super(p_i46143_1_, new CPTMGhastModel<>(p_i46143_1_.getPart(ModEntityTypes.MODEL_GHAST_LAYER)), 1.5F);
    }

    public Identifier getTexture(GhastEntity p_110775_1_) {
        return p_110775_1_.isShooting() ? SHOOTING_LOCATION : SKELETON_LOCATION;
    }
}
