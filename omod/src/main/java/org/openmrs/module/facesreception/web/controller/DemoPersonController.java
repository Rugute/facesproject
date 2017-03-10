package org.openmrs.module.facesreception.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Concept;
import org.openmrs.api.context.Context;
import org.openmrs.module.facesreception.DemoPerson;
import org.openmrs.module.facesreception.FacesReception;
import org.openmrs.module.facesreception.api.FacesReceptionService;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by rugute on 3/10/17.
 */
public class DemoPersonController {

    protected final Log log = LogFactory.getLog(getClass());

   // @RequestMapping(value = "/module/facesreception/manage", method = RequestMethod.GET)
   // public void manage(ModelMap model) {
   //     model.addAttribute("user", Context.getAuthenticatedUser());
   // }

    @RequestMapping(value = "/module/facesreception/patientslist", method = RequestMethod.POST)
    public void getConcepts(ModelMap model, @RequestParam(value="StartDate",required=true) String StartDate,@RequestParam(value="EndDate",required=true) String EndDate) {
       try {
           SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

           FacesReceptionService service = Context.getService(FacesReceptionService.class);
            List<DemoPerson> listOfPatiensts = service.getPersonList(sdf.parse(StartDate),sdf.parse(EndDate));
           //model.addAttribute("conceptList", Context.getConceptService().getConceptsByName(searchStr));
           model.addAttribute("PatientsList",listOfPatiensts);// service.getPersonDetails(sdf.parse(StartDate), sdf.parse(EndDate)));
       }
       catch (Exception ex){
           ex.printStackTrace();
       }
    }
}
