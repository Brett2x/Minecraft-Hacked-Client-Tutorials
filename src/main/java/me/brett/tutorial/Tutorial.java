package me.brett.tutorial;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import me.brett.tutorial.event.EventKey;
import me.brett.tutorial.module.Module;
import me.brett.tutorial.module.ModuleManager;
import org.lwjgl.opengl.Display;

public class Tutorial {

    private static Tutorial singleton;
    public String name = "Tutorial", version = "0.0.1";
    public ModuleManager moduleManager = new ModuleManager();
    public EventBus eventBus = new EventBus();

    public static Tutorial getInstance() {
        if(singleton == null) {
            singleton = new Tutorial();
        }
        return singleton;
    }

    public void init() {
        Display.setTitle(name + " Version: " + version);
        moduleManager.init();
        eventBus.register(this);
    }

    @Subscribe
    public void onKey(EventKey event) {
        moduleManager.getModules().forEach(module -> {
            if (module.getKey() == event.getKey()) {
                module.toggle();
            }
        });
    }

}
