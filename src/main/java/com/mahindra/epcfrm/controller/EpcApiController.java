/**
 * 
 */
package com.mahindra.epcfrm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Raju.Addu
 *
 */

@RestController
public class EpcApiController {

    @GetMapping("/")
    public String welcome() {
        return "Welcome to EPC !!";
    }

}
