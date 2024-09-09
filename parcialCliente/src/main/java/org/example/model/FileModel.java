package org.example.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import org.example.shared.RMIInterfaces.FileService;

public class FileModel {
    private FileService fileService;

    public FileModel(FileService fileService) {
        this.fileService = fileService;
    }

    public boolean uploadFile(File file) {
        byte[] fileData = null;
        try {
            // Leer el archivo en un arreglo de bytes
            fileData = readFileToByteArray(file);
            // Enviar el archivo al servicio remoto
            fileService.uploadFile(file.getName(), fileData);
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private byte[] readFileToByteArray(File file) throws IOException {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            byte[] fileData = new byte[(int) file.length()];
            fileInputStream.read(fileData);
            return fileData;
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
