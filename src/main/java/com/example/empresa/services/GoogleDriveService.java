package com.example.empresa.services;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

@Service
public class GoogleDriveService {

    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    
    private CredentialsRTA credentials = new CredentialsRTA();
    private String jsonCredentialsContent = credentials.getCredeString();

    @Value("${google.drive.parent.folder-id}")
    private String parentFolderId;

    public String uploadImageToDrive(BufferedImage image, String documentName, String cityName) throws IOException, GeneralSecurityException {
        Drive driveService = getDriveService(jsonCredentialsContent);
        String folderId = createOrGetCityFolder(driveService, cityName);
        return uploadFile(driveService, folderId, image, documentName);
    }

    private Drive getDriveService(String jsonCredentialsContent) throws GeneralSecurityException, IOException {
        ByteArrayInputStream credentialsStream = new ByteArrayInputStream(jsonCredentialsContent.getBytes(StandardCharsets.UTF_8));
        GoogleCredential credential = GoogleCredential.fromStream(credentialsStream)
                .createScoped(Collections.singleton(DriveScopes.DRIVE_FILE));
        return new Drive.Builder(GoogleNetHttpTransport.newTrustedTransport(), JSON_FACTORY, credential)
                .setApplicationName("Spring API Google Drive")
                .build();
    }

    private String createOrGetCityFolder(Drive driveService, String cityName) throws IOException {
        String dateFolderId = getOrCreateFolder(driveService,
                new SimpleDateFormat("dd-MM-yyyy").format(new Date()),
                parentFolderId);
        return getOrCreateFolder(driveService, cityName, dateFolderId);
    }

    private String getOrCreateFolder(Drive driveService, String folderName, String parentId) throws IOException {
        FileList result = driveService.files().list()
                .setQ(String.format("'%s' in parents and mimeType = 'application/vnd.google-apps.folder' and name = '%s'", parentId, folderName))
                .setSpaces("drive")
                .setFields("files(id)")
                .execute();

        if (!result.getFiles().isEmpty()) {
            return result.getFiles().get(0).getId();
        }

        File folderMetadata = new File()
                .setName(folderName)
                .setMimeType("application/vnd.google-apps.folder")
                .setParents(Collections.singletonList(parentId));

        File folder = driveService.files().create(folderMetadata)
                .setFields("id")
                .execute();

        return folder.getId();
    }

    private String uploadFile(Drive driveService, String folderId, BufferedImage image, String documentName) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "png", outputStream);
        byte[] imageData = outputStream.toByteArray();

        File fileMetadata = new File()
                .setName(documentName + ".png")
                .setMimeType("image/png")
                .setParents(Collections.singletonList(folderId));

        File uploadedFile = driveService.files().create(fileMetadata,
                new ByteArrayContent("image/png", imageData))
                .setFields("id, webViewLink")
                .execute();

        driveService.permissions().create(uploadedFile.getId(),
                new com.google.api.services.drive.model.Permission()
                        .setType("anyone")
                        .setRole("reader"))
                .execute();

        return uploadedFile.getWebViewLink();
    }
}

