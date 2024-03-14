package DI;

import com.example.mylabandroid.ArticleAdapter;
import com.example.mylabandroid.ArticleListFragment;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class FragmentsModule {
    @Provides
    public static ArticleAdapter provideArticleAdapter() {
        return new ArticleAdapter();
    }

    @Provides
    public static ArticleListFragment provideArticleListFragment(ArticleAdapter articleAdapter) {
        return new ArticleListFragment(articleAdapter);
    }
}
