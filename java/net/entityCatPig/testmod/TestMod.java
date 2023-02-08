package net.entityCatPig.testmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.fabricmc.api.ModInitializer;

public class TestMod implements ModInitializer
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "testmod";

    @Override
    public void onInitialize() {
        // FabricDefaultAttributeRegistry.register(CPTMSKELETON,CPTMSkeletonEntity.createAttributes());
        LOGGER.debug("Hello World");
    }
}
