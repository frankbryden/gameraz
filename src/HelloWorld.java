/**
 * Created by fjkb1u17 on 13/11/17.
 */
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.RawModel;
import renderEngine.Renderer;

public class HelloWorld {

    // The window handle
    private long window;

    public static void main(String[] args) {
        DisplayManager.createDisplay();

        Loader loader = new Loader();
        Renderer renderer = new Renderer();

        float[] vertices = {
                -0.5f, 0.5f, 0f,	//V0
                -0.5f, -0.5f, 0f,	//V1
                0.5f, -0.5f, 0f,	//V2
                0.5f, 0.5f, 0.0f	//V3
        };
        
        int[] indices = {
        		0, 1, 3,
        		3, 1, 2
        };
        
        RawModel model = loader.loadToVAO(vertices, indices);

        while (!DisplayManager.isCloseRequested()){
        	renderer.prepare();
        	
        	renderer.render(model);
        	
            DisplayManager.updateDisplay();
        }

        loader.cleanUp();
        DisplayManager.closeDisplay();
    }

}