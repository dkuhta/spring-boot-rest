package ch.loyalty.amopp.ip;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MainController {

    @Value("${version}")
    private String version;

    @RequestMapping(value = "/version", method = RequestMethod.GET)
    public VersionDto version(@RequestParam(value="name", defaultValue="World") String name) {
        return new VersionDto(version);
    }

    @RequestMapping(value = "/execute", method = RequestMethod.POST)
    public ResponseDto greeting(@RequestBody RequestDto requestDto) {
        return new ResponseDto();
    }
}
