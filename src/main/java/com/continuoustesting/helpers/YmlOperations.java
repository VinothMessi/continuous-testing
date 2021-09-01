package com.continuoustesting.helpers;

import com.google.common.io.Resources;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.Map;

@Lazy
@Component
public
class YmlOperations {

    static Map<?, ?> property;

    public
    void read(String filePath, String fileName) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(ResourceUtils.getFile(
                    filePath + fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Yaml yaml = new Yaml();
        property = yaml.load(inputStream);
    }

    public
    Object getValue(String key) {
        Map<?, ?> map = (Map<?, ?>) property.get(key.split("\\.")[0]);
        return map.get(key.split("\\.")[1]);
    }

    public
    String get(String key) {
        Map<?, ?> map = (Map<?, ?>) property.get(key.split("\\.")[0]);
        return map.get(key.split("\\.")[1]).toString();
    }
}