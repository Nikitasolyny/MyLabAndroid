package com.example.mylabandroid;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import dataaccess.ArticleDTO;

public class ArticleDTOTest {

    @Test
    public void testDateFormatters() {
        ArticleDTO article = new ArticleDTO();
        article.setPublishedAt("2022-01-01T12:00:00Z");
        article.setUpdatedAt("2022-01-02T12:00:00.000000Z");

        assertEquals("01 January 2022, 12:00:00", article.getPublishedAt());
        assertEquals("02 January 2022, 12:00:00", article.getUpdatedAt());
    }
}
