package org.fornever.koala.bindings;

import org.fornever.koala.Koala;
import org.fornever.koala.bindings.annotations.Config;
import org.fornever.koala.bindings.annotations.LocalDataSource;
import org.fornever.koala.bindings.annotations.RemoteDataSource;
import org.fornever.koala.bindings.annotations.Syncer;
import org.fornever.koala.bindings.annotations.Validator;
import org.fornever.koala.blurprints.IDataSource;
import org.fornever.koala.blurprints.ISyncer;
import org.fornever.koala.blurprints.IValidator;
import org.fornever.koala.type.KoalaConfig;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Provider;

public class KoalaFactory extends AbstractModule {

	private Provider<? extends IDataSource> localDataSourceProvider;

	private Provider<? extends IDataSource> remoteDataSourceProvider;

	private Class<? extends ISyncer> syncerClass;

	private Class<? extends IValidator> validatorClass;

	private KoalaConfig config;

	public KoalaFactory() {
		super();
	}

	public static KoalaFactory New() {
		return new KoalaFactory();
	}

	public KoalaFactory(Provider<? extends IDataSource> localDataSourceProvider,
			Provider<? extends IDataSource> remoteDataSourceProvider, Class<? extends ISyncer> syncerClass,
			Class<? extends IValidator> validatorClass, KoalaConfig config) {
		super();
		this.localDataSourceProvider = localDataSourceProvider;
		this.remoteDataSourceProvider = remoteDataSourceProvider;
		this.syncerClass = syncerClass;
		this.validatorClass = validatorClass;
		this.config = config;
	}

	public Koala build() {
		return Guice.createInjector(this).getInstance(Koala.class);
	}

	public Class<? extends ISyncer> getSyncerClass() {
		return syncerClass;
	}

	public void setSyncerClass(Class<? extends ISyncer> syncerClass) {
		this.syncerClass = syncerClass;
	}

	public Class<? extends IValidator> getValidatorClass() {
		return validatorClass;
	}

	public void setValidatorClass(Class<? extends IValidator> validatorClass) {
		this.validatorClass = validatorClass;
	}

	public KoalaConfig getConfig() {
		return config;
	}

	public void setConfig(KoalaConfig config) {
		this.config = config;
	}

	@Override
	protected void configure() {
		bind(IDataSource.class).annotatedWith(LocalDataSource.class).toProvider(this.localDataSourceProvider);
		bind(IDataSource.class).annotatedWith(RemoteDataSource.class).toProvider(this.remoteDataSourceProvider);
		bind(ISyncer.class).annotatedWith(Syncer.class).to(this.syncerClass);
		bind(IValidator.class).annotatedWith(Validator.class).to(this.validatorClass);
		bind(KoalaConfig.class).annotatedWith(Config.class).toInstance(this.config);
	}

	public Provider<? extends IDataSource> getLocalDataSourceProvider() {
		return localDataSourceProvider;
	}

	public void setLocalDataSourceProvider(Provider<? extends IDataSource> localDataSourceProvider) {
		this.localDataSourceProvider = localDataSourceProvider;
	}

	public Provider<? extends IDataSource> getRemoteDataSourceProvider() {
		return remoteDataSourceProvider;
	}

	public void setRemoteDataSourceProvider(Provider<? extends IDataSource> remoteDataSourceProvider) {
		this.remoteDataSourceProvider = remoteDataSourceProvider;
	}

}
