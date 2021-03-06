package net.faintedge.mangaedenclient;

import java.net.URI;

/**
 *
 */
public class MangaEden {

  public static final URI BASE_URI = URI.create("http://www.mangaeden.com");

  public static URI mangaDetails2URI(MangaDetails mangaDetails) {
    return URI.create("http://www.mangaeden.com/en-manga/" + mangaDetails.getAlias() + "/");
  }

  public static URI chapterPage2ImageURI(ChapterPage chapterPage) {
    return URI.create("http://cdn.mangaeden.com/mangasimg/" + chapterPage.getImage());
  }

  public static URI chapter2PageURI(Chapter chapter, MangaDetails mangaDetails, int page) {
    return URI.create(String.format("http://www.mangaeden.com/en-manga/%s/%d/%d",
      mangaDetails.getAlias(), chapter.getNumber(), page));
  }
}
