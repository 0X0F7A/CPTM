package net.entityCatPig.testmod.client.renderer.layers;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.entityCatPig.testmod.TestMod;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.SynchronousResourceReloader;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.village.VillagerData;
import net.minecraft.village.VillagerDataContainer;
import net.minecraft.village.VillagerProfession;
import net.minecraft.village.VillagerType;

public class CPTMVillagerLevelPendantLayer<T extends LivingEntity & VillagerDataContainer, M extends EntityModel<T> > extends FeatureRenderer<T, M> implements SynchronousResourceReloader {
    private static final Int2ObjectMap<Identifier> LEVEL_TO_ID = Util.make(new Int2ObjectOpenHashMap<>(), (p_215348_0_) -> {
        p_215348_0_.put(1, new Identifier("stone"));
        p_215348_0_.put(2, new Identifier("iron"));
        p_215348_0_.put(3, new Identifier("gold"));
        p_215348_0_.put(4, new Identifier("emerald"));
        p_215348_0_.put(5, new Identifier("diamond"));
    });
    private final String path;

    public CPTMVillagerLevelPendantLayer(FeatureRendererContext<T, M> p_i50955_1_, String p_i50955_3_) {//, IReloadableResourceManager p_i50955_2_
        super(p_i50955_1_);
        this.path = p_i50955_3_;
    }

    public void render(MatrixStack p_225628_1_, VertexConsumerProvider p_225628_2_, int p_225628_3_, T p_225628_4_, float p_225628_5_, float p_225628_6_, float p_225628_7_, float p_225628_8_, float p_225628_9_, float p_225628_10_) {
        if (!p_225628_4_.isInvisible()) {
            VillagerData villagerdata = p_225628_4_.getVillagerData();
            VillagerType villagertype = villagerdata.getType();
            VillagerProfession villagerprofession = villagerdata.getProfession();
            M m = this.getContextModel();
            Identifier resourcelocation = this.getIdentifier("type", Registry.VILLAGER_TYPE.getId(villagertype));
            renderModel(m, resourcelocation, p_225628_1_, p_225628_2_, p_225628_3_, p_225628_4_, 1.0F, 1.0F, 1.0F);
            if (villagerprofession != VillagerProfession.NONE && !p_225628_4_.isBaby()) {
                Identifier resourcelocation1 = this.getIdentifier("profession", Registry.VILLAGER_PROFESSION.getId(villagerprofession));
                renderModel(m, resourcelocation1, p_225628_1_, p_225628_2_, p_225628_3_, p_225628_4_, 1.0F, 1.0F, 1.0F);
                if (villagerprofession != VillagerProfession.NITWIT) {
                    Identifier resourcelocation2 = this.getIdentifier("profession_level", LEVEL_TO_ID.get(MathHelper.clamp(villagerdata.getLevel(), 1, LEVEL_TO_ID.size())));
                    renderModel(m, resourcelocation2, p_225628_1_, p_225628_2_, p_225628_3_, p_225628_4_, 1.0F, 1.0F, 1.0F);
                }
            }

        }
    }

    private Identifier getIdentifier(String p_215351_1_, Identifier p_215351_2_) {
        return new Identifier(TestMod.MOD_ID, "textures/entity/" + this.path + "/" + p_215351_1_ + "/" + p_215351_2_.getPath() + ".png");
    }

    public void reload(ResourceManager p_195410_1_) {
    }
}
