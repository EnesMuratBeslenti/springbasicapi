package com.example.demo.control;

import com.example.demo.AlienRepo;
import com.example.demo.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
public class  AilenControl {
    @Autowired
    AlienRepo repo;

@RequestMapping("/")
    public String home (){
        return "home.jsp.xhtml";
}
@RequestMapping("/addAlien")
    public String addAlien(Alien alien){
     repo.save(alien);
    return "home.jsp.xhtml";
    }
    @DeleteMapping(path = "/alien/{aid}")
    public String deleteAlien(@PathVariable int aid){
    Alien a = repo.getById(aid);
    repo.delete(a);
    return  "deleted";
    }

    //All show databases
    @RequestMapping("/alien")
    @ResponseBody
    public String getAliens(){

        return repo.findAll().toString();
    }
    //Show in /{id}
    @RequestMapping("/alien/{aid}")
    @ResponseBody
    public String getAlien(@PathVariable("aid")int aid){

        return repo.findById( aid).toString();
    }

              //JPA FORMAT
    @RequestMapping(path ="/aliens",produces = {"application/xml"})
    @ResponseBody
    public List<Alien> getAlienss(){

        return repo.findAll();
    }
    // JPA FORMAT  Show {aid}
    @RequestMapping("/aliens/{aid}")
    @ResponseBody
    public Optional<Alien> getAliensss(@PathVariable("aid")int aid){

        return repo.findById(aid);
    }
    //PostMaping
    @PostMapping(path ="/aliens")
    public Alien addAlienpost(@RequestBody Alien alien){
        repo.save(alien);
        return  alien;
    }

    @GetMapping(path ="/aliens")
    public List<Alien> getAliensget(){

        return repo.findAll();
    }
    //PutMapping
    @PutMapping(path ="/aliens")
    public Alien saveOrupdateAliens(@RequestBody Alien alien){
        repo.save(alien);
        return  alien;
    }


}
