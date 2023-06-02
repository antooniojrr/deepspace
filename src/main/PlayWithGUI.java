package main;

import View.DeepSpaceView;
import View.GUI.MainWindow;
import controller.Controller;
import deepspace.GameUniverse;

/**
 * @brief Se lanza la interfaz de texto (GUI) del juego. El procedimiento es el siguiente:
 * 1. Crear una nueva Vista (DeepSpaceView) y asociarla a la interfaz gráfica (MainWindow)
 * 2. Crear una nueva Instancia de GameUniverse
 * 3. Inicializar el controlador del juego
 * 4. Asociar al controlador el modelo (GameUniverse) y la interfaz de texto (DeepSpaceView)
 * 5. Iniciar partida llamando al Controller
 */
public class PlayWithGUI {
    public static void main(String[] args) {
        GameUniverse game = new GameUniverse();
        DeepSpaceView view = MainWindow.getInstance();
        Controller controller = Controller.getInstance();
        controller.setModelView(game, view);
        controller.start();
    }
    
}
