package xyz.zuperito.galileo.modules;

public abstract class Module {
    public final String name, description;
    public final ModuleType moduleType;
    protected boolean enabled = false;

    public Module(String name, String description, ModuleType moduleType) {
        this.name = name;
        this.description = description;
        this.moduleType = moduleType;
    }

    public final boolean isEnabled() {
        return enabled;
    }

    public final void setEnabled(Boolean new_enabled) {
        if (this.enabled == new_enabled) {
            // if it's already enabled/disabled, don't do anything
            return;
        }

        this.enabled = new_enabled;
        if (this.enabled) {
            onEnable();
        } else {
            onDisable();
        }
    }

    public abstract void onEnable();
    public abstract void onDisable();
    public abstract void onTick();

}
