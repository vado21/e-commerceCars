/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author ricardocazares
 */
public class LoggerSingleton {

    private static Logger logger = null;

    public LoggerSingleton() {
        if (logger == null) {
            this.logger = new Logger();
        }
    }

    public void write(String msg) {
        this.logger.logInFile(msg);
    }
}
