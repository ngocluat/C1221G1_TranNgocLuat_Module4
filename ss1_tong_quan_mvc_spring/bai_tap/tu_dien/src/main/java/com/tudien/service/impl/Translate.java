package com.tudien.service.impl;

import com.tudien.service.ITranslate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Translate implements ITranslate {
    @Override
    public String StringTranslate(String englist) {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");
        dictionary.put("an", "học giỏi nhất nhà");
        dictionary.put("hoang", "học siêng nhất nhà");
        dictionary.put("err", "Không tìm Thấy");
        return dictionary.get(englist);
    }
}
