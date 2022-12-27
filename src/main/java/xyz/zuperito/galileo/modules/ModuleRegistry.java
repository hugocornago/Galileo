package xyz.zuperito.galileo.modules;

import net.minecraft.util.Util;
import xyz.zuperito.galileo.modules.player.FlyModule;
import xyz.zuperito.galileo.modules.player.FullBrightnessModule;

import java.util.ArrayList;
import java.util.List;

public class ModuleRegistry {
    private static final List<Module> modules = Util.make(
            new ArrayList<>(), ModuleRegistry::init_modules
    );

    private static void init_modules(List<Module> modules) {
        modules.add(new FlyModule());
        modules.add(new FullBrightnessModule());
    }

    public static List<Module> getModules() { return modules; }
    public static Module getModulesByName(String name) {
        for (Module mod : getModules()) {
            if (mod.name.equalsIgnoreCase(name)) {
                return mod;
            }
        }
        return null;
    }
}
