package com.chuyendoi.service.impl;

import com.chuyendoi.service.IChuyenDoi;
import org.springframework.stereotype.Service;

@Service
public class ChuyenDoi implements IChuyenDoi {
    @Override
    public Double tienTe(double vnd) {
        return vnd * 23000;
    }
}
