package ita.bilabonemmenteksamenback.api;


import ita.bilabonemmenteksamenback.entity.LendingAgreement;
import ita.bilabonemmenteksamenback.repository.LendingAgreementRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class LendingAgreementController {

    private LendingAgreementRepository lendingAgreementRepository;

    public LendingAgreementController(LendingAgreementRepository lendingAgreementRepository) {
        this.lendingAgreementRepository = lendingAgreementRepository;
    }


    // creates new lending agreement if the body of the request is correct
    @PostMapping("/api/createLendingAgreement")
        public LendingAgreement createLendingAgreement(@RequestBody LendingAgreement lendingAgreement){
        return lendingAgreementRepository.save(lendingAgreement);
        }

}
