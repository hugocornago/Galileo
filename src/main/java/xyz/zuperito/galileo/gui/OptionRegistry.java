package xyz.zuperito.galileo.gui;

import net.minecraft.util.Util;
import xyz.zuperito.galileo.modules.Module;
import xyz.zuperito.galileo.modules.ModuleOption;
import xyz.zuperito.galileo.modules.ModuleRegistry;

import java.util.ArrayList;
import java.util.List;

public class OptionRegistry {
    private static final List<ModuleOption> options = Util.make(
            new ArrayList<>(), OptionRegistry::init_options
    );

    private static void init_options(List<ModuleOption> options) {
        List<Module> modules = ModuleRegistry.getModules();
        for (Module module : modules) {
            options.add(new ModuleOption(module.name, module.isEnabled()) {
                @Override
                public void onClick() {
                    module.setEnabled(!module.isEnabled());
                }

                @Override
                public void updateValue() {
                    this.setValue(module.isEnabled());
                }
            });
        }
    }

    public static List<ModuleOption> getOptions() {
        return options;
    }
}
