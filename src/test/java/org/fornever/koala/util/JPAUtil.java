package org.fornever.koala.util;

import com.google.common.collect.ImmutableMap;
import org.hibernate.dialect.H2Dialect;
import org.hibernate.jpa.HibernatePersistenceProvider;

import javax.persistence.EntityManager;
import javax.persistence.SharedCacheMode;
import javax.persistence.ValidationMode;
import javax.persistence.spi.ClassTransformer;
import javax.persistence.spi.PersistenceUnitInfo;
import javax.persistence.spi.PersistenceUnitTransactionType;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import static org.hibernate.cfg.AvailableSettings.*;

public class JPAUtil {

	private static PersistenceUnitInfo archiverPersistenceUnitInfo() {
		return new PersistenceUnitInfo() {
			@Override
			public String getPersistenceUnitName() {
				return "ApplicationPersistenceUnit";
			}

			@Override
			public String getPersistenceProviderClassName() {
				return "org.hibernate.jpa.HibernatePersistenceProvider";
			}

			@Override
			public PersistenceUnitTransactionType getTransactionType() {
				return PersistenceUnitTransactionType.RESOURCE_LOCAL;
			}

			@Override
			public DataSource getJtaDataSource() {
				return null;
			}

			@Override
			public DataSource getNonJtaDataSource() {
				return null;
			}

			@Override
			public List<String> getMappingFileNames() {
				return Collections.emptyList();
			}

			@Override
			public List<URL> getJarFileUrls() {
				try {
					return Collections.list(this.getClass()
							.getClassLoader()
							.getResources(""));
				} catch (IOException e) {
					throw new UncheckedIOException(e);
				}
			}

			@Override
			public URL getPersistenceUnitRootUrl() {
				return null;
			}

			@Override
			public List<String> getManagedClassNames() {
				return Collections.emptyList();
			}

			@Override
			public boolean excludeUnlistedClasses() {
				return false;
			}

			@Override
			public SharedCacheMode getSharedCacheMode() {
				return null;
			}

			@Override
			public ValidationMode getValidationMode() {
				return null;
			}

			@Override
			public Properties getProperties() {
				return new Properties();
			}

			@Override
			public String getPersistenceXMLSchemaVersion() {
				return null;
			}

			@Override
			public ClassLoader getClassLoader() {
				return null;
			}

			@Override
			public void addTransformer(ClassTransformer transformer) {

			}

			@Override
			public ClassLoader getNewTempClassLoader() {
				return null;
			}
		};
	}

	public static EntityManager createH2EntityManager() {

		return new HibernatePersistenceProvider().createContainerEntityManagerFactory(archiverPersistenceUnitInfo(),
				ImmutableMap.<String, Object>builder()
						.put(JPA_JDBC_DRIVER, "org.h2.Driver")
						.put(JPA_JDBC_URL, "jdbc:h2:mem:test;TRACE_LEVEL_FIle=4")
						.put(DIALECT, H2Dialect.class)
						.put(HBM2DDL_AUTO, "create-drop")
						.put(SHOW_SQL, false)
						.put(QUERY_STARTUP_CHECKING, false)
						.put(GENERATE_STATISTICS, false)
						.put(USE_REFLECTION_OPTIMIZER, false)
						.put(USE_SECOND_LEVEL_CACHE, false)
						.put(USE_QUERY_CACHE, false)
						.put(USE_STRUCTURED_CACHE, false)
						.build()
		).createEntityManager();

	}

}
