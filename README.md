# Client Coding Tutorial

## Notes for readers

> One of the most useful ways that I have found to learn new things in general is to teach others about it, so I have decided to make a tutorial which can help others create their own minecraft hacked clients and potentially help them understand more about Minecraft and Java. I am not the best developer so if you find anything in this project which is done extremely poorly, feel free to let me know on discord, my handle is: brett#0437
> if you would like to listen to me explain how everything works, you can find the full tutorial starting with [this video](https://www.youtube.com/watch?v=NDZODa9IFXc).

# Coding your own modules

## Creating new events.

If you would like to add an event to this client, you can:

### Creating a class for the event
1. Create a new Class in the `me.brett.tutorial.event.impl` package.
2. Create every variable you would need in the event, a constructor with the correct parameters and relevant getters.

#### Example:

```java
package me.brett.tutorial.event.impl;

public class EventKey {

   int key;

   public EventKeyPressed(int key){
      this.key = key;
   }

   public int getKey() {
      return key;
   }
}
```

### Registering the event.
1. Go to the place in the minecraft source code where you want to register your event, for example, to register a key event (used as the example event above) , go to `net.minecraft.client.Minecraft.java:1800`.
2. Then above "if (k == 1)", please type `Tutorial.singleton.eventBus.post(new EventKeyPressed(k));`

#### Example:

```java
public class Minecraft implements IThreadListener, IPlayerUsage {
    public void runTick() throws IOException {
        // Line 1800
        Tutorial.singleton.eventBus.post(new EventKeyPressed(k));
        if (k == 1) {
            this.displayInGameMenu();
        }
    }
}
```

## Creating new modules

### Creating a class for the module
1. Create a new Class in the `me.brett.tutorial.module.impl` package and make it extend the `Module` class.
2. Create a constructor inside of this class, this constructor must specify the name, description, category and key of your new module, to set the key to not be hardcoded, you can set it to "0".

### Calling an event inside your module
1. Use the annotation `@Subscribe` inside of your class.
2. Create a method below the use of the `@Subscribe` annotation called `"on{EventName}" with the parameters as the event that you want to call.`
3. Write the code of the module inside of this method.

#### Example:
> You can use `Keyboard.KEY_<Key>` for the key in the constructor, or if you don't want to bind the module to a key, type `Keyboard.KEY_NONE` or `0`.\n
> Make sure that `Keyboard` is being imported from `org.lwjgl.input.Keyboard`.

```java
package me.brett.tutorial.module.impl.category;

import me.brett.tutorial.event.EventUpdate;
import me.brett.tutorial.module.Module;
import me.brett.tutorial.module.ModuleCategory;

public class ModuleExample extends Module {
	
    public ModuleExample() {
    	super("Example", "An example module for GitHub", ModuleCategory.MOVEMENT, key = 0);
    }


    @Subscribe
    public void onUpdate(EventUpdate event){
        //Code your custom module here.
    }
}
```




