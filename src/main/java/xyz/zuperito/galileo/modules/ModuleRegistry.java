package xyz.zuperito.galileo.modules;

import net.minecraft.util.Util;

import java.util.ArrayList;
import java.util.List;

public class ModuleRegistry {
    private static final List<Module> modules = Util.make(
            new ArrayList<>(), ModuleRegistry::init_modules
    );

    private static void init_modules(List<Module> modules) {
        modules.add(new FlyModule());
    }

    public static List<Module> getModules() { return modules; }
}
