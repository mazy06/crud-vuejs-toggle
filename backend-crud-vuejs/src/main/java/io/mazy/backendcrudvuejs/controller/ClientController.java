package io.mazy.backendcrudvuejs.controller;

import io.mazy.backendcrudvuejs.model.Patient;
import io.mazy.backendcrudvuejs.repository.PatientRepository;
import io.mazy.backendcrudvuejs.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class ClientController {

    @Autowired
    private PatientService patientService;
    @Autowired
    private PatientRepository patientRepository;

    @RequestMapping("/")
    public String healthCheck(){
        return "Health check";
    }

    @PostMapping("/add")
    public String addPatient(@RequestBody Patient patient){
        patientService.addPatient(patient);
        return "Patient added successfully...";
    }

    @RequestMapping("/patient/{id}")
    public Patient getPatientById(@PathVariable("id") long id){
        return patientService.getPatientById(id);
    }

    @RequestMapping("/patients")
    public List<Patient> getPatients(){
        return patientService.getPatients();
    }

    @PutMapping("/patient")
    public Patient updatePatient(@RequestBody Patient patient){
        return patientService.updatePatient(patient);
    }

    @DeleteMapping("/patient/{id}")
    public String deletePatient(@PathVariable("id") long id){
        patientService.deletePatient(id);
        return "Patient deleted";
    }

}
