package me.brett.tutorial.module.impl.movement;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import me.brett.tutorial.event.EventUpdate;
import me.brett.tutorial.module.Module;
import me.brett.tutorial.module.ModuleCategory;
import org.lwjgl.input.Keyboard;

public class ModuleSprint extends Module {
    public ModuleSprint() {
        super("Sprint", "Sets the player as sprinting constantly", ModuleCategory.MOVEMENT, Keyboard.KEY_F);
    }

    @Subscribe
    public void onUpdate(EventUpdate event) {
        mc.gameSettings.keyBindSprint.pressed = true;
    }


}
