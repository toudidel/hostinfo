package photos.kozlowski.krzysztof.hostinfo.controller.model;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class HostInfo {

  private LocalDateTime date;
  private String hostname;
  private String ip;
  private String clientHostname;
  private String clientIp;
}
