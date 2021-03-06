package net.faintedge.mangaedenclient;

import java.net.URI;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 */
@Data
@NoArgsConstructor
public class Chapter {

  private int number;
  private long date;
  private String title;
  private String id;

  public Chapter(int number, long date, String title, String id) {
    this.number = number;
    this.date = date;
    this.title = title;
    this.id = id;
  }

  /**
   * @param mangaDetails details of the manga that this chapter belongs to
   * @param page page number (starts from 1)
   * @return the URI of the chapter page
   */
  public URI getPageURI(MangaDetails mangaDetails, int page) {
    return MangaEden.chapter2PageURI(this, mangaDetails, page);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Chapter{");
    sb.append("number=").append(number);
    sb.append(", date=").append(date);
    sb.append(", title='").append(title).append('\'');
    sb.append(", id='").append(id).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
