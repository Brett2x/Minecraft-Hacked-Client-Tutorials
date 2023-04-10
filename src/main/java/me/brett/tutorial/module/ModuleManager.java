package me.brett.tutorial.module;

import org.reflections.Reflections;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ModuleManager {

    HashMap<Class<? extends Module>, Module> modules = new LinkedHashMap<>();

    public void init() {
        new Reflections("me.brett.tutorial.module.impl").getSubTypesOf(Module.class).forEach(module -> {
            try {
                modules.put(module, module.newInstance());
            } catch (InstantiationException | IllegalAccessException ignored) {
            }
        });
    }

    public Collection<Module> getModules() {
        return modules.values();
    }
}
