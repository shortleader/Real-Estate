package com.budong.controller;

import com.budong.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 	Root Controller
 */
@Controller
@RequestMapping(R.controller.main)
public class MainController {
    private final Logger log = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(R.mapping.INDEX)
    public String goToMainIndex() {
        return R.path.INDEX;
    }
}
	