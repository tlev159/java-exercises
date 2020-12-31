package isahasa;

import java.nio.charset.StandardCharsets;

public class Client {

  private Channel channel;

  public Client(Channel channel) {
    this.channel = channel;
  }

  public void writeToChannel(TextSource textSource) {
    channel.writeByte(textSource.getPlainText().getBytes(StandardCharsets.UTF_8));
  }
}
