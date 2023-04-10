package me.brett.tutorial.module;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import me.brett.tutorial.Tutorial;
import net.minecraft.client.Minecraft;

public class Module {

    String name, description;
    ModuleCategory category;
    int key;
    boolean enabled;
    protected Minecraft mc = Minecraft.getMinecraft();

    public Module(String name, String description, ModuleCategory category, int key) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.key = key;
    }


    public String getName() {
        return name;
    }

    public ModuleCategory getCategory() {
        return category;
    }

    public int getKey() {
        return key;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void onEnable() {
        Tutorial.getInstance().eventBus.register(this);
    }

    public void onDisable() {
        Tutorial.getInstance().eventBus.unregister(this);
    }


    public void toggle() {
        enabled = !enabled;
        if(enabled) {
            onEnable();
        } else {
            onDisable();
        }
    }

}
