package DI;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import dataaccess.SchedulerProvider;
import dataaccess.interfaces.ApiService;
import dataaccess.interfaces.ArticleRepository;
import dataaccess.repositories.ArticleRepositoryImpl;

@Module
@InstallIn(SingletonComponent.class)
public class RepositoryModule {
    @Provides
    public static ArticleRepository provideArticleRepository(ApiService apiService, SchedulerProvider schedulerProvider) {
        return new ArticleRepositoryImpl(apiService, schedulerProvider);
    }
}