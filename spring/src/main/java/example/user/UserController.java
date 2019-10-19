package example.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RequestMapping("/users")
@RestControllerAdvice
public class UserController {

    @PostMapping("something")
    public User getSomething(@RequestBody User someone) {
        log.debug("data :: {}", someone);
        return someone;
    }

}
