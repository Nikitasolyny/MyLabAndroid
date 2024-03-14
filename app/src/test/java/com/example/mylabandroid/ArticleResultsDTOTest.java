package dataaccess;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArticleResultsDTOTest {

    @Test
    public void testGetNext() {
        String next = "https://example.com/next";

        ArticleResultsDTO articleResultsDTO = new ArticleResultsDTO();
        articleResultsDTO.setNext(next);

        String result = articleResultsDTO.getNext();

        assertEquals(next, result);
    }

    @Test
    public void testGetPrevious() {
        String previous = "https://example.com/previous";

        ArticleResultsDTO articleResultsDTO = new ArticleResultsDTO();
        articleResultsDTO.setPrevious(previous);

        String result = articleResultsDTO.getPrevious();

        assertEquals(previous, result);
    }

    @Test
    public void testGetResults() {
        // Given
        ArticleDTO[] results = {
                new ArticleDTO(),
                new ArticleDTO()
        };

        ArticleResultsDTO articleResultsDTO = new ArticleResultsDTO();
        articleResultsDTO.setResults(results);

        ArticleDTO[] result = articleResultsDTO.getResult();

        assertEquals(results.length, result.length);
        for (int i = 0; i < results.length; i++) {
            assertEquals(results[i], result[i]);
        }
    }
}