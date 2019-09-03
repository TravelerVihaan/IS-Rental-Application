package onet.grupa.isrentalapplication.service.computers;

import onet.grupa.isrentalapplication.domain.computers.Computer;
import onet.grupa.isrentalapplication.repository.computers.ComputerRepository;
import onet.grupa.isrentalapplication.service.HttpStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Service
public class ComputerAddService {

    private ComputerRepository computerRepository;
    private Validator validator;

    @Autowired
    public ComputerAddService(ComputerRepository computerRepository,
                              Validator validator) {
        this.computerRepository = computerRepository;
        this.validator = validator;
    }

    /**
     * Method saving computer object to database after validate all properties
     * @param computer is an object which will be converted to db entity
     * @return HttpStatusEnum with status depending on result of insert entity to DB,
     *      can return BAD_REQUEST if result has errors
     *      CONFLICT if entity has already exists
     *      CREATED if entity was saved in DB
     */
    public HttpStatusEnum addNewComputer(Computer computer){
        Set<ConstraintViolation<Computer>> validationErrors = validator.validate(computer);
        if(!validationErrors.isEmpty())
            return HttpStatusEnum.BADREQUEST;
        if(computerRepository.findByOtnumber(computer.getOtnumber())!=null)
            return HttpStatusEnum.CONFLICT;

        computerRepository.save(computer);
        return HttpStatusEnum.CREATED;
    }
}
