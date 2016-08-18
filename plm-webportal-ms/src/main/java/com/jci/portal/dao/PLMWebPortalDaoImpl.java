package com.jci.portal.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.microsoft.windowsazure.services.blob.client.CloudBlob;
import com.microsoft.windowsazure.services.blob.client.CloudBlobClient;
import com.microsoft.windowsazure.services.blob.client.CloudBlobContainer;
import com.microsoft.windowsazure.services.blob.client.ListBlobItem;
import com.microsoft.windowsazure.services.core.storage.CloudStorageAccount;
import com.microsoft.windowsazure.services.core.storage.StorageException;

@Repository
public class PLMWebPortalDaoImpl implements PLMWebPortalDao{
	
	private static final Logger logger = LoggerFactory.getLogger(PLMWebPortalDaoImpl.class);
	CloudBlobContainer blobContainer = null;

	public String getMessage() {
		logger.info("get Txn_id successfull");

		return null;

	}

	public CloudBlobClient getBlobClientReference()
			throws RuntimeException, IOException, IllegalArgumentException, URISyntaxException, InvalidKeyException {

		// Retrieve the connection string
		Properties prop = new Properties();
		try {
			InputStream propertyStream = PLMWebPortalDaoImpl.class.getClassLoader()
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
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws URISyntaxException
	 * @throws StorageException
	 */

	@SuppressWarnings("null")
	public boolean createAzureBlobIfNotExists(CloudBlobClient blobClient, String azureStorageBlobName)
			throws FileNotFoundException, IOException, StorageException, URISyntaxException {
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
		}
		return true;
	}

	@Override
	public File getXml() {

		File file = null;
		try {
			CloudBlobClient cloudBlobClient = getBlobClientReference();
			createAzureBlobIfNotExists(cloudBlobClient, "erpconnblob");
			for (ListBlobItem blobItem : blobContainer.listBlobs()) {
				// If the item is a blob, not a virtual directory.
				if (blobItem instanceof CloudBlob) {
					// Download the item and save it to a file with the same
					// name.
					CloudBlob blob = (CloudBlob) blobItem;
					//Object txnid;
					file = new File(blob.getName());
					FileOutputStream fos = new FileOutputStream(file);
					blob.download(fos);
				}
			}
		} catch (StorageException | IOException | InvalidKeyException | RuntimeException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return file;
	}


}
