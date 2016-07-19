package com.jci.jciPLMMQSubcriber.service;

import java.io.IOException;

import java.io.InputStream;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.Properties;

import org.springframework.stereotype.Service;

import com.jci.jciPLMMQSubcriber.domain.JCIASTSampleEntity;
import com.microsoft.windowsazure.services.core.storage.CloudStorageAccount;
import com.microsoft.windowsazure.services.core.storage.StorageException;
import com.microsoft.windowsazure.services.table.client.CloudTable;
import com.microsoft.windowsazure.services.table.client.CloudTableClient;
import com.microsoft.windowsazure.services.table.client.TableConstants;
import com.microsoft.windowsazure.services.table.client.TableOperation;
import com.microsoft.windowsazure.services.table.client.TableQuery;
import com.microsoft.windowsazure.services.table.client.TableQuery.Operators;
import com.microsoft.windowsazure.services.table.client.TableQuery.QueryComparisons;

@Service
public class AzureStorageTableService {

	/**
	 * Validates the connection string and returns the storage table client. The
	 * connection string must be in the Azure connection string format.
	 *
	 * @return The newly created CloudTableClient object
	 *
	 * @throws RuntimeException
	 * @throws IOException
	 * @throws URISyntaxException
	 * @throws IllegalArgumentException
	 * @throws InvalidKeyException
	 */
	public CloudTableClient getTableClientReference()
			throws RuntimeException, IOException, IllegalArgumentException, URISyntaxException, InvalidKeyException {

		// Retrieve the connection string
		Properties prop = new Properties();
		try {
			InputStream propertyStream = AzureStorageTableService.class.getClassLoader()
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
			storageAccount = CloudStorageAccount.parse(prop.getProperty("azureStorageTableConnectionString"));
		} catch (IllegalArgumentException | URISyntaxException e) {
			System.out.println("\nConnection string specifies an invalid URI.");
			System.out.println("Please confirm the connection string is in the Azure connection string format.");
			throw e;
		} catch (InvalidKeyException e) {
			System.out.println("\nConnection string specifies an invalid key.");
			System.out.println("Please confirm the AccountName and AccountKey in the connection string are valid.");
			throw e;
		}

		return storageAccount.createCloudTableClient();
	}

	/**
	 * This API will create a table if doesnot exist
	 * 
	 * @param tableClient
	 * @param azureStorageTableName
	 * @return
	 */

	@SuppressWarnings("null")
	public boolean createAzureTableIfNotExists(CloudTableClient tableClient, String azureStorageTableName) {
		CloudTable table = null;
		try {
			table = tableClient.getTableReference(azureStorageTableName);
		} catch (URISyntaxException | StorageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (table == null) {
			System.out.println("Created new table since it exist");
			try {
				table.createIfNotExist();
				return true;
			} catch (StorageException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		} else {
			System.out.println("Table already exists");
		}
		return true;

	}

	/**
	 * This api will insert entity into table
	 * 
	 * @param tableClient
	 * @param tableName
	 * @return
	 */
	public boolean insertAzureTableEntity(CloudTableClient tableClient, String tableName) {
		// Create a new entity for sample
		JCIASTSampleEntity sampleEntity = new JCIASTSampleEntity("5");
		sampleEntity.setName("Trilok");
		// Create a table operation to insert sample entity
		// into Employee table
		TableOperation insertSample = TableOperation.insert(sampleEntity);
		// Call execute method on table client
		// so as to perform the operation
		try {
			tableClient.execute(tableName, insertSample);
			return true;
		} catch (StorageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * This api will insert\replace entity into table
	 * 
	 * @param tableClient
	 * @param tableName
	 * @return
	 */
	public boolean insertReplaceAzureTableEntity(CloudTableClient tableClient, String tableName) {
		// Create a new entity for sample
		JCIASTSampleEntity sampleEntity = new JCIASTSampleEntity("5");
		sampleEntity.setName("Trilok");
		// Create a table operation to insert sample entity
		// into Employee table
		TableOperation insertSample = TableOperation.insertOrReplace(sampleEntity);
		// Call execute method on table client
		// so as to perform the operation
		try {
			tableClient.execute(tableName, insertSample);
			return true;
		} catch (StorageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * This api will delete entity from table
	 * 
	 * @param tableClient
	 * @param tableName
	 * @return
	 */
	public boolean deleteAzureTableEntity(CloudTableClient tableClient, String tableName) {
		// Create a table operation to insert sample entity
		// into Sample table
		TableOperation findSampleEntity = TableOperation.retrieve("AAA", "0001", JCIASTSampleEntity.class);
		// Call execute method on table client
		// so as to perform the operation
		JCIASTSampleEntity sampleEntity = null;
		try {
			sampleEntity = tableClient.execute(tableName, findSampleEntity).getResultAsType();
		} catch (StorageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		// Create operation to delete the entity
		TableOperation deleteSample = TableOperation.delete(sampleEntity);
		// Call execute method on table client
		// so as to perform the delete operation
		try {
			tableClient.execute(tableName, deleteSample);
			return true;
		} catch (StorageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * This api will update entity from table
	 * 
	 * @param tableClient
	 * @param tableName
	 * @return
	 */
	public boolean updateAzureTableEntity(CloudTableClient tableClient, String tableName) {
		// Create a table operation to insert sample entity
		// into Sample table
		TableOperation findSampleEntity = TableOperation.retrieve("PO", "4", JCIASTSampleEntity.class);
		// Call execute method on table client
		// so as to perform the operation
		JCIASTSampleEntity sampleEntity = null;
		try {
			sampleEntity = tableClient.execute(tableName, findSampleEntity).getResultAsType();
		} catch (StorageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		// Update the last name
		sampleEntity.setName("Babalu Prajapat");
		;
		// Create table operation to merge entity
		TableOperation mergeEntity = TableOperation.merge(sampleEntity);
		// Call execute method on table client
		// so as to perform the merge operation
		try {
			tableClient.execute(tableName, mergeEntity);
			return true;
		} catch (StorageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * This api will read entities from table
	 * 
	 * @param tableClient
	 * @param tableName
	 * @return
	 */
	public boolean readAzureTableEntityList(CloudTableClient tableClient, String tableName) {

		try {
			// Create a filter condition where partition key is “PO”
			String partitionFilter = TableQuery.generateFilterCondition(TableConstants.PARTITION_KEY,
					QueryComparisons.EQUAL, "PO");
			// Create a filter condition where row key is less than 555
			String rowFilter = TableQuery.generateFilterCondition(TableConstants.ROW_KEY, QueryComparisons.LESS_THAN,
					"555");
			// Combine both filters with AND operator
			String filter = TableQuery.combineFilters(partitionFilter, Operators.AND, rowFilter);
			// Create a table query by specifying the table name,
			// JCIASTSampleEntity as entity and the filter expression
			// being the AND combination of the above filters
			TableQuery<JCIASTSampleEntity> query = TableQuery.from(tableName, JCIASTSampleEntity.class).where(filter);
			// Iterate over the results
			for (JCIASTSampleEntity sampleEntity : tableClient.execute(query)) {
				// process each entity
				System.out.println("Name: " + sampleEntity.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

}
