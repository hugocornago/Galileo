package xyz.zuperito.galileo.modules;

import net.minecraft.text.Text;

public abstract class ModuleOption<T> {
    private T value;
    public static String message;

    public ModuleOption(String message, T defaultValue) {
        this.message = message;
        this.value = defaultValue;
    }
    public abstract void onClick();
    public T getValue() {
        updateValue();
        return value;
    };
    public void setValue(T value) {
        this.value = value;
    };

    public abstract void updateValue();

    public Text getMessage() {
        return Text.of(String.format("%s: %s", message, getValue()));
    }
}
