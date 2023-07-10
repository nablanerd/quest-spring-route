package com.wildcodeschool.doctor.controller;

import com.wildcodeschool.doctor.model.Doctor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable ;

import org.springframework.http.*;
import org.springframework.web.server.*;


@Controller
public class DoctorController {

    @GetMapping("/doctor/{number}")
    @ResponseBody
    public Doctor doctor(@PathVariable int number) {

    if(1 <= number && number <= 12)
    {
        throw new ResponseStatusException(HttpStatus.SEE_OTHER, "");

    }
    else if(number == 13)
    {
                return new Doctor(number, "Jodie Whittaker");
    }

    else
    {

    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible de récupérer l'incarnation " +Integer.toString(number));
    }
    }
}
