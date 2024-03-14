package dataaccess.interfaces;

import dataaccess.ArticleResultsDTO;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("articles")
        Observable<ArticleResultsDTO> getArticles(@Query("limit") int limit, @Query("offset") int offset);
}
