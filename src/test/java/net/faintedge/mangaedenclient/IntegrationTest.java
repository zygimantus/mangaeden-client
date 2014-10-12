package net.faintedge.mangaedenclient;

import com.google.common.collect.Iterables;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class IntegrationTest {

  private static final Logger LOG = LoggerFactory.getLogger(IntegrationTest.class);

  @Test
  public void testAll() throws Exception {
    MangaEdenClient client = new MangaEdenClient();

    // test MangaEdenClient.getMangaList()
    List<Manga> mangaList = client.getMangaList();
    Assert.assertFalse(mangaList.isEmpty());

    Iterable<Manga> limitedMangaList = Iterables.limit(mangaList, 10);
    for (Manga manga : limitedMangaList) {
      LOG.info(manga.toString());
    }

    // test MangaEdenClient.getMangaDetails()
    String mangaId = mangaList.get(0).getId();
    MangaDetails mangaDetails = client.getMangaDetails(mangaId);
    Assert.assertNotNull(mangaDetails);
    Assert.assertNotNull(mangaDetails.getChapters());

    LOG.info(mangaDetails.toString());
    Chapter[] chapters = mangaDetails.getChapters();
    for (int i = 0; i < Math.min(chapters.length, 10); i++) {
      LOG.info(chapters[i].toString());
    }

    // test MangaEdenClient.getMangaList()
    ChapterDetails chapterDetails = client.getChapterDetails(mangaDetails.getChapters()[0].getId());
    Assert.assertNotNull(chapterDetails);
    Assert.assertNotNull(chapterDetails.getPages());

    ChapterPage[] pages = chapterDetails.getPages();
    for (int i = 0; i < Math.min(pages.length, 10); i++) {
      LOG.info(pages[i].toString());
    }
  }
}
