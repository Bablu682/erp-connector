package com.jci.jciPLMMQSubcriber.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.Properties;

import org.springframework.stereotype.Service;

import com.microsoft.windowsazure.services.blob.client.CloudBlobClient;
import com.microsoft.windowsazure.services.blob.client.CloudBlobContainer;
import com.microsoft.windowsazure.services.core.storage.CloudStorageAccount;
import com.microsoft.windowsazure.services.core.storage.StorageException;

@Service
public class AzureBlobStorageService {

	/**
	 * Validates the connection string and returns the storage blob client. The
	 * connection string must be in the Azure connection string format.
	 *
	 * @return The newly created createCloudBlobClient object
	 *
	 * @throws RuntimeException
	 * @throws IOException
	 * @throws URISyntaxException
	 * @throws IllegalArgumentException
	 * @throws InvalidKeyException
	 */
	public CloudBlobClient getBlobClientReference()
			throws RuntimeException, IOException, IllegalArgumentException, URISyntaxException, InvalidKeyException {

		// Retrieve the connection string
		Properties prop = new Properties();
		try {
			InputStream propertyStream = AzureBlobStorageService.class.getClassLoader()
					.getResourceAsStream("config.properties");
			if (propertyStream != null) {
				prop.load(propertyStream);
			} else {
				throw new RuntimeException();
			}
		} catch (RuntimeException | IOException e) {
			System.out.println("\nFailed to load config.properties file.");
			throw e;
		}

		CloudStorageAccount storageAccount;
		try {
			storageAccount = CloudStorageAccount.parse(prop.getProperty("azureBlobConnectionString"));
		} catch (IllegalArgumentException | URISyntaxException e) {
			System.out.println("\nConnection string specifies an invalid URI.");
			System.out.println("Please confirm the connection string is in the Azure connection string format.");
			throw e;
		} catch (InvalidKeyException e) {
			System.out.println("\nConnection string specifies an invalid key.");
			System.out.println("Please confirm the AccountName and AccountKey in the connection string are valid.");
			throw e;
		}

		return storageAccount.createCloudBlobClient();
	}

	/**
	 * This API will create a blob container if it does not exist
	 * 
	 * @param blobClient
	 * @param azureStorageBlobName
	 * @return
	 */

	@SuppressWarnings("null")
	public boolean createAzureBlobIfNotExists(CloudBlobClient blobClient, String azureStorageBlobName) {
		CloudBlobContainer blobContainer = null;
		try {
			blobContainer = blobClient.getContainerReference(azureStorageBlobName);
		} catch (URISyntaxException | StorageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (blobContainer == null) {
			System.out.println("Created new blob container since it does not exist");
			try {
				blobContainer.createIfNotExist();
				return true;
			} catch (StorageException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		} else {
			System.out.println("blob container already exists");
		}
		return true;

	}
}
