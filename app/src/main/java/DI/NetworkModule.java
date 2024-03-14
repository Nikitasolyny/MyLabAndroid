package DI;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import dataaccess.HttpClient;
import dataaccess.SchedulerProvider;
import dataaccess.interfaces.ApiService;

@Module
@InstallIn(SingletonComponent.class)
public class NetworkModule {
    @Provides
    public static ApiService provideApiService() {
        return new HttpClient().retrofit().create(ApiService.class);
    }

    @Provides
    public static SchedulerProvider provideSchedulerProvider() {
        return new SchedulerProvider();
    }
}
