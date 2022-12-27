package xyz.zuperito.galileo.gui;

import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.Selectable;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.text.Text;
import xyz.zuperito.galileo.Galileo;
import xyz.zuperito.galileo.modules.Module;
import xyz.zuperito.galileo.modules.ModuleOption;
import xyz.zuperito.galileo.modules.ModuleRegistry;

public class GuiScreen extends Screen {
    protected final Screen parent;
    public GuiScreen(Screen parent) {
        super(Text.of("GUI Screen"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        int i = 0;
        for (ModuleOption option : OptionRegistry.getOptions()) {
            this.addDrawableChild(new ButtonWidget(60, (i++ * 60), this.width - 120, 20, option.getMessage(), button -> {
                option.onClick();
                button.setMessage(option.getMessage());
            }));
            i++;
        }
    }

    @Override
    public void close() {
        this.client.setScreen(this.parent);
    }
}
