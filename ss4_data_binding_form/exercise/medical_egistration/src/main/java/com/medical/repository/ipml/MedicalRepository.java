package com.medical.repository.ipml;

import com.medical.model.Medical;
import com.medical.repository.IRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class MedicalRepository implements IRepository {

    static List<Medical> medicals= new ArrayList<>();
    static {
        medicals.add(new Medical("Traanf NgocjLuaatj ","1090/05/4","nam", "VietNam","3468541465","xe mays ","92N1-19390","12/12/2022","13/12/2022","khoong ddi qua vung co dich"));
        medicals.add(new Medical("Traanf NgocjLuaatj ","1090/05/4","nam", "VietNam","3468541465","xe mays ","92N1-19390","12/12/2022","13/12/2022","khoong ddi qua vung co dich"));
        medicals.add(new Medical("Traanf NgocjLuaatj ","1090/05/4","nam", "VietNam","3468541465","xe mays ","92N1-19390","12/12/2022","13/12/2022","khoong ddi qua vung co dich"));
        medicals.add(new Medical("Traanf NgocjLuaatj ","1090/05/4","nam", "VietNam","3468541465","xe mays ","92N1-19390","12/12/2022","13/12/2022","khoong ddi qua vung co dich"));
        medicals.add(new Medical("Traanf NgocjLuaatj ","1090/05/4","nam", "VietNam","3468541465","xe mays ","92N1-19390","12/12/2022","13/12/2022","khoong ddi qua vung co dich"));
    }

    @Override
    public List<Medical> medicalList() {
        return medicals;
    }

    @Override
    public void addInformationMedical(Medical medical) {
        medicals.add(medical);
    }
}
