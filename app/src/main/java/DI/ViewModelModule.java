package DI;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.FragmentComponent;
import dataaccess.SchedulerProvider;
import dataaccess.interfaces.ApiService;
import dataaccess.interfaces.ArticleRepository;
import viewModels.ArticleListViewModel;

@Module
@InstallIn(FragmentComponent.class)
public class ViewModelModule {
    @Provides
    public static ArticleListViewModel provideArticleListViewModel(ArticleRepository articleRepository) {
        return new ArticleListViewModel(articleRepository);
    }
}