package renderEngine;

import org.lwjgl.glfw.*;
import org.lwjgl.opengl.GL;
import static org.lwjgl.opengl.GL11.*;

import static org.lwjgl.glfw.GLFW.*;

/**
 * Created by fjkb1u17 on 13/11/17.
 */
public class DisplayManager {
    public static final int WIDTH = 1080;
    public static final int HEIGHT = 720;
    private static long window;

    public static void createDisplay(){
        if(!glfwInit()){
            throw new IllegalStateException("Failed to init glfw window");
        }

        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        GLFW.glfwDefaultWindowHints();
        GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MAJOR, 3);
        GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MINOR, 0);

        /* Create window*/
        window = glfwCreateWindow(WIDTH, HEIGHT, "Hello World !", 0, 0);
        if (window == 0){
            throw new IllegalStateException("Failed to create window");
        }

        GLFWVidMode videoMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        glfwSetWindowPos(window, videoMode.width()/2, videoMode.height()/2);

        glfwShowWindow(window);
        /* Enables context for window */
        glfwMakeContextCurrent(window);

        GL.createCapabilities();
    }

    public static boolean isCloseRequested(){
        return glfwWindowShouldClose(window);
    }

    public static void updateDisplay(){
        GLFW.glfwSwapInterval(1);
        glfwSwapBuffers(window);
        glfwPollEvents();
    }

    public static void closeDisplay(){
        glfwDestroyWindow(window);
        glfwTerminate();
    }
}
