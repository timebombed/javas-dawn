package edu.usd;

import java.nio.*;
import java.util.ArrayList;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

import org.lwjgl.glfw.*;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;
import org.lwjgl.Version;

public class GameWindow {
    Menu currentMenu;
    private long window;
    private boolean fullscreen = false;
    int mouseX, mouseY;

    public void setKeyCallbacks() {
        //set up any key callbacks we need for special functionality, e.g. closing window, setting fullscreen
        glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
            // Close window
            if (key == GLFW_KEY_F4 && action == GLFW_PRESS)
                glfwSetWindowShouldClose(window, true);
            // Toggle Fullscreen
            else if (key == GLFW_KEY_ESCAPE && action == GLFW_PRESS)
                toggleFullscreen();
            // Backspace is not handled like the characters, so we need to handle it here
            else if (key == GLFW_KEY_BACKSPACE && action == GLFW_PRESS)
                currentMenu.backspaceEvent();
        });

        //set up cursor pos callback for UI
        glfwSetCursorPosCallback(window, (window, xpos, ypos) -> {
            mouseX = (int)xpos;
            mouseY = (int)ypos;
        });

        glfwSetMouseButtonCallback(window, (window, button, action, mods) -> {
            if (button == GLFW_MOUSE_BUTTON_1 && action == GLFW_PRESS) {
                //call the click handler for the current menu
                currentMenu.clickEvent(mouseX, mouseY);
            } else if (button == GLFW_MOUSE_BUTTON_1 && action == GLFW_RELEASE) {
                currentMenu.unclickEvent();
            }
        });

        GLFW.glfwSetScrollCallback(window, new GLFWScrollCallback() {
            @Override public void invoke (long win, double dx, double dy) {
                currentMenu.scrollEvent(dy, mouseX, mouseY);
            }
        });

        GLFW.glfwSetCharCallback(window, (window, codepoint) -> {
            currentMenu.textInputEvent((char)codepoint);
        });
    }

    public void windowLoop() {
        // Run the rendering loop until the user has attempted to close
        // the window or has pressed the F4 key in case we need to force quit.
        while ( !glfwWindowShouldClose(window) ) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer

            //------------------------GAME LOOP CODE-----------------------
            currentMenu.renderSprites();
            currentMenu.updateUI(mouseX, mouseY);
            currentMenu.update();

            // handle menu related events
            menuEventHandler(currentMenu.getWindowEvents());
            //----------------------------------------------------------

            glfwSwapBuffers(window); // swap the color buffers
            // Poll for window events. The key callback above will only be
            // invoked during this call.
            glfwPollEvents();
        }

        System.out.println("Close Window");

        // Free the window callbacks and destroy the window
        glfwFreeCallbacks(window);
        glfwDestroyWindow(window);

        // Terminate GLFW and free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    public void menuEventHandler(ArrayList<String> events) {
        Menu switchTo = null;

        for (String event : events) {
            // parse the event
            String eventKey;
            String[] eventParameters = {};
            if (event.contains(":")) {
                eventKey = event.split(":")[0];
                eventParameters = event.split(":")[1].split(",");
            } else {
                eventKey = event;
            }

            // switch menus or exit the program
            if (eventKey.equals("switchMenu")) {
                System.out.println("switchMenu event: " + eventParameters[0]);
                if (eventParameters[0].equals("main")) {
                    switchTo = new MainMenu();
                } else if (eventParameters[0].equals("save")) {
                    switchTo = new SaveMenu();
                } else if (eventParameters[0].equals("create")) {
                    if (eventParameters[1].equals("new")) {
                        // if we are creating a new save
                        switchTo = new CharacterCreationMenu();
                    } else if (eventParameters[1].equals("load")) {
                        // if we are loading an existing file
                        switchTo = new CharacterCreationMenu(eventParameters[2]);
                    }
                } else if (eventParameters[0].equals("settings")) {
                    switchTo = new SettingsMenu();
                }
                // call an unclickEvent when we are switching to a new menu so that buttons aren't misclicked
                switchTo.unclickEvent();
            } else if (eventKey.equals("exit")) {
                // close window on exit event
                glfwSetWindowShouldClose(window, true);
            }
        }

        //Once we are done handling gameWindow events, clear list so that they are not handled twice
        currentMenu.clearEvents();

        //Handle switchMenu events last as they will modify our currentMenu's event list
        if (switchTo != null) {
            currentMenu = switchTo;
        }
    }

    public void toggleFullscreen() {
        fullscreen = !fullscreen;
        GLFWVidMode monitorMode = glfwGetVideoMode(glfwGetPrimaryMonitor());

        if (fullscreen) {
            //set fullscreen
            glfwSetWindowMonitor(window, glfwGetPrimaryMonitor(), 0, 0, monitorMode.width(), monitorMode.height(), monitorMode.refreshRate());

            //TODO Scale viewport for fullscreen
//            glViewport(0, 0 , monitorMode.width(), monitorMode.height());
//            glOrtho(0, monitorMode.width(), monitorMode.height(), 0, 1, -1);
        } else {
            // set to windowed mode and place center of window to the center of the monitor
            glfwSetWindowMonitor(window, NULL, monitorMode.width()/2 - Constants.WINDOW_SIZE[0]/2, monitorMode.height()/2  - Constants.WINDOW_SIZE[1]/2, Constants.WINDOW_SIZE[0], Constants.WINDOW_SIZE[1], 0);
        }
    }

    /**
     * Runs any necessary initializations/setup for GLFW and GL which we use for creating windows and shapes
     */
    public void openWindow() {
        System.out.println("LWJGL v" + Version.getVersion());

        // Set up an error callback. The default implementation
        // will print the error message in System.err.
        GLFWErrorCallback.createPrint(System.err).set();

        // Initialize GLFW. Most GLFW functions will not work before doing this.
        if ( !glfwInit() )
            throw new IllegalStateException("Unable to initialize GLFW");

        // Configure GLFW
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation
        glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE); // the window will not be resizable

        // Create the window
        String WINDOW_TITLE = "JAVA'S DAWN";
        window = glfwCreateWindow(Constants.WINDOW_SIZE[0], Constants.WINDOW_SIZE[1], WINDOW_TITLE, NULL, NULL);
        if ( window == NULL )
            throw new RuntimeException("Failed to create the GLFW window");

        // Set up key callbacks. It will be called every time a key is pressed, repeated or released.
        setKeyCallbacks();

        // Get the thread stack and push a new frame
        try ( MemoryStack stack = stackPush() ) {
            IntBuffer pWidth = stack.mallocInt(1); // int*
            IntBuffer pHeight = stack.mallocInt(1); // int*

            // Get the window size passed to glfwCreateWindow
            glfwGetWindowSize(window, pWidth, pHeight);

            // Get the resolution of the primary monitor
            GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

            // Center the window
            glfwSetWindowPos(
                    window,
                    (vidmode.width() - pWidth.get(0)) / 2,
                    (vidmode.height() - pHeight.get(0)) / 2
            );
        } // the stack frame is popped automatically

        // Make the OpenGL context current
        glfwMakeContextCurrent(window);
        // Enable v-sync
        glfwSwapInterval(1);

        // Make the window visible
        glfwShowWindow(window);

        // This line is critical for LWJGL's interoperation with GLFW's
        // OpenGL context, or any context that is managed externally.
        // LWJGL detects the context that is current in the current thread,
        // creates the GLCapabilities instance and makes the OpenGL
        // bindings available for use.
        GL.createCapabilities();

        // set clear color
        glClearColor(0f, 0f, 0f, 0f);

        // Configure GL
        glEnable(GL_TEXTURE_2D);
        glViewport(0, 0 , Constants.WINDOW_SIZE[0], Constants.WINDOW_SIZE[1]);
        glOrtho(0, Constants.WINDOW_SIZE[0], Constants.WINDOW_SIZE[1], 0, 1, -1);
        glMatrixMode(GL_MODELVIEW);

        glTexEnvi(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_REPLACE);

        // Once OpenGL is set up, set our current menu to the Main Menu, before running our main loop
        currentMenu = new MainMenu();
    }
}
