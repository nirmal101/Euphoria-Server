package lk.ac.cmb.ucsc.euphoria.controller;

import lk.ac.cmb.ucsc.euphoria.dto.DistrictCountDTO;
import lk.ac.cmb.ucsc.euphoria.dto.EmotionCountDTO;
import lk.ac.cmb.ucsc.euphoria.dto.GenderCountDTO;
import lk.ac.cmb.ucsc.euphoria.dto.YearCountDTO;
import lk.ac.cmb.ucsc.euphoria.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/charts")
@RestController
@CrossOrigin
public class StatsController {
    @Autowired
    private ChartService chartService;

    @GetMapping(path = "/getdistrict", produces = "application/json")
    @CrossOrigin
    public List<DistrictCountDTO> getDistrictCount() {
        System.out.println("controller");
       return chartService.getDistrictCount();
    }

    @GetMapping(path = "/getgender", produces = "application/json")
    @CrossOrigin
    public List<GenderCountDTO> getGenderCount() {
        System.out.println("controller");
       return chartService.getGenderCount();
    }
    @GetMapping(path = "/getyear", produces = "application/json")
    @CrossOrigin
    public List<YearCountDTO> getYearCount() {
        System.out.println("controller");
       return chartService.getYearCount();
    }
    @GetMapping(path = "/getemotions", produces = "application/json")
    @CrossOrigin
    public List<EmotionCountDTO> getEmotionCount() {
        System.out.println("controller");
       return chartService.getEmotionCount();
    }
}
