/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author ricardocazares
 */
public class Logger implements Log {

    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private Lock writeLock = lock.writeLock();

    Logger() {

        File myObj = new File("./log.txt");
        try {
            myObj.createNewFile();
        } catch (Exception e) {

        }
    }

    @Override
    public void logInFile(String msg) {

        writeLock.lock();
        try {
            Files.write(Paths.get("./log.txt"), (msg + "\n").getBytes(), StandardOpenOption.APPEND);
        } catch (Exception e) {
            System.out.print("Error al escribir el archivo" + e.getMessage());
        } finally {
            writeLock.unlock();
        }
    }

}
