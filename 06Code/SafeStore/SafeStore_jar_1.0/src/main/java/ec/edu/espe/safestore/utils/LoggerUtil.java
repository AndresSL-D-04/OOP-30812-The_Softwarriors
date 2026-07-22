/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.safestore.utils;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
import java.io.IOException;
import java.util.logging.*;

public class LoggerUtil {

    private static final Logger logger = Logger.getLogger("FarmLogger");

    static {
        try {

            System.out.println("CREANDO ARCHIVO LOG");

            FileHandler fileHandler = new FileHandler("farm_log.txt", true);

            fileHandler.setFormatter(new SimpleFormatter());

            logger.addHandler(fileHandler);
            logger.setUseParentHandlers(false);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Logger getLogger() {
        return logger;
    }
}