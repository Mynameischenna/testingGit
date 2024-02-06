package com.example.firstt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.InputSource;

import com.sun.xml.txw2.Document;
import java.io.StringReader;
import java.time.LocalDate;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;




@RestController
@CrossOrigin("*")
public class PlanInfoController {

    @Autowired
    private repo planInfoRepository;

    @GetMapping
    public List<PlanInfo> getAllPlanInfo() {
        return planInfoRepository.findAll();
    }

    @GetMapping("/{id}")
    public PlanInfo getPlanInfoById(@PathVariable String id) {
        return planInfoRepository.findById(id).orElse(null);
    }

//    @PostMapping
//    public PlanInfo createPlanInfo(@RequestBody PlanInfo planInfo) {
//        return planInfoRepository.save(planInfo);
//    }
    
    @PostMapping("/xml")
    public ResponseEntity<String> createPlanInfoFromXml(@RequestBody String xmlData) {
        try {
            // Parse XML data
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            org.w3c.dom.Document document = builder.parse(new InputSource(new StringReader(xmlData)));

            // Extract data from XML
            Element planInfoElement = (Element) document.getElementsByTagName("plan_info").item(0);

            PlanInfo planInfo = new PlanInfo();
            planInfo.setEvId(getChildElementValue(planInfoElement, "ev_id"));
            planInfo.setPlanName(getChildElementValue(planInfoElement, "plan_name"));
            planInfo.setIrsrlCode(getChildElementValue(planInfoElement, "irsrl_code"));
            planInfo.setProvCompany(getChildElementValue(planInfoElement, "prov_company"));
            planInfo.setProdId(getChildElementValue(planInfoElement, "prod_id"));
            planInfo.setStatusCode(getChildElementValue(planInfoElement, "status_code"));
            planInfo.setDpDateTime(getChildElementValue(planInfoElement, "dpdate_time"));
            planInfo.setRolloverInd(getChildElementValue(planInfoElement, "rollover_ind"));
            planInfo.setGaId(getChildElementValue(planInfoElement, "ga_id"));
            planInfo.setClientName(getChildElementValue(planInfoElement, "client_name"));
            planInfo.setFirstLineMailing(getChildElementValue(planInfoElement, "first_line_mailing"));
            planInfo.setScndLineMailing(getChildElementValue(planInfoElement, "scnd_line_mailing"));
            planInfo.setCity(getChildElementValue(planInfoElement, "city"));
            planInfo.setStateCode(getChildElementValue(planInfoElement, "state_code"));
            planInfo.setZipCode(getChildElementValue(planInfoElement, "zip_code"));
            planInfo.setCountry(getChildElementValue(planInfoElement, "country"));
            planInfo.setInternalComplianceInd(getChildElementValue(planInfoElement, "internal_compliance_ind"));
            planInfo.setPlanAnnivDate(getChildElementValue(planInfoElement, "plan_anniv_date"));
            planInfo.setEstNumberOfParticipants(Integer.parseInt(getChildElementValue(planInfoElement, "est_number_of_participants")));
            planInfo.setEstPlanAssets(Long.parseLong(getChildElementValue(planInfoElement, "est_plan_assets")));
            planInfo.setEstImplementationDate(LocalDate.parse(getChildElementValue(planInfoElement, "est_implementation_date")));
            planInfo.setSubsetCashCode(getChildElementValue(planInfoElement, "subset_cash_code"));
            planInfo.setClientEntityType(getChildElementValue(planInfoElement, "client_entity_type"));
            planInfo.setTpaFirmId(getChildElementValue(planInfoElement, "tpa_firm_id"));

            // Save to the database
            planInfoRepository.save(planInfo);

            return new ResponseEntity<>("Data inserted successfully!", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error processing XML data", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Utility method to extract text content of a child element
    private String getChildElementValue(Element parentElement, String childTagName) {
        NodeList childNodes = parentElement.getElementsByTagName(childTagName);
        if (childNodes.getLength() > 0) {
            return childNodes.item(0).getTextContent();
        }
        return null;
    }


    @PutMapping("/{id}")
    public PlanInfo updatePlanInfo(@PathVariable String id, @RequestBody PlanInfo updatedPlanInfo) {
        return planInfoRepository.findById(id).map(planInfo -> {
            planInfo.setEvId(updatedPlanInfo.getEvId());
            planInfo.setPlanName(updatedPlanInfo.getPlanName());
            planInfo.setIrsrlCode(updatedPlanInfo.getIrsrlCode());
            // ... continue setting other fields

            return planInfoRepository.save(planInfo);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletePlanInfo(@PathVariable String id) {
        planInfoRepository.deleteById(id);
    }
}

