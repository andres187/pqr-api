/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uninorte.proyecto.musica;

import java.io.*;

import com.microsoft.azure.storage.*;
import com.microsoft.azure.storage.blob.*;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
/**
 *
 * @author abolivar
 */
public class Subir {
    public static final String storageConnectionString =
		"DefaultEndpointsProtocol=http;"
		+ "AccountName=prueba213;"
		+ "AccountKey=rOqQ/TfNdJEyCQOKpR1hn/J2B8Krl2SjXanWXZ/z7aMxAgqg2kgKkU6PCpoKPcNv6ijZhngWA7p+/YjLjWrT+A==";
    
    public void ejecutar() {
            try {
                CloudStorageAccount account = CloudStorageAccount.parse(storageConnectionString);
                CloudBlobClient serviceClient = account.createCloudBlobClient();

                // Container name must be lower case.
                CloudBlobContainer container = serviceClient.getContainerReference("lbhouse");
                container.createIfNotExists();

                // Upload an image file.
                CloudBlockBlob blob = container.getBlockBlobReference("image1.jpg");
                File sourceFile = new File("c:\\myimages\\image1.jpg");
                blob.upload(new FileInputStream(sourceFile), sourceFile.length());

                // Download the image file.
                File destinationFile = new File(sourceFile.getParentFile(), "image1Download.tmp");
                blob.downloadToFile(destinationFile.getAbsolutePath());
            }
            catch (FileNotFoundException fileNotFoundException) {
                System.out.print("FileNotFoundException encountered: ");
                System.out.println(fileNotFoundException.getMessage());
                System.exit(-1);
            }
            catch (StorageException storageException) {
                System.out.print("StorageException encountered: ");
                System.out.println(storageException.getMessage());
                System.exit(-1);
            }
            catch ( IOException | URISyntaxException | InvalidKeyException e) {
                System.out.print("Exception encountered: ");
                System.out.println(e.getMessage());
                System.exit(-1);
            }
    }
}
