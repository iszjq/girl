package cc.izjq.girl.service;

import cc.izjq.girl.domain.Girl;
import cc.izjq.girl.enums.ResultEnum;
import cc.izjq.girl.exception.GirlException;
import cc.izjq.girl.reporsitory.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("F");
        girlA.setAge(18);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("F");
        girlB.setAge(20);
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) {
        Girl girl = girlRepository.getOne(id);
        Integer age = girl.getAge();
        if (age < 10) {
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age < 16 && age > 10) {
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    /**
     * 通过ID查询一个女生的信息
     *
     * @param id
     * @return
     */
    public Girl findOne(Integer id) {
        return girlRepository.getOne(id);
    }
}
