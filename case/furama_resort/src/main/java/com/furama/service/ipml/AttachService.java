package com.furama.service.ipml;

import com.furama.repository.IAttachSepository;
import com.furama.service.IAttachSrevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AttachService implements IAttachSrevice {


    @Autowired
    IAttachSepository iAttachSepository;
    @Override
    public List<com.furama.model.AttachService> listAttachServices() {
        return iAttachSepository.findAll();
    }
}
