package ru.gbuac.controller.doc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.gbuac.model.Doc;
import ru.gbuac.to.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = DocRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class DocRestController extends AbstractDocRestController {
    public static final String REST_URL = "/rest/profile/docs";

    @Autowired
    ServletContext context;

    @Override
    @GetMapping(value = "/counters")
    public Map<String, Integer> getCounters() {
        return super.getCounters();
    }

    @Override
    @GetMapping(value = "/{id}")
    public DocTo getFull(@PathVariable("id") int id, HttpSession session) {
        return super.getFull(id, session);
    }

    @Override
    @GetMapping(value = "/agreement")
    public List<Doc> getAllAgreement(HttpSession session) {
        return super.getAllAgreement(session);
    }

    @Override
    @GetMapping(value = "/agreementMoreDeadlineByUserName")
    public List<Doc> getAllAgreementMoreDeadlineByUserName(HttpSession session) {
        return super.getAllAgreementMoreDeadlineByUserName(session);
    }

    @Override
    @GetMapping(value = "/agreementLessDeadlineByUserName")
    public List<Doc> getAllAgreementLessDeadlineByUserName(HttpSession session) {
        return super.getAllAgreementLessDeadlineByUserName(session);
    }

    @Override
    @GetMapping(value = "/agreementMoreDeadlineByDepartment")
    public List<Doc> getAllAgreementMoreDeadlineByDepartment(HttpSession session) {
        return super.getAllAgreementMoreDeadlineByDepartment(session);
    }

    @Override
    @GetMapping(value = "/agreementLessDeadlineByDepartment")
    public List<Doc> getAllAgreementLessDeadlineByDepartment(HttpSession session) {
        return super.getAllAgreementLessDeadlineByDepartment(session);
    }

    @Override
    @GetMapping(value = "/agreed")
    public List<Doc> getAllAgreed(HttpSession session) {
        return super.getAllAgreed(session);
    }

    @Override
    @GetMapping(value = "/registered")
    public List<Doc> getAllRegistered(HttpSession session) {
        return super.getAllRegistered(session);
    }

    @Override
    @GetMapping(value = "/inwork")
    public List<DocItemTo> getAllInWorkByUserName(HttpSession session) {
        return super.getAllInWorkByUserName(session);
    }

    @Override
    @GetMapping(value = "/inworkMoreDeadlineByUserName")
    public List<DocItemTo> getAllInWorkMoreDeadlineByUserName(HttpSession session) {
        return super.getAllInWorkMoreDeadlineByUserName(session);
    }

    @Override
    @GetMapping(value = "/inworkLessDeadlineByUserName")
    public List<DocItemTo> getAllInWorkLessDeadlineByUserName(HttpSession session) {
        return super.getAllInWorkLessDeadlineByUserName(session);
    }

    @Override
    @GetMapping(value = "/inworkMoreDeadlineByDepartment")
    public List<DocItemTo> getAllInWorkMoreDeadlineByDepartment(HttpSession session) {
        return super.getAllInWorkMoreDeadlineByDepartment(session);
    }

    @Override
    @GetMapping(value = "/inworkLessDeadlineByDepartment")
    public List<DocItemTo> getAllInWorkLessDeadlineByDepartment(HttpSession session) {
        return super.getAllInWorkLessDeadlineByDepartment(session);
    }

    @Override
    @GetMapping(value = "/distribution")
    public List<DocItemTo> getAllDistribution(HttpSession session) {
        return super.getAllDistribution(session);
    }

    @Override
    @GetMapping(value = "/distributionMoreDeadlineByChiefUserName")
    public List<DocItemTo> getAllDistributionMoreDeadlineByChiefUserName(HttpSession session) {
        return super.getAllDistributionMoreDeadlineByChiefUserName(session);
    }

    @Override
    @GetMapping(value = "/distributionLessDeadlineByChiefUserName")
    public List<DocItemTo> getAllDistributionLessDeadlineByChiefUserName(HttpSession session) {
        return super.getAllDistributionLessDeadlineByChiefUserName(session);
    }

    @Override
    @GetMapping(value = "/distributionMoreDeadlineByDepartment")
    public List<DocItemTo> getAllDistributionMoreDeadlineByDepartment(HttpSession session) {
        return super.getAllDistributionMoreDeadlineByDepartment(session);
    }

    @Override
    @GetMapping(value = "/distributionLessDeadlineByDepartment")
    public List<DocItemTo> getAllDistributionLessDeadlineByDepartment(HttpSession session) {
        return super.getAllDistributionLessDeadlineByDepartment(session);
    }

    @Override
    @GetMapping(value = "/distributed")
    public List<DocItemTo> getAllDistributed(HttpSession session) {
        return super.getAllDistributed(session);
    }

    @Override
    @GetMapping(value = "/atThisMounthOnControl")
    public List<DocItemTo> getAllAtThisMonthOnControl(HttpSession session) {
        return super.getAllAtThisMonthOnControl(session);
    }

    @Override
    @GetMapping(value = "/atThisMounthOnControlCompletedInTime")
    public List<DocItemTo> getAllAtThisMonthOnControlCompletedInTime(HttpSession session) {
        return super.getAllAtThisMonthOnControlCompletedInTime(session);
    }

    @Override
    @GetMapping(value = "/atThisMounthOnControlCompletedAfterTime")
    public List<DocItemTo> getAllAtThisMonthOnControlCompletedAfterTime(HttpSession session) {
        return super.getAllAtThisMonthOnControlCompletedAfterTime(session);
    }

    @Override
    @GetMapping(value = "/atThisMounthOnControlNotCompleted")
    public List<DocItemTo> getAllAtThisMonthOnControlNotCompleted(HttpSession session) {
        return super.getAllAtThisMonthOnControlNotCompleted(session);
    }

    @Override
    @GetMapping(value = "/regnumbers")
    public List<DocNumberTo> getRegNumbers() {
        return super.getRegNumbers();
    }


    @Override
    @GetMapping
    public List<DocItemTo> getAll() {
        return super.getAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public DocTo updateOrCreate(@Valid @RequestBody DocTo docTo, HttpSession session) {
        if (docTo.isNew()) {
            return super.create(docTo, context.getRealPath("/"), session);
        } else {
            return super.update(docTo, docTo.getId(), context.getRealPath("/"), session);
        }
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @Override
    @PostMapping(value = "/rejectDocAgreement/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public DocTo rejectDocAgreement(@PathVariable("id")int id, @RequestParam("comment") String comment, HttpSession session) {
        return super.rejectDocAgreement(id, comment, session);
    }

    @PostMapping(value = "/uploadfile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public FileTo uploadFile(@RequestParam("inputFile") MultipartFile inputFile) {
        return super.uploadFile(inputFile, context.getRealPath("/"));
    }

    @PostMapping(value = "/docx", consumes = MediaType.APPLICATION_JSON_VALUE)
    public FileTo createDocx(@Valid @RequestBody DocTo docTo) {
        return super.createDocx(docTo, context.getRealPath("/"));
    }

    @PostMapping(value = "/pdf", consumes = MediaType.APPLICATION_JSON_VALUE)
    public FileTo createPDF(@Valid @RequestBody DocTo docTo) {
        return super.createPDF(docTo, context.getRealPath("/"));
    }

}
