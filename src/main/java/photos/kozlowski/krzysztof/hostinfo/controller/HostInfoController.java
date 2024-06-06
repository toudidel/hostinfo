package photos.kozlowski.krzysztof.hostinfo.controller;

import jakarta.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import photos.kozlowski.krzysztof.hostinfo.controller.model.HostInfo;

@Slf4j
@RestController
public class HostInfoController {

  @GetMapping("/")
  public ResponseEntity<HostInfo> getHostInfo(HttpServletRequest request) {
    String hostname = "unknown";
    String hostAddress = "unknown";
    String clientHostname = "unknown";
    String clientIp = "unknown";

    try {
      hostname = InetAddress.getLocalHost().getHostName();
      hostAddress = InetAddress.getLocalHost().getHostAddress();
      clientHostname = InetAddress.getLoopbackAddress().getHostName();
      clientIp = InetAddress.getLoopbackAddress().getHostAddress();
    } catch (UnknownHostException e) {
      log.error(e.getMessage(), e);
    }

    HostInfo hostInfo =
        HostInfo.builder()
            .date(LocalDateTime.now())
            .hostname(hostname)
            .ip(hostAddress)
            .clientHostname(clientHostname)
            .clientIp(clientIp)
            .build();

    log.info(hostInfo.toString());

    return ResponseEntity.ok(hostInfo);
  }
}
