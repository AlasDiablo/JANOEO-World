package fr.alasdiablo.janoeo.worlds;

import fr.alasdiablo.janoeo.worlds.util.ClientProxy;
import fr.alasdiablo.janoeo.worlds.util.CommonProxy;
import fr.alasdiablo.janoeo.worlds.util.ModSetup;
import fr.alasdiablo.janoeo.worlds.util.Registries;
import fr.alasdiablo.janoeo.worlds.world.gen.Features;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Registries.MOD_ID)
public class World {

    public static final CommonProxy PROXY = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);

    public static ModSetup setup = new ModSetup();

    public World() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::complete);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::initFeatures);
    }

    private void initFeatures(RegistryEvent.NewRegistry e) {
        Features.initFeatures();
    }

    private void setup(final FMLCommonSetupEvent event) {
        setup.initFlammable();
        setup.initStrippable();
        setup.initWorldGen();
    }

    private void complete(final FMLLoadCompleteEvent event) {
        PROXY.init();
    }
}
