package mcp.mobius.waila.gui.config.value;

import com.mojang.blaze3d.matrix.MatrixStack;
import mcp.mobius.waila.WailaClient;
import net.minecraft.client.gui.IGuiEventListener;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.text.TranslationTextComponent;

import java.util.function.Consumer;

public class OptionsEntryValueBoolean extends OptionsEntryValue<Boolean> {

    private final Button button;

    public OptionsEntryValueBoolean(String optionName, boolean value, Consumer<Boolean> save) {
        super(optionName, save);

        this.button = new Button(0, 0, 100, 20, new TranslationTextComponent(I18n.format("gui." + (value ? "yes" : "no"))), w -> {
            this.value = !this.value;
        });
        this.value = value;
    }

    @Override
    protected void drawValue(int entryWidth, int entryHeight, int x, int y, int mouseX, int mouseY, boolean selected, float partialTicks) {
        this.button.x = x + 135;
        this.button.y = y + entryHeight / 6;
        this.button.setMessage(new TranslationTextComponent(I18n.format("gui." + (value ? "yes" : "no"))));
        this.button.render(WailaClient.matrix, mouseX, mouseY, partialTicks); //TODO matrixstack
    }

    @Override
    public IGuiEventListener getListener() {
        return button;
    }
}
